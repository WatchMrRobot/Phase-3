package application;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class EditPatientFrame extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel nameL = new JLabel("Name");
    JLabel addressL = new JLabel("ADDRESS");
    JLabel IdentificationL = new JLabel("Confirm ID");
    JLabel heightL = new JLabel("HEIGHT(inches)");
    JLabel weightL = new JLabel("WEIGHT(lbs)");
    JLabel bloodPressureL = new JLabel("BLOOD PRESSURE");
    JLabel cholesterolL = new JLabel("CHOLESTEROL");
    JLabel vaccinationsL = new JLabel("VACCINATIONS");
    JLabel conditionsL = new JLabel("CONDITIONS");

    JLabel ActiveIllnessesL = new JLabel("Active Illnesses");
    
    
    JTextField nameF = new JTextField("");

    JTextField addressF = new JTextField("");
    
    JTextField heightF = new JTextField("HEIGHT");
    JTextField weightF = new JTextField("WEIGHT");
    JTextField IdentificationF = new JTextField();
    JTextField bloodPressureF = new JTextField("BLOOD PRESSURE");
    JTextField cholesterolF = new JTextField("CHOLESTEROL");
    JTextField vaccinationsF = new JTextField("VACCINATIONS");
    JTextField conditionsF = new JTextField("CONDITIONS");
    JTextField ActiveIllnessesF = new JTextField("Active Illnesses");
    
    
    JButton editButton = new JButton("Edit Patient");
    JButton cancelButton = new JButton("Cancel");

    JCheckBox show = new JCheckBox("Show Password");
  	JLabel info = new JLabel("Please enter patient details");
  	
    EditPatientFrame(Patient patient)
	{
        String name = patient.getName();
        int height = patient.getHeight();
        int weight = patient.getWeight();
        int bloodPressure = patient.getBloodPressure();
        int cholesterol = patient.getCholesterol();
        String vaccinations = patient.getVaccinations();
        String conditions = patient.getConditions();

        String ActiveIllnesses = patient.getActiveIllnesses();

    	setLayoutManager();
        setPos();
        addComponentsToContainer();
        addActionEvent();
        nameF.setText(name);
        heightF.setText(Integer.toString(height));
        weightF.setText(Integer.toString(weight));
        bloodPressureF.setText(Integer.toString(bloodPressure));
        cholesterolF.setText(Integer.toString(cholesterol));
        vaccinationsF.setText(vaccinations);
        conditionsF.setText(conditions);

        ActiveIllnessesF.setText(ActiveIllnesses);
       

	}
	
	private void setLayoutManager() {
        container.setLayout(null);
	}

	private void setPos() {

        nameL.setBounds(150, 100, 100, 35);
        addressL.setBounds(150, 140, 100, 35);        
        heightL.setBounds(150, 180, 100, 35);
        weightL.setBounds(150, 220, 100, 35);
        bloodPressureL.setBounds(150, 260, 100, 35);
        cholesterolL.setBounds(150, 300, 100, 35);
        vaccinationsL.setBounds(150, 340, 100, 35);
        conditionsL.setBounds(150, 380, 100, 35);
        ActiveIllnessesL.setBounds(150, 420, 100, 35);
        IdentificationL.setBounds(150, 60, 100, 35);
        
        
        nameF.setBounds(250, 100, 175, 35);
        addressF.setBounds(250, 140, 175, 35);     
        heightF.setBounds(250, 180, 175, 35);
        weightF.setBounds(250, 220, 175, 35);
        bloodPressureF.setBounds(250, 260, 175, 35);
        cholesterolF.setBounds(250, 300, 175, 35);
        vaccinationsF.setBounds(250, 340, 175, 35);
        conditionsF.setBounds(250, 380, 175, 35);
        ActiveIllnessesF.setBounds(250, 420, 175, 35);
        IdentificationF.setBounds(250, 60, 175, 35);


        
        
        show.setBounds(150, 640, 150, 30);
        editButton.setBounds(150, 580, 125, 50);

        cancelButton.setBounds(300, 580, 125, 50);
    	info.setBounds(150, 20, 450, 35);
    	Font font = new Font("Verdana", Font.BOLD, 14);
    	info.setFont(font);
    	info.setForeground(Color.RED);
	}
	
	private void addComponentsToContainer() {
        container.add(nameL);
        container.add(addressL);
        
        container.add(heightL);
        container.add(weightL);
        container.add(bloodPressureL);
        container.add(cholesterolL);
        container.add(vaccinationsL);
        container.add(conditionsL);
        container.add(ActiveIllnessesL);
        container.add(IdentificationL);
        
        
        
        container.add(nameF);

        container.add(addressF);
        
        container.add(heightF);
        container.add(weightF);
        container.add(bloodPressureF);
        container.add(cholesterolF);
        container.add(vaccinationsF);
        container.add(conditionsF);
        container.add(ActiveIllnessesF);
        container.add(IdentificationF);
        container.add(editButton);
        container.add(cancelButton);
	}
	
	private void addActionEvent() {
        editButton.addActionListener(this);
        cancelButton.addActionListener(this);
       // show.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

        if (e.getSource() == editButton) 
        {
            boolean isEmptyFields = false;
            
            //If any field is empty, set isEmptyFields flag to true
        

            // If all fields are filled, try to add 
            if(!isEmptyFields) {
            	try 
            	{
            		
    		        String nameText = nameF.getText();
    		        String addressText = addressF.getText();
    		        int heightText = Integer.parseInt(heightF.getText());
    		        int weightText = Integer.parseInt(weightF.getText());
    		        String bloodPressureText = bloodPressureF.getText();
    		        String cholesterolText = cholesterolF.getText();
    		        String vaccinationsText = vaccinationsF.getText();
    		        String conditionsText = conditionsF.getText();
    		        String Active = ActiveIllnessesF.getText();
    		        String num = IdentificationF.getText();
    		        File patient = new File(num + ".txt");
    		        File temp = new File("temporary.txt");
    		        Scanner reader = new Scanner(patient);
		    		PrintWriter write = new PrintWriter(new FileWriter(temp, false));

    		        if(patient.exists() == true)
    		        {
    		        	write.write(nameText + "\n");
    		        	String a = reader.nextLine();
    		        	String b = reader.nextLine();
    		        	String c = reader.nextLine();
    		        	write.write(b + "\n");
    		        	write.write(c + "\n");
    		        	write.write(heightText + "\n");
    		        	write.write(weightText + "\n");
    		        	write.write(bloodPressureText + "\n");
    		        	write.write(cholesterolText + "\n");
    		        	write.write(vaccinationsText + "\n");
    		        	write.write(conditionsText + "\n"); 
    		        	write.write(Active + "\n");
    		        	reader.close();
    		        	write.close();
    		        	PrintWriter pw = new PrintWriter(new FileWriter(patient, false));
    		        	pw.print("");
    		        	reader = new Scanner(temp);
    		        	while(reader.hasNextLine() == true)
    		        	{
    		        		pw.write(reader.nextLine() + "\n");
    		        	}
    		        	pw.close();
    		        	reader.close();
    		      //  	temp.delete();
    		        }
    		        
    	            JOptionPane.showMessageDialog(this, "Patient Edited in Database");

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
	       
	        String nameText = nameF.getText();
	        String addressText = addressF.getText();
	        int heightText = Integer.parseInt(heightF.getText());
	        int weightText = Integer.parseInt(weightF.getText());
	        int bloodPressureText = Integer.parseInt(bloodPressureF.getText());
	        int cholesterolText = Integer.parseInt(cholesterolF.getText());
	        String vaccinationsText = vaccinationsF.getText();
	        String conditionsText = conditionsF.getText();
	        
            super.setVisible(false);
        }
		
        if (e.getSource() == cancelButton) {
            JOptionPane.showMessageDialog(this, "Canceled Adding Patient to Database");
            super.setVisible(false);
        }

	}
}