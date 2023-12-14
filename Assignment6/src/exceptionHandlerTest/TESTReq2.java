package exceptionHandlerTest;

import java.util.Scanner;

import classStats.ClassStatistics;
import exceptionHandling.FileNotFoundHandler;
import student.Student;
import student.StudentGrade;
import util.FileIO;
import util.Util;

public class TESTReq2 {

	public static void main(String[] args) {
		Student lab2 [] = new Student[40];
		Util Util = new Util();
		String fileName = "filename.txt";
		
		Scanner in = new Scanner(System.in);
		System.out.printf("%s", "Please Input a File Name");
		fileName = in.next();
		
		boolean fixed = false;
		do {
			try {
				lab2 = Util.ReadFile(fileName, lab2);
				fixed = true;
			} catch (FileNotFoundHandler e) {
				fileName = e.fixFileNotFound();
			}
		} while(fixed == false);

		ClassStatistics statlab2 = new ClassStatistics(lab2);
		
		statlab2.findLowScore(lab2);
		statlab2.findHighScore(lab2);
		statlab2.calculateClassAverage(lab2);
		
		System.out.printf("%s", "Select student to serialize:");
		int i = in.nextInt();
		in.close();
		FileIO file = new FileIO();
		StudentGrade selectedStudent = new StudentGrade(lab2[i], statlab2);
		try {
			file.Export(selectedStudent);
		} catch (FileNotFoundHandler e) {
		}
	}
}
/*
Check Email Attachments for properly Serialized Text files
Test1:
Please Input a File Name fileName
FixProblems [errorno=0, errormsg=fileName (The system cannot find the file specified)
Filename Incorrect Rerouting to default File
Select student to serialize: 0

Test2:
Please Input a File Name CorrectFile.txt
Select student to serialize: 0

Test3:
Please Input a File Name CorrectFile.txt
Select student to serialize:13

Test4:
Please Input a File Name CorrectFile.txt
Select student to serialize: 10

Test5:
Please Input a File Name CorrectFile.txt
Select student to serialize: 3
*/
