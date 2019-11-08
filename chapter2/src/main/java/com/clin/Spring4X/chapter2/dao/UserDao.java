package com.clin.Spring4X.chapter2.dao;

import com.clin.Spring4X.chapter2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbctemplate;
    private final static String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user SET last_visit=?, last_ip=?, credits=? WHERE user_id=?";

    @Autowired
    public void setJdbctemplate(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    public int getMatchCount(String userName, String password) {
        String sqlStr = "SELECT COUNT(*) FROM t_user" +
                        " WHERE user_name= ? and password = ?";
        List res = jdbctemplate.queryForList(sqlStr, userName, password);
        return res.size();
    }

    public User findUserByUserName(final String userName) {
        String sqlStr = "SELECT user_id, user_name, credits " +
                        " FROM t_user " +
                        " WHERE user_name = ?";
        final User user = new User();
        jdbctemplate.query(sqlStr, new Object[]{userName}, (RowCallbackHandler) (rs) -> {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setCredits(rs.getInt("credits"));
            });
        return user;
    }

    public void updateLoginInfo(User user) {
        jdbctemplate.update(UPDATE_LOGIN_INFO_SQL, user.getLastVist(), user.getLastIp(), user.getCredits(), user.getUserId());
    }

    @Autowired
    public void setjdbctemplate(JdbcTemplate jdbctemplate) { this.jdbctemplate = jdbctemplate; }
}
