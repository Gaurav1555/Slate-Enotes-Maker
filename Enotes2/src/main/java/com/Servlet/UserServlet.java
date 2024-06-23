package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.Db.DBConnect;
import com.User.UserDetails;
import com.DAO.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		
		UserDetails us = new UserDetails();
		
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f=dao.addUser(us);
		HttpSession session;
		
		if(f) {
			 session = request.getSession();
			 session.setAttribute("reg-success", "Registration Successfully");
			 response.sendRedirect("register.jsp");
		}
		
		else {
			session = request.getSession();
			session.setAttribute("failed-msg","Something went wrong on server");
			response.sendRedirect("register.jsp");
			
		}
		
	}

}
