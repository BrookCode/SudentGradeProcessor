package student;
import java.io.Serializable;

import classStats.ClassStatistics;

public class StudentGrade implements Serializable{
	private static final long serialVersionUID = -746230022422843361L;
	Student student = new Student();
	ClassStatistics statistics = new ClassStatistics();
		
	public StudentGrade() {
	}

	public StudentGrade(Student student, ClassStatistics statistics) {
		super();
		this.student = student;
		this.statistics = statistics;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ClassStatistics getStatistics() {
		return statistics;
	}

	public void setStatistics(ClassStatistics statistics) {
		this.statistics = statistics;
	}
}
