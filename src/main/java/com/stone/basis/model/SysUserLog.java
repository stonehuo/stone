package com.kpap.basis.model;

import java.util.Date;
import com.kpap.common.annotation.TableColumn;

public class SysUserLog {
	/**
	 * 登录结果：成功
	 */
	public static String loginResult_success="SUCCESS";
	/**
	 * 登录结果：失败
	 */
	public static String loginResult_fail="FAIL";
	
    @TableColumn(name="id")
    public Integer id;

    @TableColumn(name="user_code")
    public String userCode;

    @TableColumn(name="from_ip")
    public String fromIp;

    @TableColumn(name="login_date")
    public Date loginDate;

    @TableColumn(name="login_result")
    public String loginResult;

    @TableColumn(name="fail_reason")
    public String failReason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp == null ? null : fromIp.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult == null ? null : loginResult.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }
}