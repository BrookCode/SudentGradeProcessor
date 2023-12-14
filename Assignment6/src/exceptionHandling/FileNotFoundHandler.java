package exceptionHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileNotFoundHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int errorno;
	private String errormsg;
	
	public FileNotFoundHandler() {
		super();
		printmyproblem();
	}
	
	public FileNotFoundHandler(String errormsg) {
		super();
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public FileNotFoundHandler(int errorno) {
		super();
		this.errorno = errorno;
		printmyproblem();
	}
	
	public FileNotFoundHandler(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printmyproblem();
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printmyproblem() {
		System.out.println("FixProblems [errorno=" + errorno + ", errormsg=" + errormsg);
		try {
			FileWriter out = new FileWriter("Errorlog.txt");
			out.append(errormsg);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String fixFileNotFound() {
		System.out.printf("%s\n", "Filename Incorrect Rerouting to default File");
		return "filename.txt";
	}
}
