package util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: xuliushen
 * @Description: 登录成功页面的拦截器
 * @Date Created in 2021-09-18 8:57
 * @Modified by :
 */
public class SuccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("success filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("success filter开始");
        //强转类型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取uri和username
        String uri = request.getRequestURI();
        Object username = request.getSession().getAttribute("username");
        if(uri.endsWith("success.jsp")&&username==null){//未登录状态下访问success.jsp页面
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(
                    "<script type='text/javascript'>" +
                            "alert('请先登录系统！');" +
                            "location='login.html';" +
                    "</script>");
            out.close();
        }
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("success filter结束");
    }

    @Override
    public void destroy() {
        System.out.println("success filter销毁");
    }
}
