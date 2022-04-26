package com.eud;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Servlet implementation class Register
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean added=false;
		
		HttpSession session = request.getSession();
		
		session.setAttribute("added", added);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberRegistration.jsp");
	    rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean added=true;
		
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String gender = request.getParameter("gender");
		String birthdate = request.getParameter("birthdate");
		String waddress = request.getParameter("waddress");
		String haddress = request.getParameter("haddress");
		
		Member member = new Member(name,surname,gender,birthdate,waddress,haddress);
		
		MemberDao rDao = new MemberDao();
		String result = rDao.insert(member);
		session.setAttribute("result", result);
		session.setAttribute("added", added);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberRegistration.jsp");
	    rd.forward(request, response);
		
	}

}
