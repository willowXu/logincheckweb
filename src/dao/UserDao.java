package dao;

import pojo.UserInfo;
import util.DruidUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: xuliushen
 * @Description:
 * @Date Created in 2021-09-14 17:26
 * @Modified by :
 */
public class UserDao {

    public UserInfo getUserInfo(String username){
        UserInfo userInfo = null;
        try {
            String sql = "select * from userinfo where username=?";
            List params = new LinkedList();
            params.add(username);
            ResultSet rs = DruidUtil.query(sql,params);
            if(rs.next()){
                userInfo = new UserInfo();
                userInfo.setUsername(username);
                userInfo.setPassword(rs.getString("password"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtil.close();
        }
        return userInfo;
    }
}
