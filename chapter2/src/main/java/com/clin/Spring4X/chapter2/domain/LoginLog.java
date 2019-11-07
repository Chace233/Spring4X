package com.clin.Spring4X.chapter2.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable {

    private int LoginLogId;
    private int userId;
    private Date loginDate;
    private String ip;

    public int getLoginLogId() {
        return LoginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        LoginLogId = loginLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
