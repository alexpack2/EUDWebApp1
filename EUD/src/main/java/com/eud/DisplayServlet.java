package com.eud;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Display
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean details = false;
		
		HttpSession session = request.getSession();
		
		MemberDao rDao = new MemberDao();
		String result = rDao.retrieve();
		ArrayList<Member> members = rDao.getMembers();
		
		session.setAttribute("members", members);
		session.setAttribute("details", details);
		
	    String idToDeleteS = request.getParameter("idToDelete");
	    if (idToDeleteS!=null) {
	    	int id=Integer.parseInt(idToDeleteS);
	    	rDao.delete(id);
	    }
	    
	    String idDetailsS = request.getParameter("idDetails");
	    if (idDetailsS!=null) {
	    	int idDetails=Integer.parseInt(idDetailsS);
	    	for(int i=0;i<members.size();i++)
	    	{
	    		if(members.get(i).getId()==idDetails)
	    		{
	    			details = true;
	    			session.setAttribute("details", details);
	    			session.setAttribute("idDetails", idDetails);
	    			RequestDispatcher rd = request.getRequestDispatcher("memberDisplay.jsp");
	    		    rd.forward(request, response);
	    		}
	    	}
	    }
	    else {
	    	RequestDispatcher rd = request.getRequestDispatcher("memberDisplay.jsp");
	    	rd.forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
