package Com.Controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Downloadteacherassignment
 */
@WebServlet("/Downloadteacherassignment")
public class Downloadteacherassignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 final String File_Location="H:/etc/";
     final String[][] contentTypes={{"xml","text/xml"},{"pdf","application/pdf"}};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Downloadteacherassignment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Object  requestObject=request.getParameter("filename");
		if(requestObject !=null){
			String filename=(String) requestObject;
			String contentType=getContentType(filename.split("\\.")[1]);
			File file=new File(File_Location+"/"+filename);
			response.setContentType(contentType);
			response.addHeader("Content-Disposition", "attachment; filename="+ filename);
			response.setContentLength((int) file.length());
			ServletOutputStream servletOutputStream = response.getOutputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
			int bytesRead = bufferedInputStream.read();
			while(bytesRead !=-1){
				servletOutputStream.write(bytesRead);
				bytesRead = bufferedInputStream.read();
			}
			if(servletOutputStream !=null) servletOutputStream.close();
			if(bufferedInputStream !=null) bufferedInputStream.close();
			
		}
		
		
	}
private String getContentType(String fileType) {
	// TODO Auto-generated method stub
	String returnType=null;
	for(int i=0;i<contentTypes.length;i++){
		if(fileType.equals(contentTypes[i][0])) returnType= contentTypes[i][1];
	}
	return returnType;
}
	}


