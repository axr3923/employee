package org.employee.services;

import javax.swing.JTextField;

import org.employee.database.EmployeeDatabase;
import org.graphics.OptionGui;

public class EmployeeService {
	
	EmployeeDatabase employeeDatabase=new EmployeeDatabase();
	OptionGui gui=new OptionGui();
	
	public EmployeeService(){
		
	}
	
	public void employeeLogin(JTextField employeeId){
		String holder=employeeId.getText();
		if(holder.equals("")){
			gui.employeeError("empty","empty");
		}
		//Integer emId=Integer.parseInt(employeeId.getText());
		else{
			employeeDatabase.employeeAuthentication("employee.txt",holder);
		}
	}
	
	public void adminLogin(JTextField adminUN,JTextField adminPW){
		String adminUser=adminUN.getText();
		String adminPass=adminPW.getText();
		employeeDatabase.adminAuthentication("employee.txt",adminUser,adminPass);
		
	}

}
