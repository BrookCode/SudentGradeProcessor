package adapter;

import classStats.ClassStatistics;
import exceptionHandling.FileNotFoundHandler;
import student.Student;
import student.StudentGrade;
import util.FileIO;
import util.Util;

public abstract class StudentAPIImpl implements StudentAPI{
	FileIO file = new FileIO();

	public StudentAPIImpl() {
		Student lab2 [] = new Student[40];
		Util Util = new Util();
		
		boolean fixed = false;
		do {
			try {
				lab2 = Util.ReadFile("CorrectFile.txt", lab2);
				fixed = true;
			} catch (FileNotFoundHandler e) {
				e.getStackTrace();
			}
		} while(fixed == false);

		ClassStatistics statlab2 = new ClassStatistics(lab2);
		
		statlab2.findLowScore(lab2);
		statlab2.findHighScore(lab2);
		statlab2.calculateClassAverage(lab2);
		
		int i = 0;
		while(lab2[i] != null && i < lab2.length) {
			StudentGrade selectedStudent = new StudentGrade(lab2[i], statlab2);
			try {
				file.Export(selectedStudent);
			} catch (FileNotFoundHandler e) {
				e.printStackTrace();
			}
			++i;
		}
	}

	public void printStudentScore(int sid) {
		StudentGrade temp = null;
		try {
			temp = file.Import(sid);
		} catch (FileNotFoundHandler e) {
		}
		temp.getStudent().print();
	}

	public void printStatistics() {
		StudentGrade temp = null;
		try {
			temp = file.Import(1234);
		} catch (FileNotFoundHandler e) {
			e.printStackTrace();
		}
		temp.getStatistics().print();
	}

}
