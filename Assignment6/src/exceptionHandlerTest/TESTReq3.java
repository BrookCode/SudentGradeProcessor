package exceptionHandlerTest;
import adapter.*;

public class TESTReq3 {

	public TESTReq3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		StudentAPI a1 = new SAPI();
		a1.printStudentScore(8026);
		a1.printStatistics();
	}
}
/*
tested for verious students
1234	52	7	100	78	34
High Scores:,100,100,100,90,0
Low Scores:,0,7,0,32,10
Average Scores:,46.200001,42.333332,70.466667,75.666664,49.733334

1947	45	40	88	78	55
High Scores:,100,100,100,90,0
Low Scores:,0,7,0,32,10
Average Scores:,46.200001,42.333332,70.466667,75.666664,49.733334

2134	90	36	90	77	30
High Scores:,100,100,100,90,0
Low Scores:,0,7,0,32,10
Average Scores:,46.200001,42.333332,70.466667,75.666664,49.733334

9893	34	9	77	78	20
High Scores:,100,100,100,90,0
Low Scores:,0,7,0,32,10
Average Scores:,46.200001,42.333332,70.466667,75.666664,49.733334

8026	70	10	66	78	56
High Scores:,100,100,100,90,0
Low Scores:,0,7,0,32,10
Average Scores:,46.200001,42.333332,70.466667,75.666664,49.733334
 */