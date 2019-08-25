
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String UPLOAD_DIRECTORY = "C:/uploads";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {     			      
		response.setContentType("text/html");		       
		//process only if its multipart content	       
		if(ServletFileUpload.isMultipartContent(request)){
	     			            try {
	     			                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
	     			              
	     			                for(FileItem item : multiparts){
	     			                    if(!item.isFormField()){
	     			                        String name = new File(item.getName()).getName();
	     			                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
	 FileInputStream fileInputStream = new FileInputStream(UPLOAD_DIRECTORY +"/"+ name);
	 PrintWriter out = response.getWriter();  	
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ name + "\"");
		int i;
		while ((i = fileInputStream.read()) != -1) {
		out.write(i);
		}
		fileInputStream.close();
		out.close();
		
	     			                    }    			                
	     			        }
	   
	     			            } catch (Exception ex) {
	     			              System.out.println("File Upload Failed due to " + ex);
	     			            }          
	     			         
	     			        }else{
	     			            System.out.println("Sorry this Servlet only handles file upload request");
	     			        }
	     			    
	     			       
	     			     

	     			    }

}
