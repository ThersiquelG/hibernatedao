package com.greg.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greg.dao.UserDao;
import com.greg.model.User;



/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String nom = request.getParameter("nom");
		 String prenom = request.getParameter("prenom");
		 String email = request.getParameter("email");
		 String mdp = request.getParameter("mdp");
		 
		  User user = new User();
		 //Using Java Beans - An easiest way to play with group of related data
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setMdp(mdp);
		 
		 UserDao userdao = new UserDao();
		 
		 
		
		 String userRegister = userdao.addUser(user);
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 
		
		 if(userRegister.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
		 request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegister);
		 request.getRequestDispatcher("/Register.jsp").forward(request, response);
		 }
	}

}
