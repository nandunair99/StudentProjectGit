package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ShowStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		StudentBean studentBean=new StudentBean();
		studentBean.setUsername("nandu");
		studentBean.setPassword("nandu99");
		StudentWrapper studentWrapper=new StudentWrapper();
		studentWrapper.setStudentBean(studentBean);
		ArrayList<String> subjects =new ArrayList<>();
		subjects.add("physics");
		subjects.add("chemistry");
		subjects.add("maths");
		studentWrapper.setSubjects(subjects);
		String json="";
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentWrapper);
			out.println(json);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
