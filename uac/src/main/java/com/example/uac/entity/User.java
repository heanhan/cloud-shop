package com.example.uac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系統用戶表
 * </p>
 *
 * @author lvbao
 * @since 2020-09-02
 */
@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "sys_user")
public class User implements Serializable {


    /**
     * 用户id
     */
    @Id
    @NotNull(message = "roleId不能为空", groups = {Delete.class, Edit.class, Get.class})
    private Integer id;

    private Integer tenantId;

    /**
     * 用户名
     */
    @NotBlank(message = "username不能为空", groups = {Add.class})
    @Pattern(regexp = "^[a-zA-Z0-9_@.]{5,16}$", message = "格式错误", groups = {Add.class})
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    @NotBlank(message = "phone不能为空", groups = {Add.class})
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 角色id
     */
    @NotNull(message = "roleId不能为空", groups = {Add.class})
    private Integer roleId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户类型
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime createTime;


    public interface Add {

    }

    public interface Edit {

    }

    public interface Delete {

    }

    public interface Get {

    }


}
