package exceptionHandlerTest;

import java.util.Scanner;

import classStats.ClassStatistics;
import exceptionHandling.FileNotFoundHandler;
import student.Student;
import util.Util;

public class TESTReq1 {

	public static void main(String[] args) {
		Student lab2 [] = new Student[40];
		Util Util = new Util();
		String fileName = "filename.txt";
		
		Scanner in = new Scanner(System.in);
		System.out.printf("%s", "Please Input a File Name");
		fileName = in.next();
		in.close();
		
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
		
		int i = 0;
		System.out.printf("%s", "SID:");
		for(i = 0; i < lab2[0].getScores().length; ++i) {
			System.out.printf("\t%s%d", "Q", i);
		}
		i = 0;
		while(lab2[i] != null) {
			lab2[i].print();
			++i;
		}
		statlab2.print();
	}
}

/*
Test1: exception is caught and fixed
Please Input a File Name DoesnotExist.txt
FixProblems [errorno=0, errormsg=DoesnotExist.txt (The system cannot find the file specified)
Filename Incorrect Rerouting to default File
SID:	Q0	Q1	Q2	Q3	Q4
0000	0	0	0	0	0
High Scores:,0,0,0,0,0
Low Scores:,0,0,0,0,0
Average Scores:,0.000000,0.000000,0.000000,0.000000,0.000000

Test2: default file is entered without issue
Please Input a File Name fileName.txt
SID:	Q0	Q1	Q2	Q3	Q4
0000	0	0	0	0	0
High Scores:,0,0,0,0,0
Low Scores:,0,0,0,0,0
Average Scores:,0.000000,0.000000,0.000000,0.000000,0.000000

Test3:
Please Input a File Name CorrectFile.txt
SID:	Q0	Q1	Q2	Q3	Q4
1234	52	7	100	78	34
2134	90	36	90	77	30
3124	100	45	20	90	70
4532	11	17	81	32	77
5678	20	12	45	78	34
6134	34	80	55	78	45
7874	60	100	56	78	78
8026	70	10	66	78	56
9893	34	9	77	78	20
1947	45	40	88	78	55
2877	55	50	99	78	80
3189	22	70	100	78	77
4602	89	50	91	78	60
5405	11	11	0	78	10
6999	0	98	89	78	20
High Scores:,100,100,100,90,0
Low Scores:,0,7,0,32,10
Average Scores:,46.200001,42.333332,70.466667,75.666664,49.733334

Test4:
Please Input a File Name Jimbo
FixProblems [errorno=0, errormsg=Jimbo (The system cannot find the file specified)
Filename Incorrect Rerouting to default File
SID:	Q0	Q1	Q2	Q3	Q4
0000	0	0	0	0	0
High Scores:,0,0,0,0,0
Low Scores:,0,0,0,0,0
Average Scores:,0.000000,0.000000,0.000000,0.000000,0.000000

Test5:
Please Input a File Name Candy
FixProblems [errorno=0, errormsg=Candy (The system cannot find the file specified)
Filename Incorrect Rerouting to default File
SID:	Q0	Q1	Q2	Q3	Q4
0000	0	0	0	0	0
High Scores:,0,0,0,0,0
Low Scores:,0,0,0,0,0
Average Scores:,0.000000,0.000000,0.000000,0.000000,0.000000
*/
