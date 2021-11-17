package application;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JLabel heightL = new JLabel("HEIGHT(inches)");
    JLabel weightL = new JLabel("WEIGHT(lbs)");
    JLabel bloodPressureL = new JLabel("BLOOD PRESSURE");
    JLabel cholesterolL = new JLabel("CHOLESTEROL");
    JLabel vaccinationsL = new JLabel("VACCINATIONS");
    JLabel conditionsL = new JLabel("CONDITIONS");
    JLabel ActiveIllnessesL = new JLabel("Active Illnesses");
    
    
    JTextField nameF = new JTextField("N");
    JTextField addressF = new JTextField("ADDRESS");
    
    JTextField heightF = new JTextField("HEIGHT");
    JTextField weightF = new JTextField("WEIGHT");
    JTextField bloodPressureF = new JTextField("BLOOD PRESSURE");
    JTextField cholesterolF = new JTextField("CHOLESTEROL");
    JTextField vaccinationsF = new JTextField("VACCINATIONS");
    JTextField conditionsF = new JTextField("CONDITIONS");
    JTextField ActiveIllnessesF = new JTextField("Active Illnesses");
    
    
    JButton addButton = new JButton("Edit Patient");
    JButton cancelButton = new JButton("Cancel");
    JCheckBox show = new JCheckBox("Show Password");
  	JLabel info = new JLabel("Please enter patient details");
  	
    EditPatientFrame(Patient patient)
	{
        String name = patient.getName();
      //  int DOB = patient.getDOB();
        //int ID = patient.getID();
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
        
        
        nameF.setBounds(250, 100, 175, 35);
        addressF.setBounds(250, 140, 175, 35);     
        heightF.setBounds(250, 180, 175, 35);
        weightF.setBounds(250, 220, 175, 35);
        bloodPressureF.setBounds(250, 260, 175, 35);
        cholesterolF.setBounds(250, 300, 175, 35);
        vaccinationsF.setBounds(250, 340, 175, 35);
        conditionsF.setBounds(250, 380, 175, 35);
        ActiveIllnessesF.setBounds(250, 420, 175, 35);

        
        
        show.setBounds(150, 640, 150, 30);
        addButton.setBounds(150, 580, 125, 50);
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
        
        
        container.add(nameF);
        container.add(addressF);
        
        container.add(heightF);
        container.add(weightF);
        container.add(bloodPressureF);
        container.add(cholesterolF);
        container.add(vaccinationsF);
        container.add(conditionsF);
        container.add(ActiveIllnessesF);       
        container.add(addButton);
        container.add(cancelButton);
        container.add(info);
	}
	
	private void addActionEvent() {
        addButton.addActionListener(this);
        cancelButton.addActionListener(this);
       // show.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == cancelButton) {
            JOptionPane.showMessageDialog(this, "Canceled Adding Patient to Database");
            super.setVisible(false);
        }
  
	}
}