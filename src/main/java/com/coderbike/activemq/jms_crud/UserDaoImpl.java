package com.coderbike.activemq.jms_crud;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: imant
 * date: 2017/2/22 15:10
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Override
    public void save(User user) {
        String sql = "INSERT INTO t_user(NAME, age) VALUES(?, ?);";
        this.getJdbcTemplate().update(sql, user.getName(), user.getAge());

        //throw new RuntimeException("报错");
    }
}
