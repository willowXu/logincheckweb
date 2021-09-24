package dao;

import pojo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xuliushen
 * @Description:
 * @Date Created in 2021-09-14 18:22
 * @Modified by :
 */
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do-get");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do-post");
        UserDao userDao = new UserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserInfo userInfo = userDao.getUserInfo(username);
        if(userInfo == null){
            req.getRequestDispatcher("/login.html").forward(req,resp);
            req.setAttribute("loginFailure","用户名不存在！");
        }else {
            String password2 = userInfo.getPassword();
            if (password.equals(password2)) {//验证成功跳转到成功页面
                req.getSession().setAttribute("username", username);
                req.getRequestDispatcher("/success.jsp").forward(req, resp);
            }
            else {
                req.getRequestDispatcher("/login.html").forward(req, resp);
                req.setAttribute("loginFailure", "密码错误！");
            }
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化servlet");
    }
}
