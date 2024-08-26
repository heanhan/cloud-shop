package com.example.common.exceptins;

/**
 * @Classname BaseErrorInfoInterface
 * @Description 基础的错误信息接口
 * @Date 2024/8/8
 * @Created by zhaojh0912
 */
public interface BaseErrorInfoInterface {


    /**
     * 错误码
     */
    Integer getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
