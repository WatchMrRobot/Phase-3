package application;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.Patient;

public class PatientHome extends JFrame implements ActionListener 
{
	
    Container container = getContentPane();
    JButton editPatient = new JButton("Edit Patient");
    JButton uploadDetails = new JButton("Verify ID");
  	JLabel info = new JLabel("WELCOME!");
  	JLabel listHeader = new JLabel();
  	JLabel label = new JLabel("Test");
  	JLabel nameL = new JLabel("Verify ID to see Details");
  	JLabel dobL = new JLabel("DOB: ");
  	JLabel dobL2 = new JLabel("");
  	JLabel idL = new JLabel("ID: ");
  	JLabel idL2 = new JLabel("");
  	JLabel heightL = new JLabel("Height: ");
  	JLabel heightL2 = new JLabel("");
  	JLabel weightL = new JLabel("Weight: ");
  	JLabel weightL2 = new JLabel("");
  	JLabel bpL = new JLabel("Blood Pressure: ");
  	JLabel bpL2 = new JLabel(" mmHg");
  	JLabel cholesterolL = new JLabel("Cholesterol: ");
  	JLabel cholesterolL2 = new JLabel("Normal");
  	JLabel illnessL = new JLabel("Active Illnesses: ");
  	JLabel illnessL2 = new JLabel("");
  	JLabel conditionL = new JLabel("Conditions: ");
  	JLabel conditionL2 = new JLabel("");
  	JLabel medsL = new JLabel("Vaccninations: ");
  	JLabel medsL2 = new JLabel("");
  	JLabel appointmentL = new JLabel("Past Appointments:");
  	JLabel appointmentL2 = new JLabel("<CALL TOSTRING FROM APPOINTMENTS HERE>");
  	JPanel panel = new JPanel();
  	JTextField ID = new JTextField();
	
	PatientHome()
	{
        setLayoutManager();
        setPos();
        addComponentsToContainer();
        addActionEvent();
	}
	
	public void setLayoutManager()
	{
		container.setLayout(null);
	}
	
    public void setPos() {
        editPatient.setBounds(10, 10, 200, 35);
        uploadDetails.setBounds(220, 10, 200, 35);
        ID.setBounds(430, 10, 200, 35);
        
    	info.setBounds(400, 50, 450, 35);
    	nameL.setBounds(10, 50, 300, 35);
    	dobL.setBounds(10, 70, 200, 35);
    	dobL2.setBounds(50, 70, 200, 35);
    	idL.setBounds(170, 70, 200, 35);
    	idL2.setBounds(200, 70, 200, 35);
    	heightL.setBounds(10, 110, 200, 35);
    	heightL2.setBounds(60, 110, 200, 35);
    	weightL.setBounds(170, 110, 200, 35);
    	weightL2.setBounds(225, 110, 200, 35);
    	bpL.setBounds(330, 110, 200, 35);
    	bpL2.setBounds(430, 110, 200, 35);
    	cholesterolL.setBounds(570, 110, 200, 35);
    	cholesterolL2.setBounds(650, 110, 200, 35);
    	illnessL.setBounds(10, 150, 200, 35);
    	illnessL2.setBounds(10, 170, 200, 35);
    	conditionL.setBounds(10, 210, 200, 35);
    	conditionL2.setBounds(10, 230, 200, 35);
    	medsL.setBounds(10, 290, 200, 35);
    	medsL2.setBounds(10, 310, 200, 35);
    	appointmentL.setBounds(10, 400, 200, 35);
    	appointmentL2.setBounds(10, 420, 600, 35);
    	
    	Font font = new Font("Verdana", Font.BOLD, 15);
    	Font font2 = new Font("Verdana", Font.BOLD, 13);
    	info.setFont(font);
    	info.setForeground(Color.green);
    	nameL.setFont(font);
    	dobL.setFont(font2);
    	idL.setFont(font2);
    	if (cholesterolL2.getText() == "Normal")
    	{
    		cholesterolL2.setForeground(Color.GREEN);
    	}
    	else
    	{
    		cholesterolL2.setForeground(Color.RED);
    	}
    }

    public void addComponentsToContainer() {
       // container.add(editPatient);
        container.add(info);
        container.add(nameL);
        container.add(dobL);
        container.add(dobL2);
        container.add(idL);
        container.add(idL2);
        container.add(heightL);
        container.add(heightL2);
        container.add(weightL);
        container.add(weightL2);
        container.add(bpL);
        container.add(bpL2);
        container.add(cholesterolL);
        container.add(cholesterolL2);
        container.add(illnessL);
        container.add(illnessL2);
        container.add(conditionL);
        container.add(conditionL2);
        container.add(medsL);
        container.add(medsL2);
    //    container.add(appointmentL);
  //      container.add(appointmentL2);
        container.add(uploadDetails);
        container.add(ID);
    }

    public void addActionEvent() {
        editPatient.addActionListener(this);
        uploadDetails.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editPatient) {
            Patient newPatient;
            int newDOB = 0;
            int newID = 0;
            String newName = "?";
            boolean isEmptyFields = false;
        }
        if (e.getSource() == uploadDetails)
        {
        	String num = ID.getText();
        	File temp = new File(num + ".txt");
        	if(temp.exists() == true)
        	{
				try {
					Scanner Read = new Scanner(temp);
					String name = Read.next();
					String DOB = Read.next();
					String ID = Read.next();
					String Height = Read.next();
					String Weight = Read.next();
					String BP = Read.next();
					String Cholesterol = Read.next();
					String Vaccinations = Read.next();
					String Conditions = Read.next();
					String Active = Read.next();
				    nameL.setText("Name: " + name);
				    dobL2.setText(DOB);
				    idL2.setText(ID);
				    weightL2.setText(Weight);
				    bpL2.setText( BP + " mmHg");
				    cholesterolL2.setText(Cholesterol);
				    medsL2.setText(Vaccinations);
				    conditionL2.setText(Conditions);
				    illnessL2.setText(Active);
				    heightL2.setText(Height);
				    
				    
				    
				  	

					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        }
    }
}
