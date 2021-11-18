package application;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PatientHome extends JFrame implements ActionListener 
{
    Container container = getContentPane();
    JButton editPatient = new JButton("Edit Patient");
    JButton logout = new JButton("Logout");
  	JLabel info = new JLabel("WELCOME!");
  	JLabel listHeader = new JLabel();
  	JLabel label = new JLabel("Test");
  	JLabel nameL = new JLabel("JOHN SMITH");
  	JLabel dobL = new JLabel("DOB: ");
  	JLabel dobL2 = new JLabel("01012000");
  	JLabel idL = new JLabel("ID: ");
  	JLabel idL2 = new JLabel("123456");
  	JLabel heightL = new JLabel("Height: ");
  	JLabel heightL2 = new JLabel("5ft 10in");
  	JLabel weightL = new JLabel("Weight: ");
  	JLabel weightL2 = new JLabel("150lbs");
  	JLabel bpL = new JLabel("Blood Pressure: ");
  	JLabel bpL2 = new JLabel("110/80 mmHg");
  	JLabel cholesterolL = new JLabel("Cholesterol: ");
  	JLabel cholesterolL2 = new JLabel("Normal");
  	JLabel illnessL = new JLabel("Active Illnesses: ");
  	JLabel illnessL2 = new JLabel("None");
  	JLabel conditionL = new JLabel("Conditions: ");
  	JLabel conditionL2 = new JLabel("Leg injury");
  	JLabel medsL = new JLabel("Medications: ");
  	JLabel medsL2 = new JLabel("None");
  	JLabel appointmentL = new JLabel("Past Appointments:");
  	JLabel appointmentL2 = new JLabel("<CALL TOSTRING FROM APPOINTMENTS HERE>");
  	JPanel panel = new JPanel();
	
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
        logout.setBounds(640, 5, 200, 35); 
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
        container.add(editPatient);
        container.add(logout);
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
        container.add(appointmentL);
        container.add(appointmentL2);
    }

    public void addActionEvent() {
        editPatient.addActionListener(this);
        logout.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editPatient) 
        {
            Patient editPatient;
            int patientDOB = 0;
            int patientID = 0;
            String patientName = "?";
            boolean isEmptyFields = false;
            
            //If any field is empty, set isEmptyFields flag to true
            
            if (nameL.getText().equals("") || dobL2.getText().equals("") || idL2.getText().equals(""))
            {
            	// Display error message if there are empty fields
            	isEmptyFields = true;
            	info.setText("Please fill all fields");
            }
			
            // If all fields are filled, try to add 
            if(!isEmptyFields) {
            	try {
	        		patientName = nameL.getText();
	        		patientDOB = Integer.parseInt(dobL2.getText());
	        		patientID = Integer.parseInt(idL2.getText());
            		editPatient = new Patient();

    				JOptionPane.showMessageDialog(this, "Please Enter Additional Patient Information");
                    //super.setVisible(false);
                    EditPatientFrame newEditFrame = new EditPatientFrame(editPatient);
                    newEditFrame.setTitle("Patient Details");
                    newEditFrame.setVisible(true);
                    newEditFrame.setBounds(700, 400, 600, 700);
                    newEditFrame.setResizable(false);

            	}//end of try
                catch (NumberFormatException E) {

                	info.setText("Please enter integer values for Date of Birth and ID.");
                }
            }
        }
        if (e.getSource() == logout) 
        {
            JOptionPane.showMessageDialog(this, "Logging out now.");
            super.setVisible(false);
            LoginFrame frame = new LoginFrame();
            frame.setTitle("Patient Portal");
            frame.setVisible(true);
            frame.setBounds(900, 400, 600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
        }
    }
}

