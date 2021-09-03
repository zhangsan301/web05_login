package com.itheima.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;

/**
 * 增强的类
 * @author Administrator
 */
public class MyHttpServletRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public MyHttpServletRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    //增强request.getParameter()方法:
    @Override
    public String getParameter(String name) {
        //获得请求方式:
        String method = request.getMethod();
        //根据get还是post请求进行不同方式的乱码处理:
        if("GET".equalsIgnoreCase(method)){
            //get请求
         String value = super.getParameter(name);
            try {
                value = new String(value.getBytes("UTF-8"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return value;
        }else if("POST".equalsIgnoreCase(method)){
            //post请求
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return super.getParameter(name);
    }



}
