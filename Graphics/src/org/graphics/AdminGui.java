package org.graphics;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminGui extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5473933783047296499L;
	JFrame frame=new JFrame("Admin Console");
	JPanel admPane=new JPanel(new GridLayout(6,1,5,5));
	JButton addEmp=new JButton("Add New Employee");
	JButton delEmp=new JButton("Delete Employee");
	JButton empList=new JButton("Employee List");
	JButton viewRep=new JButton("View Report");
	JButton mainMenu=new JButton ("Main Menu");
	JButton exit=new JButton("Exit");
	JButton submit=new JButton("Submit");
	JTextField iD=new JTextField(4);
	JTextField fName=new JTextField(20);
	JTextField lName=new JTextField(20);
	JTextField Rate=new JTextField(3);
	
	public AdminGui(){
		admPane.add(addEmp);
		admPane.add(delEmp);
		admPane.add(empList);
		admPane.add(mainMenu);
		admPane.add(exit);
		admPane.add(submit);
		
		frame.setSize(300, 300);
		frame.setLocation(300, 250);
		frame.setContentPane(admPane);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		addEmp.addActionListener(this);
		delEmp.addActionListener(this);
		empList.addActionListener(this);
		mainMenu.addActionListener(this);
		exit.addActionListener(this);
		submit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==addEmp){
			new AdminGui().AddEmployee();
		}
		else if(source==delEmp){
			
		}
		else if(source==empList){
			
		}
		else if(source==mainMenu){
			
		}
		else if(source==exit){
			
		}
		else if(source==submit){
			System.out.println("hello");
		}
	}
	public void AddEmployee(){
		JFrame addFrame=new JFrame("Add New Employee");
		JPanel addPanel=new JPanel();
		JPanel fn=new JPanel();
		JPanel ln=new JPanel();
		JPanel rate=new JPanel();
		JPanel id=new JPanel();
		
		addPanel.add(fn);
		addPanel.add(ln);
		addPanel.add(rate);
		addPanel.add(id);
		addPanel.add(submit);
		
		fn.add(new JLabel("First Name"));
		fn.add(fName);
		
		ln.add(new JLabel("Last Name"));
		ln.add(lName);
		
		rate.add(new JLabel("Rate"));
		rate.add(Rate);
		
		id.add(new JLabel("ID"));
		id.add(iD);

		submit.addActionListener(this);
		
		addFrame.setContentPane(addPanel);
		addFrame.setSize(400, 200);
		addFrame.setLocation(300,250);
		addFrame.setVisible(true);
	}

}
