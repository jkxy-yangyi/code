package com.jkxy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		String vcode=req.getParameter("vcode");
		//服务器端验证码
		String num=(String) req.getSession().getAttribute("num");
		if (!num.equalsIgnoreCase(vcode)) {
			req.getSession().setAttribute("msg", "验证码输入错误");
			resp.sendRedirect("index.jsp");
		}else {
			if (uname.equals("111")&&pwd.equals("111")) {
				resp.sendRedirect("success.jsp");
			}else {
				resp.sendRedirect("index.jsp");
				req.getSession().setAttribute("msg", "用户名或密码错误");
			}
		}
	}

}
