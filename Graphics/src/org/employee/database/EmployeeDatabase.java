package org.employee.database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.employee.Admin;
import org.employee.Employee;
import org.graphics.OptionGui;
import org.graphics.AdminGui;
import org.graphics.AdminPage;
import org.graphics.CheckInCheckOut;

public class EmployeeDatabase {
	String reader;
	Employee employee=new Employee(null,null,0,0);
	Admin admin=new Admin(null,null);


	public EmployeeDatabase(){
		
	}
	
	public void employeeAuthentication(String filename,String empId){
		boolean empAuth=false;
		Integer id=Integer.parseInt(empId);
		empAuth=fileReader(empAuth,filename,id);
		if(empAuth==true){
			new CheckInCheckOut(employee);
		}
		else{
			new OptionGui().employeeError(empId,employee.getiD().toString());
		}
	}
	
	
	public void adminAuthentication(String filename,String adminUN, String adminPW){
		boolean adminAuth=false;
		adminAuth=fileReader(adminAuth,filename,adminUN,adminPW);
		if(adminAuth==true){
			new AdminGui();
		}
		else{
			new OptionGui().adminError(adminUN,adminPW);
		}
	}
	
	
	public boolean fileReader(boolean answer,String filename,String adminUN,String adminPW){
		boolean ans=false;
		try{
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
				while((reader=br.readLine())!=null){
					StringTokenizer st=new StringTokenizer(reader,",");
					while(st.hasMoreTokens()){
						admin.setUserName(st.nextToken());
						admin.setPassWord(st.nextToken());
						st.nextToken();
						st.nextToken();
						if(admin.getUserName().equals(adminUN) && admin.getPassWord().equals(adminPW)){
							ans=true;
						}
						else {
							ans=false;
						}
					}
					
				}
		}
		catch(Exception FileNotFound){
			System.out.println(FileNotFound);
		}
		return ans;
	}
	

	public boolean fileReader(boolean answer,String filename,Integer empId){
		boolean ans=false;
		String eID="";
		eID=eID+empId;
		try{
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			while((reader=br.readLine())!=null){
				StringTokenizer st=new StringTokenizer(reader,",");
				while(st.hasMoreTokens()){
					employee.setfName(st.nextToken());
					employee.setlName(st.nextToken());
					employee.setRate(Double.parseDouble(st.nextToken()));
					employee.setiD(Integer.parseInt(st.nextToken()));
					if(employee.getiD().equals(empId)){
						 ans=true;
					}
					else{
						ans=false;
					}
				}
			}
		}
		catch(Exception FileNotFound){
			System.out.println(FileNotFound);
		}
		return ans;
	}

}
