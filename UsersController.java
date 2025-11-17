package com.dot.usermanagement.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dot.usermanagement.dao.UserDao;
import com.dot.usermanagement.model.Users;

/**
 * Servlet implementation class UsersController
 */
@WebServlet("/")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao userdao;
       
    public UsersController()
    {
    	this.userdao=new UserDao();
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getServletPath();
		
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			try {
				insertUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				editUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				userUpdate(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			try {
				listUser(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
	}

	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Users> users=userdao.selectAllUsers();
		request.setAttribute("listuser", users);
		RequestDispatcher rd=request.getRequestDispatcher("user-list.jsp");
		rd.forward(request, response);
		
	}

	private void userUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		Users user=new Users(id,name,email,country);
		userdao.updateUser(user);
		response.sendRedirect("list");
		
	}

	private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Users existinguser=userdao.selectUser(id);
		RequestDispatcher rd=request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user",existinguser);
		rd.forward(request, response);
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rs=request.getRequestDispatcher("user-form.jsp");
		rs.forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		Users users=new Users(name,email,country);
		userdao.insertUser(users);
		response.sendRedirect("list");
		
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		userdao.deleteUser(id);
		response.sendRedirect("list");
		
		
	}

	
	
	
	

}
