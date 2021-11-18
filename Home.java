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

public class Home extends JFrame implements ActionListener 
{
    Container container = getContentPane();
    JButton openPatient = new JButton("Open Patient");
    JButton addPatient = new JButton("Add Patient");
    JButton editPatient = new JButton("Edit Patient");
    JButton addPatient2 = new JButton("Add Patient");
    JButton deletePatient2 = new JButton("Delete Patient");
    JButton logout = new JButton("Logout");
    JButton viewAppointment = new JButton("View Appointments");
    DefaultListModel<Patient> listModel = new DefaultListModel<>();
    JList<Patient> list = new JList(listModel);
    JLabel listL = new JLabel("Patient List");
	JTextField nameL = new JTextField();
  	JTextField dobL2 = new JTextField();
  	JTextField idL2 = new JTextField();
  	JLabel info = new JLabel("WELCOME!");
  	JLabel listHeader = new JLabel();
  	JLabel label = new JLabel("Test");
  	JLabel label1 = new JLabel("First and Last Name:");
  	JLabel label2 = new JLabel("Date of Birth:");
  	JLabel label3 = new JLabel("ID Number:");
  	JPanel panel = new JPanel();
	public static PatientManagement patientManager = new PatientManagement();
	
	Home()
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
        openPatient.setBounds(10, 5, 200, 35);
        viewAppointment.setBounds(220, 5, 200, 35);
        editPatient.setBounds(430, 5, 200, 35);
        logout.setBounds(640, 5, 200, 35); 
    	listL.setBounds(10,70, 150, 35);
    	info.setBounds(300,70, 450, 35);
    	Font font = new Font("Verdana", Font.BOLD, 15);
    	info.setFont(font);
    	info.setForeground(Color.RED);
    	list.setBounds(10, 100, 350, 400);
    	label1.setBounds(430, 150, 200, 35);
    	label2.setBounds(430, 200, 200, 35);
    	label3.setBounds(430, 250, 200, 35);
    	nameL.setBounds(640, 150, 200, 35);
    	dobL2.setBounds(640, 200, 200, 35);
    	idL2.setBounds(640, 250, 200, 35);
        addPatient2.setBounds(640, 300, 200, 35);
        deletePatient2.setBounds(430, 300, 200, 35);

    }

    public void addComponentsToContainer() {
        container.add(openPatient);
        container.add(editPatient);
        container.add(logout);
        container.add(list);
        container.add(info);
        container.add(listL);
        container.add(label1);
        container.add(label2);
        container.add(label3);
        container.add(nameL);
        container.add(dobL2);
        container.add(idL2);
        container.add(addPatient2);
        container.add(deletePatient2);
        container.add(viewAppointment);
    }
    public void editPatient(int selectedIndex, EditPatientFrame newEditFrame)
    {
    	 
		 patientManager.patientList.get(selectedIndex).setAddress(newEditFrame.addressF.getText());
		 patientManager.patientList.get(selectedIndex).setHeight(Integer.parseInt(newEditFrame.heightF.getText()));
		 patientManager.patientList.get(selectedIndex).setWeight(Integer.parseInt(newEditFrame.weightF.getText()));
		 patientManager.patientList.get(selectedIndex).setBloodPressure(Integer.parseInt(newEditFrame.bloodPressureF.getText()));
		 patientManager.patientList.get(selectedIndex).setCholesterol(Integer.parseInt(newEditFrame.cholesterolF.getText()));
		 patientManager.patientList.get(selectedIndex).setVaccinations(newEditFrame.vaccinationsF.getText());
		 patientManager.patientList.get(selectedIndex).setConditions(newEditFrame.conditionsF.getText());
    }

    public void addActionEvent() {
        openPatient.addActionListener(this);
        addPatient2.addActionListener(this);
        editPatient.addActionListener(this);
        deletePatient2.addActionListener(this);
        viewAppointment.addActionListener(this);
        logout.addActionListener(this);
        list.getSelectionModel().addListSelectionListener(ee -> {
    		info.setText("Number of Patients: " + patientManager.patientList.size());
		});
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openPatient) {

        }

        if (e.getSource() == addPatient2) {
            Patient newPatient;
            int newDOB = 0;
            int newID = 0;
            String newName = "?";
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
	        		newName = nameL.getText();
	        		newDOB = Integer.parseInt(dobL2.getText());
	        		newID = Integer.parseInt(idL2.getText());
            		newPatient = new Patient();
            		for(int i = 0; i < patientManager.patientList.size(); i++)
            		{           			
            			if (patientManager.patientExists(newName, newDOB, newID) > -1)
            			{
            				throw new Exception();
            			} 
            		} 
            		newPatient.setName(newName);
            		newPatient.setDOB(newDOB);
            		newPatient.setID(newID);
            		patientManager.addPatient(newPatient);
            		listModel.addElement(newPatient);
            		info.setText("Patient added");
                    JOptionPane.showMessageDialog(this, "Please Enter Additional Patient Information");
                    //super.setVisible(false);
                    AddPatientFrame newAddFrame = new AddPatientFrame(newPatient);
                    newAddFrame.setTitle("Patient Details");
                    newAddFrame.setVisible(true);
                    newAddFrame.setBounds(700, 400, 600, 700);
                    newAddFrame.setResizable(false);
                    newAddFrame.cancelButton.addActionListener(new ActionListener() 
                    {
                    	public void actionPerformed(ActionEvent e) 
                    	{
                    		listModel.removeElement(listModel.lastElement());
                    		patientManager.removePatientIndex(patientManager.patientList.size() - 1);
                    	}

                    });
                } //end of try
                catch (NumberFormatException E) {

                	info.setText("Please enter integer values for Date of Birth and ID.");
                } 
                catch (Exception E) {
                    // Catches generic exception and displays message
                	info.setText("Patient was not added - Patient already exists. ");
                }
            }
        }
       
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
            		for(int i = 0; i < patientManager.patientList.size(); i++)
            		{           			
            			if (patientManager.patientExists(patientName, patientDOB, patientID) > -1)
            			{
            				JOptionPane.showMessageDialog(this, "Please Enter Additional Patient Information");
	                        //super.setVisible(false);
	                        EditPatientFrame newEditFrame = new EditPatientFrame(editPatient);
	                        newEditFrame.setTitle("Patient Details");
	                        newEditFrame.setVisible(true);
	                        newEditFrame.setBounds(700, 400, 600, 700);
	                        newEditFrame.setResizable(false);
	                         
	                     	int selectedIndex = list.getSelectedIndex();
	                    	if (selectedIndex != -1) 
	                    	{
	                    		newEditFrame.editButton.addActionListener(new ActionListener() 
		                        {
		                        	 public void actionPerformed(ActionEvent e) 
		                        	 {
		                        		 //listModel.removeElement(listModel.lastElement());
		                        		 //patientManager.removePatientIndex(patientManager.patientList.size() - 1);
		                        		 //editPatient(selectedIndex, newEditFrame);
		                        		 patientManager.patientList.get(selectedIndex).setAddress(newEditFrame.addressF.getText());
		                        		 patientManager.patientList.get(selectedIndex).setHeight(Integer.parseInt(newEditFrame.heightF.getText()));
		                        		 patientManager.patientList.get(selectedIndex).setWeight(Integer.parseInt(newEditFrame.weightF.getText()));
		                        		 patientManager.patientList.get(selectedIndex).setBloodPressure(Integer.parseInt(newEditFrame.bloodPressureF.getText()));
		                        		 patientManager.patientList.get(selectedIndex).setCholesterol(Integer.parseInt(newEditFrame.cholesterolF.getText()));
		                        		 patientManager.patientList.get(selectedIndex).setVaccinations(newEditFrame.vaccinationsF.getText());
		                        		 patientManager.patientList.get(selectedIndex).setConditions(newEditFrame.conditionsF.getText());
		                        	 }
		                        });
	                    	}
            			} 
            		}
            	}//end of try
                catch (NumberFormatException E) {

                	info.setText("Please enter integer values for Date of Birth and ID.");
                }
            }
        }


       if (e.getSource() == deletePatient2) 
       {
        	int selectedIndex = list.getSelectedIndex();
        	if (selectedIndex != -1) 
        	{
        		listModel.removeElementAt(list.getSelectedIndex());
        		patientManager.removePatientIndex(selectedIndex);
        		info.setText("Number of Patients: " + patientManager.patientList.size());
        	}
       }
       if (e.getSource() == viewAppointment) 
       {
           JOptionPane.showMessageDialog(this, "Opening Appointment List");
           //super.setVisible(false);
           ViewPastAppointmentsFrame newAppt = new ViewPastAppointmentsFrame();
           newAppt.setTitle("Appointment Details");
           newAppt.setVisible(true);
           newAppt.setBounds(800, 500, 600, 400);
           newAppt.setResizable(false);           
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

