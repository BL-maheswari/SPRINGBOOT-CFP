package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");

		String userId = getServletConfig().getInitParameter("user");
		String password = getServletConfig().getInitParameter("password");
		if (userId.equals(user) && password.equals(pwd)) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("Loginsuccess.jsp").forward(req, resp);

		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out = resp.getWriter();
			out.println("<font color=red>either user name or password is wrong.</font>");
			rd.include(req, resp);
		}
	}
}
