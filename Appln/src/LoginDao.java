import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginDao {
		public static boolean validate(String username,String password){  
		boolean status=false;  
		try{  
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notes_app","root", "1234"); 
		PreparedStatement ps=conn.prepareStatement("select * from register where username=? and password=?");  
		ps.setString(1,username);  
		ps.setString(2,password);        
		ResultSet rs=ps.executeQuery();  
		status=rs.next();            
		}catch(Exception e){System.out.println(e);}  
		return status;  
		} 

	}