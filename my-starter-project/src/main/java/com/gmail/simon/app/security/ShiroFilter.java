package com.gmail.simon.app.security;

import javax.servlet.annotation.WebFilter;

@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class ShiroFilter extends org.apache.shiro.web.servlet.ShiroFilter {

}
