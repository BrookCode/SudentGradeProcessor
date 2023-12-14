package classStats;
import java.io.Serializable;

import student.Student;

public class ClassStatistics implements Serializable{
	private static final long serialVersionUID = 7899282681916980220L;
	private float[] classAvg =  null;
	private int[] lowScores = null;
	private int[] highScores = null;

	public ClassStatistics() {
	}
	
	public ClassStatistics(Student[] origin) {
		classAvg = new float[origin[0].getScores().length];
		lowScores = new int[origin[0].getScores().length];
		highScores = new int[origin[0].getScores().length];
	}

	public float[] getClassAvg() {
		return classAvg;
	}

	public void setClassAvg(float[] classAvg) {
		this.classAvg = classAvg;
	}

	public int[] getLowScores() {
		return lowScores;
	}

	public void setLowScores(int[] lowScores) {
		this.lowScores = lowScores;
	}

	public int[] getHighScores() {
		return highScores;
	}

	public void setHighScores(int[] highScores) {
		this.highScores = highScores;
	}

	public void calculateClassAverage(Student[] origin) {
		float total = 0f;
		int i = 0;
		for(int j = 0; j < origin[0].getScores().length; ++j) {
			for(i = 0; i < origin.length; ++i) {
				if(origin[i] == null) {
					break;
				}
				total += origin[i].getScore(j);
			}
			classAvg[j]  = total/i;
			total = 0f;
		}
	}
	
	public void findLowScore(Student[] origin) {
		for(int i = 0; i < origin[0].getScores().length; ++i) {
			lowScores[i] = origin[0].getScore(i);
			for(int j = 0; j < origin.length; ++j) {
				if(origin[j] == null) {
					break;
				}
				if(origin[j].getScore(i) < lowScores[i]) {
					lowScores[i] = origin[j].getScore(i);
				}
			}
		}
	}
	
	public void findHighScore(Student[] origin) {
		for(int i = 0; i < origin[0].getScores().length-1; ++i) {
			highScores[i] = origin[0].getScore(i);
			for(int j = 0; j < origin.length; ++j) {
				if(origin[j] == null) {
					break;
				}
				else if(origin[j].getScore(i) > highScores[i]) {
					highScores[i] = origin[j].getScore(i);
				}
			}
		}
	}
	
	public void print() {
		System.out.printf("\n%s", "High Scores:");
		for(int i = 0; i < highScores.length; ++i) {
			System.out.printf("%s%d", ",", highScores[i]);
		}
		
		System.out.printf("\n%s", "Low Scores:");
		for(int i = 0; i < lowScores.length; ++i) {
			System.out.printf("%s%d", ",", lowScores[i]);
		}
		
		System.out.printf("\n%s", "Average Scores:");
		for(int i = 0; i < classAvg.length; ++i) {
			System.out.printf("%s%f", ",", classAvg[i]);
		}
	}
}
