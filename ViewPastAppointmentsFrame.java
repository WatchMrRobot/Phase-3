package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class ViewPastAppointmentsFrame extends JFrame {

	 Container container = getContentPane();
	  	  
	 JFrame f;    
	 ArrayList <pastAppointment> aptList = new ArrayList <pastAppointment>();
	 public ViewPastAppointmentsFrame()
	 {    
		 f=new JFrame();   
		 pastAppointment newApt1 = new pastAppointment("Jarrod Kay","11/15/21","8:00 AM", "9:00 AM", "Monet Estes");
		 aptList.add(newApt1);
		 pastAppointment newApt2 = new pastAppointment("Enrico Murray","11/15/21","9:30 AM", "10:30 AM", "Selin Bonner");
		 aptList.add(newApt2);
		 pastAppointment newApt3 = new pastAppointment("Janelle Greenaway","11/15/21","11:30 AM", "12:30 PM", "Shakir Ridley");
		 aptList.add(newApt3);
		 pastAppointment newApt4 = new pastAppointment("Tarik Mcfarlane","11/15/21","1:00 PM", "2:00 PM", "Asiyah Wong");
		 aptList.add(newApt4);
		 pastAppointment newApt5 = new pastAppointment("Danial Lambert","11/15/21","2:30 PM", "3:00 PM", "Camden Walter");
		 aptList.add(newApt5);
		 pastAppointment newApt6 = new pastAppointment("Uma Jaramillo","11/15/21","3:00 PM", "4:00 PM", "Jia Wright");
		 aptList.add(newApt6);
		 pastAppointment newApt7 = new pastAppointment("Sami Higgins","11/15/21","4:30 PM", "5:30 PM", "Selin Bonner");
		 aptList.add(newApt7);
		 pastAppointment newApt8 = new pastAppointment("Lara Sims","11/15/21","6:00 PM", "7:30 PM", "Shakir Ridley");
		 aptList.add(newApt8);
		 pastAppointment newApt9 = new pastAppointment("Dawson Rowe","11/15/21","8:00 PM", "9:00 PM", "Selin Bonner");
		 aptList.add(newApt9);
		 pastAppointment newApt10 = new pastAppointment("Muhamed Naylor","11/16/21","8:00 AM", "9:00 AM", "Asiyah Wong");
		 aptList.add(newApt10);
		 pastAppointment newApt11 = new pastAppointment("Maddie Jenkins","11/16/21","9:30 AM", "10:30 AM", "Shakir Ridley");
		 aptList.add(newApt11);
		 pastAppointment newApt12 = new pastAppointment("Fatima Brewer","11/16/21","11:00 AM", "12:00 PM", "Jia Wright");
		 aptList.add(newApt12);
		 pastAppointment newApt13 = new pastAppointment("Irene Ramsay","11/16/21","1:00 PM", "2:00 PM", "Asiyah Wong");
		 aptList.add(newApt13);
		 pastAppointment newApt14 = new pastAppointment("Gurveer Kennedy","11/16/21","3:00 PM", "4:00 PM", "Selin Bonner");
		 aptList.add(newApt14);
		 pastAppointment newApt15 = new pastAppointment("Malakai Gilmore","11/16/21","6:00 PM", "7:00 PM", "Shakir Ridley");
		 aptList.add(newApt15);
		 pastAppointment newApt16 = new pastAppointment("Vincent Meadows","11/17/21","8:00 AM", "9:00 AM", "Camden Walter");
		 aptList.add(newApt16);
		 pastAppointment newApt17 = new pastAppointment("Aila Humphrey","11/17/21","10:00 AM", "11:00 AM", "Monet Estes");
		 aptList.add(newApt17);
		 pastAppointment newApt18 = new pastAppointment("Aisha Paul","11/17/21","1:00 PM", "2:00 PM", "Selin Bonner");
		 aptList.add(newApt18);
		 pastAppointment newApt19 = new pastAppointment("Christian White","11/17/21","4:00 PM", "5:00 PM", "Monet Estes");
		 aptList.add(newApt19);
		 pastAppointment newApt20 = new pastAppointment("Yasin Orozco","11/17/21","6:00 PM", "7:00 PM", "Selin Bonner");
		 aptList.add(newApt20);
		 pastAppointment newApt21 = new pastAppointment("Nel Cook","11/17/21","7:00 PM", "8:30 PM", "Monet Estes");
		 aptList.add(newApt21);
		 pastAppointment newApt22 = new pastAppointment("Jardel Wilkins","11/18/21","8:00 AM", "9:00 AM", "Monet Estes");
		 aptList.add(newApt22);
		 pastAppointment newApt23 = new pastAppointment("Ian Meyers","11/18/21","10:00 AM", "11:00 AM", "Selin Bonner");
		 aptList.add(newApt23);
		 pastAppointment newApt24 = new pastAppointment("Brenda Vega","11/18/21","1:00 PM", "2:00 PM", "Shakir Ridley");
		 aptList.add(newApt24);
	
		 
	  	 String data[][]={ {"Jarrod Kay","11/15/21","8:00 AM", "9:00 AM", "Monet Estes"}, 
	  			{"Enrico Murray","11/15/21","9:30 AM", "10:30 AM", "Selin Bonner"},
	  	 		{"Janelle Greenaway","11/15/21","11:30 AM", "12:30 PM", "Shakir Ridley"},
	  	 		{"Tarik Mcfarlane","11/15/21","1:00 PM", "2:00 PM", "Asiyah Wong"},
	  	 		{"Danial Lambert","11/15/21","2:30 PM", "3:00 PM", "Camden Walter"},
	  	 		{"Uma Jaramillo","11/15/21","3:00 PM", "4:00 PM", "Jia Wright"},
	  	 		{"Sami Higgins","11/15/21","4:30 PM", "5:30 PM", "Selin Bonner"},
	  	 		{"Lara Sims","11/15/21","6:00 PM", "7:30 PM", "Shakir Ridley"},
	  	 		{"Dawson Rowe","11/15/21","8:00 PM", "9:00 PM", "Selin Bonner"},
	  	 		{"Muhamed Naylor","11/16/21","8:00 AM", "9:00 AM", "Asiyah Wong"},
	  	 		{"Maddie Jenkins","11/16/21","9:30 AM", "10:30 AM", "Shakir Ridley"},
	  	 		{"Fatima Brewer","11/16/21","11:00 AM", "12:00 PM", "Jia Wright"},
	  	 		{"Irene Ramsay","11/16/21","1:00 PM", "2:00 PM", "Asiyah Wong"},
	  	 		{"Gurveer Kennedy","11/16/21","3:00 PM", "4:00 PM", "Selin Bonner"},
	  	 		{"Malakai Gilmore","11/16/21","6:00 PM", "7:00 PM", "Shakir Ridley"},
	  	 		{"Vincent Meadows","11/17/21","8:00 AM", "9:00 AM", "Camden Walter"},
	  	 		{"Aila Humphrey","11/17/21","10:00 AM", "11:00 AM", "Monet Estes"},
	  	 		{"Aisha Paul","11/17/21","1:00 PM", "2:00 PM", "Selin Bonner"},
	  	 		{"Christian White","11/17/21","4:00 PM", "5:00 PM", "Monet Estes"},
	  	 		{"Yasin Orozco","11/17/21","6:00 PM", "7:00 PM", "Selin Bonner"},
	  	 		{"Nel Cook","11/17/21","7:00 PM", "8:30 PM", "Monet Estes"},
	  	 		{"Jardel Wilkins","11/18/21","8:00 AM", "9:00 AM", "Monet Estes"},
	  	 		{"Ian Meyers","11/18/21","10:00 AM", "11:00 AM", "Selin Bonner"},
	  	 		{"Brenda Vega","11/18/21","1:00 PM", "2:00 PM", "Shakir Ridley"}}; 
	  	 
	  	 
	  	                          
	  	 String column[]={"PATIENT", "DATE", "START TIME", "END TIME", "DOCTOR"};         
	  	 JTable jt=new JTable(data,column)
	  	 {
	  	 	public boolean isCellEditable(int data, int columns)
	  		{
	  			return false;
	  		}
	  	 }; 
	  	 
	  	 jt.setBounds(30,40,200,300); 
	  	jt.setPreferredScrollableViewportSize(new Dimension(450, 63));
	  	jt.setFillsViewportHeight(true);
	  	 JScrollPane sp=new JScrollPane(jt);    
	  	 container.add(sp);          
	  	 container.setSize(300,400);    
	  	 container.setVisible(true);  
	 }
	  	
		
		private void setLayoutManager() 
		{
	        container.setLayout(null);
		}
		
		
		
		

}