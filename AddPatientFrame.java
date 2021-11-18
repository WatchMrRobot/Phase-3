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
    JLabel HeightL = new JLabel("Height(in)");
    JLabel WeightL = new JLabel("Weight(lb)");
    JLabel BloodPressureL = new JLabel("BP");
    JLabel CholesterolL = new JLabel("Cholesterol");
    JLabel VaccinationsL = new JLabel("Vaccinations");
    JLabel ConditionsL = new JLabel("Conditions");
    JLabel ActiveIllnessesL = new JLabel("Active Illnesses");
    
    JTextField userF = new JTextField("Defaults as first name");
    JPasswordField passF = new JPasswordField("Defaults as last name");
    JTextField nameF = new JTextField("");
    JTextField DOBF = new JTextField("");
    JTextField IDF = new JTextField("");
    JTextField addressF = new JTextField("ADDRESS");
    JTextField HeightF = new JTextField("");
    JTextField WeightF = new JTextField("");
    JTextField BloodPressureF = new JTextField("x/y");
    JTextField CholesterolF = new JTextField("");
    JTextField VaccinationsF = new JTextField("");
    JTextField ConditionsF = new JTextField("");
    JTextField ActiveIllnessesF = new JTextField("");
    
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
        userL.setBounds(150, 40, 100, 35);
        passL.setBounds(150, 80, 100, 35);
        nameL.setBounds(150, 120, 100, 35);
        DOBL.setBounds(150, 160, 100, 35);
        IDL.setBounds(150, 200, 100, 35);
        addressL.setBounds(150, 240, 100, 35);
        HeightL.setBounds(150, 280, 100, 35);
        WeightL.setBounds(150, 320, 100, 35);
        BloodPressureL.setBounds(150, 360, 100, 35);
        CholesterolL.setBounds(150, 400, 100, 35);
        VaccinationsL.setBounds(150, 440, 100, 35);
        ConditionsL.setBounds(150, 480, 100, 35);
        ActiveIllnessesL.setBounds(150, 520, 100, 35);
        
        
        
        userF.setBounds(250, 40, 175, 35);
        passF.setBounds(250, 80, 175, 35);
        nameF.setBounds(250, 120, 175, 35);
        DOBF.setBounds(250, 160, 175, 35);
        IDF.setBounds(250, 200, 175, 35);
        addressF.setBounds(250, 240, 175, 35);
        HeightF.setBounds(250, 280, 175, 35);
        WeightF.setBounds(250, 320, 175, 35);
        BloodPressureF.setBounds(250, 360, 175, 35);
        CholesterolF.setBounds(250, 400, 175, 35);
        VaccinationsF.setBounds(250, 440, 175, 35);
        ConditionsF.setBounds(250, 480, 175, 35);
        ActiveIllnessesF.setBounds(250, 520, 175, 35);
        
        
        show.setBounds(150, 630, 150, 30);
        addButton.setBounds(150, 570, 125, 50);
        cancelButton.setBounds(300, 570, 125, 50);
    	info.setBounds(150, 500, 450, 35);
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
        container.add(HeightL);
        container.add(WeightL);
        container.add(BloodPressureL);
        container.add(CholesterolL);
        container.add(VaccinationsL);
        container.add(ConditionsL);
        container.add(ActiveIllnessesL);
        
      
       
        container.add(userF);
        container.add(passF);
        container.add(nameF);
        container.add(DOBF);
        container.add(IDF);
        container.add(addressF);
        container.add(HeightF);
        container.add(WeightF);
        container.add(BloodPressureF);
        container.add(CholesterolF);
        container.add(VaccinationsF);
        container.add(ConditionsF);
        container.add(ActiveIllnessesF); 
        container.add(show);
        container.add(addButton);
        container.add(cancelButton);
    //    container.add(info);
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
    		        String Vaccinations;
    		        String Conditions;
    		        String Active;
    		        userText = userF.getText();
    		        pwdText = passF.getText();
    		        Vaccinations = VaccinationsF.getText();
    		        Conditions = ConditionsF.getText();
    		        Active = ActiveIllnessesF.getText();
    		        
    		        String nameText = nameF.getText();
    		        int DOBText = Integer.parseInt(DOBF.getText());
    		        int IDText = Integer.parseInt(IDF.getText());
    		        int Weight = Integer.parseInt(WeightF.getText());
    		        int Height = Integer.parseInt(HeightF.getText());
    		        String BP = BloodPressureF.getText();
    		        int Cholesterol = Integer.parseInt(CholesterolF.getText());
  
    		        test.WriteToPatient(nameText, nameText ,DOBText,IDText, Height, Weight, BP, Cholesterol, Vaccinations, Conditions, Active);
    		        test.WriteToDoctors(nameText, DOBText, IDText);
    		        test.WriteToLogin(nameText);
    		        String addressText = addressF.getText();
    	            JOptionPane.showMessageDialog(this, "Patient Added to Database");
    	            super.setVisible(false);
            	} //end of try
    	        catch (NumberFormatException E) 
            	{
    	
    	        	info.setText("Please enter  values for Date of Birth and ID.");
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