package util;

import java.io.*;

import exceptionHandling.FileNotFoundHandler;
import student.StudentGrade;

public class FileIO {

	public FileIO() {
	}
	
	public void Export(StudentGrade stu) throws FileNotFoundHandler{
		try {
			File student = new File(stu.getStudent().getSID() + ".txt");
			FileOutputStream out = new FileOutputStream(student);
			ObjectOutputStream export = new ObjectOutputStream(out);
			export.writeObject(stu);
			export.close();
		} catch (IOException e) {
			throw new FileNotFoundHandler(e.getMessage());
		}
	}
	
	public StudentGrade Import(int stu) throws FileNotFoundHandler {
		StudentGrade temp = null;
		try {
			FileInputStream in = new FileInputStream(stu + ".txt");
			ObjectInputStream Import = new ObjectInputStream(in);
			temp = (StudentGrade) Import.readObject();
			Import.close();
		} catch (IOException e) {
			throw new FileNotFoundHandler(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new FileNotFoundHandler(e.getMessage());
		}
		return temp;
	}

}
