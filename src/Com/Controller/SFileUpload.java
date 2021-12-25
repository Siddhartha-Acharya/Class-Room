package Com.Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Com.Dao.SuploadsDao;
import Com.Dao.TUploadDao;
import Com.Model.Suploadpojo;
import Com.Model.TFileUploadpojo;

/**
 * Servlet implementation class SFileUpload
 */
@WebServlet("/SFileUpload")
public class SFileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Suploadpojo pojo=new Suploadpojo(); 
	private SuploadsDao dao=new SuploadsDao();
	private static final String UPLOAD_DIRECTORY = "G:\\Studentprofile";
    
	private static final int MEMORY_THRESHOLD 	= 1024 * 1024 * 3; 	// 3MB
	private static final int MAX_FILE_SIZE 		= 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE	= 1024 * 1024 * 50; // 50MB
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("user_id");
		System.out.println(id);
		if (!ServletFileUpload.isMultipartContent(request)) 
		{
			// if not, we stop here
			PrintWriter writer = response.getWriter();
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk 
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		
		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);
		
		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		// creates the directory if it does not exist
		File uploadDir = new File(UPLOAD_DIRECTORY);
		if (!uploadDir.exists())
		{
			uploadDir.mkdir();
		}
		try {
			// parses the request's content to extract file data
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) 
			{
				// iterates over form's fields
				for (FileItem item : formItems) 
				{
					// processes only fields that are not form fields
					if (!item.isFormField()) 
					{
						String fileName = new File(item.getName()).getName();
						String filePath = UPLOAD_DIRECTORY + fileName;
						File storeFile = new File(filePath);
						System.out.println(fileName);
						System.out.println(filePath);
						
						pojo.setId(id);
						pojo.setFilename(fileName);
						pojo.setFilepath(filePath);
						
						String s=dao.update(pojo);
						if(s.equals("SUCCESS"))
						{
							// saves the file on disk
							item.write(storeFile);
							request.setAttribute("message","Upload has been done successfully!");	
						}
					}
				}
			}
		}
		catch (Exception ex) 
		{
			request.setAttribute("message","There was an error: " + ex.getMessage());
		}
		// redirects client to message page
		getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
	}


}
