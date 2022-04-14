

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String aadhar = request.getParameter("aaid");
		String email = request.getParameter("uid");
		String pin = request.getParameter("upin");
		String bloodgrp=request.getParameter("bloodgroup");
		String gender=request.getParameter("gender");
		String number = request.getParameter("number");
		String location=request.getParameter("district");
		String address = request.getParameter("address");
		String date= request.getParameter("udate");
		String willing=request.getParameter("donate"); 
		
		BloodZData bz= new BloodZData(uname , aadhar , email , pin , bloodgrp , gender , number , location , address , date , willing);
		BloodZDB bzdb = new BloodZDB();
		
		String result = bzdb.insert(bz);
		
		response.getWriter().print(result);
		
		System.out.println(uname);
		System.out.println(aadhar);
		System.out.println(email);
		System.out.println(pin);
		System.out.println(bloodgrp);
		System.out.println(gender);
		System.out.println(number);
		System.out.println(location);
		System.out.println(address);
		System.out.println(date);
		System.out.println(willing);
		//doGet(request, response);
	}

}
