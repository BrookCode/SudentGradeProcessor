package student;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = -1561208046652683056L;
	private String SID = "0000";
	private int [] scores = null;

	public Student() {
	}

	public Student(String sID, int[] scores) {
		SID = sID;
		this.scores = scores;
	}

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		SID = sID;
	}

	public int getScore(int scoreNum) {
		return scores[scoreNum];
	}

	public void setScore(int scoreNum,int score) {
		this.scores[scoreNum] = score;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public void print() {
		System.out.printf("\n%s", SID);
		for(int i = 0; i < scores.length; ++i) {
			System.out.printf("\t%d", scores[i]);
		}
	}
	

}
