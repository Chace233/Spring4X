package com.clin.Spring4X.chapter2.web;

import com.clin.Spring4X.chapter2.dao.UserDao;
import com.clin.Spring4X.chapter2.domain.User;

public class main {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = userDao.findUserByUserName("admin");
        System.out.println(user.toString());
    }
}
