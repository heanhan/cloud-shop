package com.example.uac.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author lvbao
 * @since 2020-09-02
 */
@Data
@Entity
@Table(name = "sys_menu")
@DynamicUpdate
@DynamicInsert
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @Id
    @NotNull(message = "id不能为空", groups = {Get.class, Delete.class, Edit.class})
    private Integer id;

    /**
     * 菜单名称
     */
    @NotBlank(message = "name不能为空", groups = {Add.class})
    private String name;

    /**
     * 标题
     */
    @NotBlank(message = "title不能为空", groups = {Add.class})
    private String title;

    /**
     * 菜单地址
     */
    @NotBlank(message = "menuUrl不能为空", groups = {Add.class})
    private String menuUrl;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 菜单排序
     */
    private Integer listOrder;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单类型
     */
    private Integer type;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 菜单状态
     */
    private Boolean isDel;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createTime;


    /**
     * 子menu
     */
    @Transient
    private List<Menu> children;

    @Transient
    private boolean checked;

    public interface Add {

    }

    public interface Edit {

    }

    public interface Delete {

    }

    public interface Get {

    }

}
