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
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author lvbao
 * @since 2020-09-02
 */
@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {


    /**
     * 角色id
     */
    @Id
    @NotNull(message = "roleId不能为空", groups = {User.Delete.class, User.Edit.class, User.Get.class})
    private Integer id;

    /**
     * 角色名称
     */
    @NotBlank(message = "roleName不能为空", groups = {Add.class})
    private String roleName;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 菜单权限
     */
    private String menuRights;

    /**
     * 节点权限
     */
    private String nodeRights;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 角色类型
     */
    private Integer type;

    /**
     * 状态
     */
    private Boolean isDel;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime createTime;

    public interface Add {

    }
}
