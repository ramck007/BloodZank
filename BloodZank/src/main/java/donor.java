

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class donor
 */
@WebServlet("/donor" )
public class donor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String bgrp = request.getParameter("bgrp");
		String location = request.getParameter("location11");
		out.print("<h1>Displaying Donoooooor</h1>");
		out.print("<table border='1'><tr><th>Name</th><th>Contact Number</th></tr>");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodzank","root","1234");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select uname,number from bloodzank where bloodgrp='"+bgrp+"' and Location = '"+location+"';");
			while(rs.next()) {
				out.print("<tr><td>");
				out.print(rs.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rs.getString(2));
				out.print("</td>");
				out.print("</tr>");
			}
		}catch(Exception p) {
			System.out.println(p);
		}
		
		out.print("</table>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
