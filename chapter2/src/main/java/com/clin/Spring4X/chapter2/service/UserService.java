package com.clin.Spring4X.chapter2.service;

import com.clin.Spring4X.chapter2.dao.LoginLogDao;
import com.clin.Spring4X.chapter2.dao.UserDao;
import com.clin.Spring4X.chapter2.domain.LoginLog;
import com.clin.Spring4X.chapter2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //将UserService标注为一个服务层的Bean
public class UserService {

    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUer(String userName, String password) {
        int res = userDao.getMatchCount(userName, password);
        return res > 0;
    }

    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

    @Transactional //事务注解-
    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setLoginDate(user.getLastVist());
        loginLog.setIp(user.getLastIp());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
