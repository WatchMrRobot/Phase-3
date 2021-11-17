package application;

import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Scanner;

import application.PatientManagement;

public class Home extends JFrame implements ActionListener 
{
    Container container = getContentPane();
    JButton openPatient = new JButton("Upload patient files");
    JButton viewAppointments = new JButton("View Past Appointments");
    JButton addPatient = new JButton("Add Patient");
    JButton editPatient = new JButton("Edit Patient");
    JButton addPatient2 = new JButton("Add Patient");
    JButton deletePatient2 = new JButton("Delete Patient");
    JButton deletePatient = new JButton("Delete Patient");
    JButton addAppointment = new JButton("Add Appointment");
    DefaultListModel<Patient> listModel = new DefaultListModel<>();
    JList<Patient> list = new JList(listModel);
    JLabel listL = new JLabel("Patient List");
	JTextField textField1 = new JTextField();
  	JTextField textField2 = new JTextField();
  	JTextField textField3 = new JTextField();
  	JLabel info = new JLabel("WELCOME!");
  	JLabel listHeader = new JLabel();
  	JLabel label = new JLabel("Test");
  	JLabel label1 = new JLabel("First and Last Name:");
  	JLabel label2 = new JLabel("Date of Birth:");
  	JLabel label3 = new JLabel("ID Number:");
  	JPanel panel = new JPanel();
  	WriteToFile x = new WriteToFile();
  	int test = 0;
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
	viewAppointments.setBounds(220, 5, 200, 35);
        addPatient.setBounds(220, 5, 200, 35);
        editPatient.setBounds(430, 5, 200, 35);
        deletePatient.setBounds(640, 5, 200, 35); 
    	listL.setBounds(10,70, 150, 35);
    	info.setBounds(300,70, 450, 35);
    	Font font = new Font("Verdana", Font.BOLD, 15);
    	info.setFont(font);
    	info.setForeground(Color.RED);
    	list.setBounds(10, 100, 350, 400);
    	label1.setBounds(430, 150, 200, 35);
    	label2.setBounds(430, 200, 200, 35);
    	label3.setBounds(430, 250, 200, 35);
    	textField1.setBounds(640, 150, 200, 35);
    	textField2.setBounds(640, 200, 200, 35);
    	textField3.setBounds(640, 250, 200, 35);
        addPatient2.setBounds(640, 300, 200, 35);
        deletePatient2.setBounds(430, 300, 200, 35);
        addAppointment.setBounds(430, 350, 200, 35);
    }

    public void addComponentsToContainer() {
        container.add(openPatient);
	container.add(viewAppointments);
        container.add(addPatient);
        container.add(editPatient);
        container.add(deletePatient);
        container.add(list);
        container.add(info);
        container.add(listL);
        container.add(label1);
        container.add(label2);
        container.add(label3);
        container.add(textField1);
        container.add(textField2);
        container.add(textField3);
        container.add(addPatient2);
        container.add(deletePatient2);
        container.add(addAppointment);
    }

    public void addActionEvent() {
        openPatient.addActionListener(this);
        addPatient2.addActionListener(this);
        editPatient.addActionListener(this);
        deletePatient2.addActionListener(this);
        addAppointment.addActionListener(this);
	viewAppointments.addActionListener(this);
        list.getSelectionModel().addListSelectionListener(ee -> {
    		info.setText("Number of Patients: " + patientManager.patientList.size());
		});
    }
    public void ReadFile() throws FileNotFoundException 
	{
		File read = new File("Patient.txt");
		if(read.exists() == true && test == 0)
		{
			Scanner reader = new Scanner(read);
			while(reader.hasNextLine() != false)
			{
				Patient ReturningPatient = new Patient();
				String name = reader.nextLine();
				String DOB = reader.nextLine();
				String ID = reader.nextLine();
				int Date = Integer.parseInt(DOB);
				int Identification = Integer.parseInt(ID);
				ReturningPatient.setName(name);
				ReturningPatient.setDOB(Date);
				ReturningPatient.setID(Identification);
				patientManager.addPatient(ReturningPatient);
				listModel.addElement(ReturningPatient);
			}
			info.setText("Patient records have been uploaded");
			reader.close();
			test = 1;
		}
		else if(read.exists() != true)
		{
			info.setText("No records available to upload");
		}
		else if(test == 1)
		{
			info.setText("Patient files have already been uploaded.");
		}
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
    	if (e.getSource() == viewAppointments)
    	{
            ViewPastAppointmentsFrame viewAppt = new ViewPastAppointmentsFrame();
            viewAppt.setTitle("Past Appointment Details");
            viewAppt.setVisible(true);
            viewAppt.setBounds(700, 400, 600, 400);
            viewAppt.setResizable(true);   
    	}
	
        if (e.getSource() == openPatient) {
        	   try {
					ReadFile();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

        }

        if (e.getSource() == addPatient2) {
            Patient newPatient;
            int newDOB = 0;
            int newID = 0;
            String newName = "?";
            boolean isEmptyFields = false;
            
            //If any field is empty, set isEmptyFields flag to true
            if (textField1.getText().equals("") || textField2.getText().equals("") || textField3.getText().equals(""))
            {
            	// Display error message if there are empty fields
            	isEmptyFields = true;
            	info.setText("Please fill all fields");
            }

            // If all fields are filled, try to add 
            if(!isEmptyFields) {
            	try {
            		int newIndex = 0;
	        		newName = textField1.getText();
	        		newDOB = Integer.parseInt(textField2.getText());
	        		newID = Integer.parseInt(textField3.getText());
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
        	
       }

       if (e.getSource() == deletePatient2) 
       {
        	int selectedIndex = list.getSelectedIndex();
        	if (selectedIndex != -1) 
        	{
        		Patient temp;
        		temp = listModel.getElementAt(list.getSelectedIndex());
        		try {
					x.DeletePatient(temp.getID());
					x.DeleteFromPatientFile(temp.getName(), temp.getID());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		listModel.removeElementAt(list.getSelectedIndex());
        		patientManager.removePatientIndex(selectedIndex);
        		info.setText("Number of Patients: " + patientManager.patientList.size());
        	}
       }
       if (e.getSource() == addAppointment) 
       {
           JOptionPane.showMessageDialog(this, "Please Enter Appointment Information");
           //super.setVisible(false);
           AddAppointmentFrame newAppt = new AddAppointmentFrame();
           newAppt.setTitle("Appointment Details");
           newAppt.setVisible(true);
           newAppt.setBounds(700, 400, 600, 400);
           newAppt.setResizable(false);           
       }
    }
}

