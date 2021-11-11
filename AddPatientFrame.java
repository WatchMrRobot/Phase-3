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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddPatientFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userL = new JLabel("USERNAME");
    JLabel passL = new JLabel("PASSWORD");
    JLabel nameL = new JLabel("NAME");
    JLabel DOBL = new JLabel("DOB");
    JLabel IDL = new JLabel("ID");
    JLabel addressL = new JLabel("ADDRESS");
    JTextField userF = new JTextField("A");
    JPasswordField passF = new JPasswordField("1");
    JTextField nameF = new JTextField("N");
    JTextField DOBF = new JTextField("D");
    JTextField IDF = new JTextField("I");
    JTextField addressF = new JTextField("ADDRESS");
    JButton addButton = new JButton("ADD PATIENT");
    JButton cancelButton = new JButton("CANCEL");
    JCheckBox show = new JCheckBox("Show Password");
  	JLabel info = new JLabel("Please enter patient details");
  	WriteToFile test = new WriteToFile();
  	
    AddPatientFrame(Patient newPatient)
	{
        String name = newPatient.getName();
        int DOB = newPatient.getDOB();
        int ID = newPatient.getID();
    	setLayoutManager();
        setPos();
        addComponentsToContainer();
        addActionEvent();
        nameF.setText(name);
        DOBF.setText(Integer.toString(DOB));
        IDF.setText(Integer.toString(ID));
	}
	
	private void setLayoutManager() {
        container.setLayout(null);
	}

	private void setPos() {
        userL.setBounds(150, 100, 100, 35);
        passL.setBounds(150, 140, 100, 35);
        nameL.setBounds(150, 180, 100, 35);
        DOBL.setBounds(150, 220, 100, 35);
        IDL.setBounds(150, 260, 100, 35);
        addressL.setBounds(150, 300, 100, 35);
        userF.setBounds(250, 100, 175, 35);
        passF.setBounds(250, 140, 175, 35);
        nameF.setBounds(250, 180, 175, 35);
        DOBF.setBounds(250, 220, 175, 35);
        IDF.setBounds(250, 260, 175, 35);
        addressF.setBounds(250, 300, 175, 35);
        show.setBounds(150, 400, 150, 30);
        addButton.setBounds(150, 340, 125, 50);
        cancelButton.setBounds(300, 340, 125, 50);
    	info.setBounds(150, 450, 450, 35);
    	Font font = new Font("Verdana", Font.BOLD, 14);
    	info.setFont(font);
    	info.setForeground(Color.RED);
	}
	
	private void addComponentsToContainer() {
        container.add(userL);
        container.add(passL);
        container.add(nameL);
        container.add(DOBL);
        container.add(IDL);
        container.add(addressL);
        container.add(userF);
        container.add(passF);
        container.add(nameF);
        container.add(DOBF);
        container.add(IDF);
        container.add(addressF);
        container.add(show);
        container.add(addButton);
        container.add(cancelButton);
        container.add(info);
	}
	
	private void addActionEvent() {
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);
        show.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) 
        {
            boolean isEmptyFields = false;
            
            //If any field is empty, set isEmptyFields flag to true
            if (userF.getText().equals("") || passF.getText().equals("") || nameF.getText().equals("") || DOBF.getText().equals("") || IDF.getText().equals("") || addressF.getText().equals("") )
            {
            	// Display error message if there are empty fields
            	isEmptyFields = true;
            	info.setText("Please fill all fields");
            }

            // If all fields are filled, try to add 
            if(!isEmptyFields) {
            	try 
            	{
    		        String userText;
    		        String pwdText;
    		        userText = userF.getText();
    		        pwdText = passF.getText();
    		        String nameText = nameF.getText();
    		        test.WriteToPatient(nameText, nameText);
    		        int DOBText = Integer.parseInt(DOBF.getText());
    		        int IDText = Integer.parseInt(IDF.getText());
    		        test.WriteToDoctors(nameText, DOBText, IDText);
    		        String addressText = addressF.getText();
    	            JOptionPane.showMessageDialog(this, "Patient Added to Database");
    	            super.setVisible(false);
            	} //end of try
    	        catch (NumberFormatException E) 
            	{
    	
    	        	info.setText("Please enter integer values for Date of Birth and ID.");
    	        } 
    	        catch (Exception E) 
            	{
    	            // Catches generic exception and displays message
    	        	info.setText("Patient was not added - Patient already exists. ");
    	        }
            }

        }
		
        if (e.getSource() == cancelButton) {
            JOptionPane.showMessageDialog(this, "Canceled Adding Patient to Database");
            super.setVisible(false);
        }
        
        if (e.getSource() == show) {
            if (show.isSelected()) {
                passF.setEchoChar((char) 0);
            } else {
                passF.setEchoChar('*');
            }
        }
	}
}
