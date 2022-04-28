package com.usst.Filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;
@WebFilter(
        filterName = "authorityFilter",
        urlPatterns = { "/*" },
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8"),
                @WebInitParam(name = "loginPage", value = "login.jsp"),
                @WebInitParam(name = "loginPage1", value = "register.jsp"),
                @WebInitParam(name = "loginPage2", value = "register.css"),
                @WebInitParam(name = "loginPage3", value = "background.jpg"),
                @WebInitParam(name = "loginPage4", value = "LoginServlet"),
                @WebInitParam(name = "loginPage5", value = "RegisterServlet"),
        })

public class AuthorityFilter implements Filter {
    private FilterConfig config;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {


        String encoding = config.getInitParameter("encoding");
        String loginPage = config.getInitParameter("loginPage");
        String loginPage1 = config.getInitParameter("loginPage1");
        String loginPage2 = config.getInitParameter("loginPage2");
        String loginPage3 = config.getInitParameter("loginPage3");
        String loginPage4 = config.getInitParameter("loginPage4");
        String loginPage5 = config.getInitParameter("loginPage5");

        request.setCharacterEncoding(encoding);

        HttpServletRequest hrequest = (HttpServletRequest)request;

        HttpSession session = hrequest.getSession(true);

        // 获得客户请求的页面

        String requestPath = hrequest.getServletPath();


        if (session.getAttribute("username")==null
                &&!requestPath.endsWith(loginPage)
                &&!requestPath.endsWith(loginPage2)
                &&!requestPath.endsWith(loginPage3)
                &&!requestPath.endsWith(loginPage4)
                &&!requestPath.endsWith(loginPage1)
                &&!requestPath.endsWith(loginPage5))

        {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig Config) throws ServletException {
        config = Config;
    }

}

 