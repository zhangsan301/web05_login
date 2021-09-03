package com.itheima.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 通用的字符集编码过滤器
 * @author Admin
 */
public class GenericEncodingFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //过滤器中增强request对象,并将增强后的request对象传递给Servlet
        HttpServletRequest req = (HttpServletRequest)request;
       //增强req
        MyHttpServletRequest myReq = new MyHttpServletRequest(req);
        chain.doFilter(myReq,response);

    }

    @Override
    public void destroy() {

    }
}
