package com.example.common.enums;


import com.example.common.exceptins.BaseErrorInfoInterface;

/**
 * @Classname CommonEnum
 * @Description TODO
 * @Date 2024/8/8
 * @Created by zhaojh0912
 */
public enum CommonEnum implements BaseErrorInfoInterface {

    /**
     * 操作失败
     */
    FAILED(101, "操作失败"),

    /**
     * 未登录/登录超时
     */
    UNAUTHORIZED(102, "登录超时"),

    /**
     * 参数错误
     */
    PARAM_ERROR(103, "参数错误"),

    /**
     * 参数错误-已存在
     */
    INVALID_PARAM_EXIST(104, "请求参数已存在"),

    /**
     * 参数错误
     */
    INVALID_PARAM_EMPTY(105, "请求参数为空"),

    /**
     * 参数错误
     */
    PARAM_TYPE_MISMATCH(106, "参数类型不匹配"),

    /**
     * 参数错误
     */
    PARAM_VALID_ERROR(107, "参数校验失败"),

    /**
     * 参数错误
     */
    ILLEGAL_REQUEST(108, "非法请求"),


    ARITHMETIC_EXCEPTION(109, "算数异常"),

    /**
     * 成功
     */
    SUCCESS(200, "操作成功"),


    /**
     * 验证码错误
     */
    INVALID_VCODE(204, "验证码错误"),

    /**
     * 用户名或密码错误
     */
    INVALID_USERNAME_PASSWORD(205, "账号或密码错误"),

    /**
     *
     */
    INVALID_RE_PASSWORD(206, "两次输入密码不一致"),

    /**
     * 用户名或密码错误
     */
    INVALID_OLD_PASSWORD(207, "旧密码错误"),

    /**
     * 用户名重复
     */
    USERNAME_ALREADY_IN(208, "用户名已存在"),

    /**
     * 用户不存在
     */
    INVALID_USERNAME(209, "用户名不存在"),

    /**
     * 角色不存在
     */
    INVALID_ROLE(210, "角色不存在"),

    /**
     * 角色不存在
     */
    ROLE_USED(211, "角色使用中，不可删除"),
    
    USER_REGISTER_SUCCESS(212, "注册成功！"),

    /**
     * 没有权限
     */
    NO_PERMISSION(403, "当前用户无该接口权限"),

    /**
     * 系统错误
     */
    ERROR(500, "系统错误"),

    /**
     * 系统错误：新增操作错误
     */
    ERROR_INSERT(501, "系统错误:新增操作错误！"),

    /**
     * 系统错误：删除错误
     */
    ERROR_DELETED(502, "系统错误:删除操作错误！"),


    /**
     * 系统错误：更新操作错误
     */
    ERROR_UPDATE(500, "系统错误:更新操作错误！"),

    /**
     * 系统错误：查询操作错误
     */
    ERROR_SELECT(500, "系统错误:查询操作错误！"),



    CUSTOM_EXCEPTION(1001,"用户自定义的异常");

    /** 错误码 */
    private Integer resultCode;

    /** 错误描述 */
    private String resultMsg;

    CommonEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public Integer getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }

}
