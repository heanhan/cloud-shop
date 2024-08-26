package com.example.uac.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;


/**
 * spring 在spring security 5.7 以后抛弃了WebSecurityConfigurerAdapter
 * 5版本只需@Configuration一个注解，不需要 @EnableWebSecurity；Spring Boot 2.7.18 spring security 是5.7+
 * 6需要同时引入，并且5是需要extends WebSecurityConfigurerAdapter类
 */
@Configuration
public class SecurityConfig {

    @Resource
    private UserDetailsService userDetailsService;

    @Bean(name = "encoder")
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 禁用basic明文验证
            .httpBasic().disable()
            // 前后端分离架构不需要csrf保护
            .csrf().disable()
            // 禁用默认登录页
            .formLogin().disable()
            // 禁用默认登出页
            .logout().disable()
            // 设置异常的EntryPoint，如果不设置，默认使用Http403ForbiddenEntryPoint
            .exceptionHandling(exceptions -> exceptions.authenticationEntryPoint(invalidAuthenticationEntryPoint))
            // 前后端分离是无状态的，不需要session了，直接禁用。
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                    // 允许所有OPTIONS请求
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    // 允许直接访问授权登录接口
                    .requestMatchers(HttpMethod.POST, "/uac/register").permitAll()
                    // 允许 SpringMVC 的默认错误地址匿名访问
                    .requestMatchers("/error").permitAll()
                    // 其他所有接口必须有Authority信息，Authority在登录成功后的UserDetailsImpl对象中默认设置“ROLE_USER”
                    //.requestMatchers("/**").hasAnyAuthority("ROLE_USER")
                    // 允许任意请求被已登录用户访问，不检查Authority
                    .anyRequest().authenticated())
            .authenticationProvider(authenticationProvider())
            // 加我们自定义的过滤器，替代UsernamePasswordAuthenticationFilter
            .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    //配置 WebSecurity 静态资源
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ resources/**", "/ignore2");
    }


    /**
     * 登录时需要调用AuthenticationManager.authenticate执行一次校验
     * AuthenticationManager 的获取方式，这是方法一
     * 当然也可以通过  在 SecurityFilterChain  获取  如下面注释掉的方式
     * @return AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        ProviderManager pm = new ProviderManager(daoAuthenticationProvider);
        return pm;
    }

//    private AuthenticationManager authenticationManager;
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//
//        //获取AuthenticationManager
//        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
//        builder.userDetailsService(userDetailsService);
//        authenticationManager = builder.build();
//        //authorizeHttpRequests:针对http请求进行授权认证，定义不需要认证就能的资源路径，如info
//        http.authorizeHttpRequests(authorizeHttpRequests->authorizeHttpRequests
//                .requestMatchers("/register").permitAll()
//                .anyRequest().authenticated());
//
//        /**登录表单配置
//         * loginPage:登录页面请求地址
//         * loginProcessingUrl:登录接口 过滤器
//         * successForwardUrl：登录成功响应地址
//         * failureForwardUrl：登录失败响应地址
//         */
//        http.formLogin(formLogin->formLogin
//                .loginPage("/toLoginPage").permitAll()
//                .loginProcessingUrl("/login")
//                .successForwardUrl("/index")
//                .failureForwardUrl("/toLoginPage"));
//
//        //关闭crsf 跨域漏洞防御
//        http.csrf(crsf->crsf.disable());//相当于 http.csrf(Customizer.withDefaults());或者http.csrf(crsf->crsf.disable());
//        //退出
//        http.logout(logout -> logout.invalidateHttpSession(true));
//        return http.build();
//    }

}
