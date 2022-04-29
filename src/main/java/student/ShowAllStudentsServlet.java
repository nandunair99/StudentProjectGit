package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ShowAllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowAllStudentsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		List<StudentBean> studentBeans=new ArrayList<>();
		StudentBean student1=new StudentBean();
		student1.setUsername("nanduN");
		student1.setPassword("nanduN99");
		StudentBean student2=new StudentBean();
		student2.setUsername("hardikP");
		student2.setPassword("hardikP99");
		StudentBean student3=new StudentBean();
		student3.setUsername("vivekV");
		student3.setPassword("vivekV99");
		studentBeans.add(student1);
		studentBeans.add(student2);
		studentBeans.add(student3);
		
		ObjectMapper objectMapper=new ObjectMapper();
		String result=objectMapper.writeValueAsString(studentBeans);
		out.println(result);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
