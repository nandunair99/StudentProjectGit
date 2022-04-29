package student;

import java.util.ArrayList;


public class StudentWrapper {

	private StudentBean studentBean;
	private ArrayList<String> subjects;
	
	public StudentBean getStudentBean() {
		return studentBean;
	}
	public void setStudentBean(StudentBean studentBean) {
		this.studentBean = studentBean;
	}
	public ArrayList<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}
	
}
