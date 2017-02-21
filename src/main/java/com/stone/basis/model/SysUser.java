package com.kpap.basis.model;

import java.util.Date;

import com.kpap.common.annotation.TableColumn;

public class SysUser {
	/**
	 * 角色：管理员
	 */
	public static String role_0="0";
	/**
	 * 角色：审核员
	 */
	public static String role_1="1";
	/**
	 * 角色：操作员
	 */
	public static String role_2="2";
    /**
     * 用户code
     */
    @TableColumn(name="user_code",uniqueness=true)
    public String userCode;

    /**
     * 密码
     */
    @TableColumn(name="password")
    public String password;

    /**
     * 角色：0--管理员；1--审核员；2--操作员
     */
    @TableColumn(name="role")
    public String role;

    /**
     * 姓名
     */
    @TableColumn(name="name")
    public String name;

    /**
     * 手机号
     */
    @TableColumn(name="phone")
    public String phone;

    /**
     * 邮箱
     */
    @TableColumn(name="email")
    public String email;

    /**
     * 地址
     */
    @TableColumn(name="address")
    public String address;

    /**
     * 创建日期
     */
    @TableColumn(name="create_date")
    public Date createDate;

    /**
     * 修改日期
     */
    @TableColumn(name="modify_date")
    public Date modifyDate;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}