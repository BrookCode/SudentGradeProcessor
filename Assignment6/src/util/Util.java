package util;

import java.io.*;
import java.util.StringTokenizer;

import student.Student;
import exceptionHandling.FileNotFoundHandler;

public class Util {
	private String fName = null;

	public Util() {
	}

	public Util(String fName) {
		super();
		this.fName = fName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public Student[] ReadFile(String fileName, Student [] stu) throws FileNotFoundHandler{
		try {

			FileReader Inport = new FileReader(fileName);
			BufferedReader inBuff = new BufferedReader(Inport);

			boolean eof = false;
			int i = 0;
			while (!eof) {
				String temp = inBuff.readLine();
				if(temp == null) {
					eof = true;
				} else {
					StringTokenizer tokenize = new StringTokenizer(temp);
					stu[i] = new Student(null, new int[tokenize.countTokens()-1]);
					stu[i].setSID(tokenize.nextToken());
					int j = 0;
					while(tokenize.hasMoreTokens()) {
						stu[i].setScore(j, Integer.parseInt(tokenize.nextToken()));
						++j;
					}
				}
				++i;
			}
			inBuff.close();
		} catch (FileNotFoundException e) {
			throw new FileNotFoundHandler(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		return stu;
	}

}
