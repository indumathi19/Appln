import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();          
		String firstname=request.getParameter("firstname");  
		String lastname=request.getParameter("lastname");  
		String username=request.getParameter("username");  
		String password=request.getParameter("password");  
		System.out.println("welcome servlet!");         
		try{   
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes_app?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false","root", "1234");
		System.out.println("database is connected!");   
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `register`(firstname,lastname,username,password) VALUE (?,?,?,?)");
		pstmt.setString(1,firstname);
		pstmt.setString(2, lastname);
		pstmt.setString(3,username);
		pstmt.setString(4, password);
		pstmt.executeUpdate();          
		int i=pstmt.executeUpdate();  
		if(i>0)  
		out.print("You are successfully registered...");  
		response.sendRedirect("login.jsp");             
		}catch (Exception e2) {System.out.println(e2);}            
		out.close();  
		} 

	}

