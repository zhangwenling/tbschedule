package com.taobao.console.filter;

import com.jd.common.springmvc.interceptor.SpringSSOInterceptor;
import com.jd.common.web.LoginContext;
import com.taobao.console.service.ErpService;
import com.taobao.console.util.SpringConfigTool;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginFilter implements Filter {


    //构造方法
    public LoginFilter() {

    }

    public void destroy() {


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String requestURI = httpServletRequest.getRequestURI();

            boolean isLogin = getInterceptor().preHandle((HttpServletRequest) request, (HttpServletResponse) response, null);

            if (!isLogin) {
                return;
            }

            String pin = LoginContext.getLoginContext().getPin();
            if (getErpService().validErp(pin) == false) {//无权限
                requestURI = "403.jsp";
            }

            request.getRequestDispatcher(requestURI).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SpringSSOInterceptor getInterceptor() {
        return SpringConfigTool.getContext().getBean(SpringSSOInterceptor.class);
    }

    private ErpService getErpService() {
        return SpringConfigTool.getContext().getBean(ErpService.class);
    }


}