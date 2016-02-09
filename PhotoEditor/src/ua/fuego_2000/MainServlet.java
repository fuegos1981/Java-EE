package ua.fuego_2000;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
@MultipartConfig
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection<Part> parts = req.getParts();
		resp.setContentType("text/html");
		//PrintWriter out = resp.getWriter();
		
		for (Part filePart : parts) {
			if (filePart.getContentType()!= null){
				String fileName = filePart.getSubmittedFileName();
				InputStream fileContent = filePart.getInputStream();
				String newPath = getServletContext().getRealPath("/WEB-INF")+"/images/"+fileName;
				filePart.write(newPath);
				
			}
			
		}
		StringBuilder result = new StringBuilder("");
		//out.println(result.toString());
		File[] fList =new File(getServletContext().getRealPath("/WEB-INF/images")).listFiles();
		for (int i = 0; i < fList.length; i++) {
			result.append("<img src='"+fList[i].getPath()+"'>");
			//out.println( "<img src="+fList[i].getPath()+">");
		}
		//out.flush();
		//req.setAttribute("textA", result.toString());
		req.setAttribute("list", fList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Index.jsp");
        dispatcher.forward(req, resp);
		
	}
	

}
