package com.easybuy.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetEncodeFilter implements Filter{

	
	private String charset;
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		if (charset!=null && charset.trim().length()>0) {
			arg0.setCharacterEncoding(charset);
			arg1.setCharacterEncoding(charset);
		}
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		String initParam = arg0.getInitParameter("charset");
		if (initParam!=null && initParam.trim().length()>0) {
			charset = initParam;
		}else {
			charset="UTF-8";
		}
	}

}
