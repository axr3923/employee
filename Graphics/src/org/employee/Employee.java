package org.employee;

public class Employee {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 8517557750765849703L;
	private String fName;
	private String lName;
	private double rate;
	private Integer iD;
	
	public Employee(String fName, String lName, double rate,Integer iD) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.rate=rate;
		this.iD=iD;
	
	}

	public Integer getiD() {
		return iD;
	}

	public void setiD(Integer iD) {
		this.iD = iD;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

}
