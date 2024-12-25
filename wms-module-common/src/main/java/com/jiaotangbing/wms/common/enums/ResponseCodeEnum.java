package com.jiaotangbing.wms.common.enums;

import com.jiaotangbing.wms.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lwh
 * @create 2024-11-12 21:59
 * 响应异常码
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("10000", "出错啦，后台小哥正在努力修复中..."),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND("20000", "该产品不存在（测试使用）"),
    PARAM_NOT_VALID("10001", "参数错误"),
    LOGIN_FAIL("20000", "登录失败"),
    USERNAME_OR_PWD_ERROR("20001", "用户名或密码错误"),
    UNAUTHORIZED("20002", "无访问权限，请先登录！"),
    USERNAME_NOT_FOUND("20003", "该用户不存在"),
    FORBIDDEN("20004", "权限不够，请联系管理员！"),
    STATE_NAME_IS_EXISTED("20005","该状态已存在，请勿重复添加"),
    CATEGORY_NAME_IS_EXISTED("20006","该大类已存在，请勿重复添加"),
    CATEGORY_NAME_IS_NOT_EXISTED("20007","该大类不存在，请先添加大类"),
    USERNAME_IS_EXISTED("20008","该用户名已存在，请重新命名"),
    PASSWORD_NOT_EQUALS("20009","两次输入的密码不一致"),
    USERNAME_IS_NOT_EXISTED("20010","该用户不存在,请先注册用户"),
    ;

    // 异常码
    private String errorCode;
    // 错误信息
    private String errorMessage;

}
