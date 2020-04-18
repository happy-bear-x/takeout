package com.takeout.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.JdbSimpyFun;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@WebServlet("/resetPassword")
public class resetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public resetPassword() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = (Connection) JdbSimpyFun.getConnection();
		request.setCharacterEncoding("UTF-8");
		HttpSession hs=request.getSession();
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String reNewPassword = request.getParameter("reNewPassword");
		Statement sm = null;
		try {
			sm = (Statement) conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "update usertable set password='"+newPassword+"'where '"+userName+"'=`username` and '"+passWord+"'=`password` and '"+newPassword+"'='"+reNewPassword+"';";
		int flag = 0;
		try {
			flag = sm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag!=0){
				 hs.setAttribute("username", userName);
				  request.getRequestDispatcher("resetPasswordSuccess.jsp").forward(request, response);

		   }else {
			hs.setAttribute("error", "error");
			response.sendRedirect("resetPassword.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
