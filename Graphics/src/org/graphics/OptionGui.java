package org.graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.employee.services.EmployeeService;

public class OptionGui extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6444503631222382442L;
	
	
	
	//AddButton addButton=new AddButton();
	JFrame adminFrame=new JFrame("Admin Login");
	JFrame empFrame=new JFrame("Employee Login");
	JButton employeeButton;
	JButton adminButton;
	JButton cancelButton;
	JButton submit;
	JButton ok;
	JTextField adminUN=new JTextField(15);
	JTextField adminPW=new JPasswordField(15);
	JTextField empID=new JTextField(5);
	
	public OptionGui(){
		employeeButton=new JButton("Employee");
		adminButton=new JButton("Admin");
		cancelButton=new JButton("Cancel");
		
		
		add(employeeButton);
		add(adminButton);
		add(cancelButton);
		
		employeeButton.addActionListener(this);
		adminButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==employeeButton){
			new OptionGui().employeeIdGui();
		}
		else if (source==adminButton){
			new OptionGui().adminIdGui();
		}
		else if(source==submit){
			new EmployeeService().adminLogin(adminUN, adminPW);
			adminFrame.dispose();
		}
		else if(source==ok){
			new EmployeeService().employeeLogin(empID);
			empFrame.dispose();;
		}
		else{
			System.exit(0);
		}
	}
	
	public void employeeIdGui(){
		ok=new JButton("Ok");

		JPanel Emp=new JPanel();
		Emp.setBorder(new EmptyBorder(5,5,5,5));
		empFrame.setLocation(350,300);
		empFrame.setContentPane(Emp);
		
		JPanel empN=new JPanel(new GridLayout(0,1));
		JPanel empA=new JPanel(new GridLayout(0,1));
		
		Emp.add(empN,BorderLayout.WEST);
		Emp.add(empA, BorderLayout.CENTER);
		
		empN.add(new JLabel("Enter Employee ID:"));
		empA.add(empID);
		
		Emp.add(ok,BorderLayout.SOUTH);
		ok.addActionListener(this);
		
		empFrame.pack();
		empFrame.setVisible(true);

	}
	
	public void adminIdGui(){
		submit=new JButton("Submit");
		
		JPanel admin=new JPanel(new BorderLayout(3,3));
		admin.setBorder(new EmptyBorder(5,5,5,5));
		adminFrame.setLocation(350,300);
		adminFrame.setContentPane(admin);
		
		JPanel adminU=new JPanel(new GridLayout(0,1));
		JPanel adminP=new JPanel(new GridLayout(0,1));
		
		admin.add(adminU,BorderLayout.WEST);
		admin.add(adminP,BorderLayout.CENTER);
		
		adminU.add(new JLabel("Useranme:"));
		adminP.add(adminUN);
		adminU.add(new JLabel("Password:"));
		adminP.add(adminPW);
		
		
		
		admin.add(submit,BorderLayout.SOUTH);
		
		submit.addActionListener(this);
		
		//JOptionPane.showConfirmDialog(null,adminPanel);
		adminFrame.pack();
		adminFrame.setVisible(true);
		
	}
	public void employeeError(String empId,String eID){
		JPanel empErr=new JPanel();
		Integer cc;
		cc=JOptionPane.OK_OPTION;
		if(empId.equals("empty")){
			JOptionPane.showMessageDialog(empErr, "Please Enter Your ID","Error",JOptionPane.ERROR_MESSAGE);
				if(cc==0)
				{
					new OptionGui().employeeIdGui();
					//setVisible(false);
				}
		}
		else if(!empId.equals(eID)){
			JOptionPane.showMessageDialog(empErr, "Employee ID not registered","Error",JOptionPane.ERROR_MESSAGE);
			if(cc==0){
				new OptionGui();
				//setVisible(false);
			}
		}
	}
	
	public void adminError(String error,String error1){
		JPanel err=new JPanel();
		Integer cc;
		cc=JOptionPane.OK_OPTION;
		if(error.equals("") || error1.equals("")){
			JOptionPane.showMessageDialog(err, "One or More Field is Empty","Error",JOptionPane.ERROR_MESSAGE);
			if(cc==0){
				new OptionGui().adminIdGui();
				setVisible(false);
			}
		}
		else{
			JOptionPane.showMessageDialog(err, "Username/Password Doesn't Match","Error",JOptionPane.ERROR_MESSAGE);
			if(cc==0){
				new OptionGui();
			}
		}
	}
	
}
