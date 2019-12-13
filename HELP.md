# Getting Started使用

项目介绍：

    1. 运行环境：
        springboot2.1.11.RELEASE
        jdk8、
        maven 3.6.1、
        idea2019.1.2、
        springcloud Greenwich.SR3、
        spring-cloud-alibaba-dependencies 2.1.0.RELEASE
        nacos 0.9
        seata 0.9
        
    2. 需要seata-server 与nacos
        地址：
            seata-server: https://github.com/seata/seata/releases
            nacos:  https://github.com/alibaba/nacos/releases
    
    3. 配置seata作为分布式项目的分布式事务的解决方案
        参照官方文档，
        
    4. 项目涉及的sql 
        a.  seata 基于持久化话到关系数据库mysql的建表语句在父项目下seata.sql
        b.  每个项目设计的sql都放置在每个项目的resouce中下
    
    


使用Spring Cloud Alibaba 作为微服务的解决方案

1 . 注册中心使用 Nacos
    
        下载nacos 的文件 nacos-server-1.1.4.tar.gz / nacos-server-1.1.4.zip
        解压文件后得到nacos文件夹
            nacos
               --bin  存放二进制命令  启动文件在该目录  linux 使用 sh ./bin/startup.sh  windows 使用 双击 startup.cmd
               --config  存放一些【配合子文件  如项目启动的信息，数据库的连接 集群搭建的配置 日志，以及默认的官方数据库表
               --data  存放一些数据
               --logs 日志
               --target 
               
        启动后nacos的服务端
        登录 http://127.0.0.1:8848/nacos/ 用户名密码默认为 nacos/nacos 即可进入可视化界面
    
    
2 . 服务的注册与发现

        添加坐标pom
                <!-- 需要引入alibaba构建微服务的坐标-->
                <dependencyManagement>
                        <dependencies>
                            <dependency>
                                <groupId>org.springframework.cloud</groupId>
                                <artifactId>spring-cloud-dependencies</artifactId>
                                <version>${spring-cloud.version}</version>
                                <type>pom</type>
                                <scope>import</scope>
                            </dependency>
                            <!--添加springcloud-alibaba的依赖 -->
                            <dependency>
                                <groupId>com.alibaba.cloud</groupId>
                                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                                <version>2.1.0.RELEASE</version>
                                <type>pom</type>
                                <scope>import</scope>
                            </dependency>
                        </dependencies>
                    </dependencyManagement>
                    <!--引入nacos的坐标       -->
                    <dependency>
                        <groupId>org.springframework.cloud</groupId>
                        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
                        <version>0.9.0.RELEASE</version>
                    </dependency>

        修改配置文件
        注意：需要为每个微服务模块添加  spring.application.name=微服务名称
        spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848
    
        在入口函数中添加注解。实现微服务注册
        方式一：
            在默认使用@SpringBootApplication时需要添加下面的
            @EnableDiscoveryClient
    
        方式二：
            使用@SpingCloudApplication注解 因为该注解包含了 如下注解：
            @SpringBootApplication
            @EnableDiscoveryClient
            @EnableCircuitBreaker
            则不需要在添加 @EnableDiscoveryClient了，但此时需要额外引入 hystrix熔断器的坐标
        
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
                </dependency>
        


3 . 使用Nacos作为配置中心 ,除了引入对应的alibaba的坐标还需要在引入
    
            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
                <version>2.1.1.RELEASE</version>
            </dependency>
            
    然后需要在conf的微服务下的配置文件有需要添加bootstrap.properties或者bootstrap.yml。因为在springboot框架下bootstrap的文件优先级比较高，项目启动需要预先加载
    配置文件，所以config的配置需要放在bootstrap的文件中。
    
    需要在配置文件里添加如下配置内容:
    
        server.port=自定义端口
        spring.application.name=微服务名称
    
        #配置nacos 作为注册中心
        spring.cloud.nacos.discovery.server-addr=ip:8848
    
        #配置nacos当做config配置中心
        spring.cloud.nacos.config.server-addr=ip:8848
    
    注意添加实时刷新配置文件的注解：可以在入口类或者controller类上
     @ReFreshScop  标识可以进行刷新
    
    动态修改配置文件有两种方式
    
        方式一：
            界面实现：配置列表---->点击点解的加号标识
            Data ID : 是当前项目的项目名  spring.application.name  加上.properites
            Group: 默认为 DEFAULT_GROUP
            配置格式有 text、josn、xml、yaml、html、properties
            配置内容： 根据对应的属性进行对应的属性进行更改。
        方式二：
        调用 Nacos Open API 向 Nacos Server 发布配置 发送一个  post请求
        "http://ip:8848/nacos/v1/cs/configs?dataId=微服务配置的名称.properties&group=DEFAULT_GROUP&content=useLocalCache=true"
            
            
            
 4 .Nacos支持三种部署模式
    
        单机模式 - 用于测试和单机试用。
        集群模式 - 用于生产环境，确保高可用。集群需要依赖mysql，单机可不必，3个或3个以上Nacos节点才能构成集群。
        多集群模式 - 用于多数据中心场景。
        
        
        
        单机模式：（使用mysql方式实现）不使用mysql 直接启动٩便可以使用：
            
            1.安装数据库，版本要求：5.6.5+
            2.初始化mysql数据库，创建nacos_config ,然后执行官方提供的在config下的nacos-mysql.sql文件进行表的创建
            3.修改conf/application.properties文件，增加支持mysql数据源配置（目前只支持mysql），添加mysql数据源的url、用户名和密码。
        
            application.properties的配置文件内容如下：
            
                # spring
                 
                server.contextPath=/nacos
                server.servlet.contextPath=/nacos
                server.port=8848
                 
                nacos.cmdb.dumpTaskInterval=3600
                nacos.cmdb.eventTaskInterval=10
                nacos.cmdb.labelTaskInterval=300
                nacos.cmdb.loadDataAtStart=false
                 
                db.num=1
                db.url.0=jdbc:mysql://ip:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
                db.user=用户名
                db.password=密码
                
                
            再以单机模式启动nacos，nacos所有写嵌入式数据库的数据都写到了mysql
            
        集群模式：
        
            在nacos的解压目录nacos/的conf目录下，有配置文件cluster.conf，请每行配置成ip:port。（请配置3个或3个以上节点）
            
            首先我们进入conf目录下，默认只有一个cluster.conf.example文件，我们需要自行复制一份，修改名称为cluster.conf
    
    