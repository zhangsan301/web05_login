package com.itheima.filter;


import com.itheima.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 权限验证
 * @aythor
 */
public class PrivilegeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //判断用户是否已经登录。如果已经登录,放行。如果没有登录,回到登录页面
        HttpServletRequest req = (HttpServletRequest) request;
        User existUser = (User)req.getSession().getAttribute("existUser");
        //判断
        if(existUser==null){
            //没有登录
            req.setAttribute("msg","您还没有登录!没有权限访问!");
            req.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            //已经登录：
            chain.doFilter(request,response);

        }

    }

    @Override
    public void destroy() {

    }
}
