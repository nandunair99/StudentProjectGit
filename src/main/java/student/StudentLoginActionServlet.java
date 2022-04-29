package student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class StudentLoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public StudentLoginActionServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username=request.getParameter("username");
		String Password=request.getParameter("password");
		
		BufferedReader reader = request.getReader();
	    StringBuilder stringBuilder = new StringBuilder();
	    String line = reader.readLine();
	    while (line != null) {
	      stringBuilder.append(line + "\n");
	      line = reader.readLine();
	    }
	    reader.close();
	    
	    String params = stringBuilder.toString();
		PrintWriter out = response.getWriter();
		//out.println("Via Parameters: "+Username+" "+Password);
		out.println(params);
		ObjectMapper objectMapper=new ObjectMapper();
		StudentWrapper studentWrapper=objectMapper.readValue(params, StudentWrapper.class);
		out.println(studentWrapper.getStudentBean().getUsername());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
