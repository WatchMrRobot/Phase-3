package application;

import java.util.Date;

public class Admin
{
     private String name;
     private int ID;
     private String username;
     private String password;
     private String specialty;
     public static int counter;
     
     public Admin()
     {
           name = "?";
           ID = 0;
           username = "?";
           password = "?";
           specialty = "?";
           counter++;
     }
     
     public Admin(String name, String specialty, int ID)
     {
         this.name = name;
         this.ID = ID;
         this.specialty = specialty;
         username = "?";
         password = "?";
         counter++;
     }
     public String getName()
     {
           return name;
     }
     public int getID()
     {
           return ID;
     }
     public String getSpecialty() {
    	 return specialty;
     }
     public void setName(String name)
     {
           this.name = name;
     }
     public void setID(int ID)
     {
           this.ID = ID;
     }
     public void setUsername(String user)
     {
           this.username = user;
     }
     public void setPassword(String pass)
     {
           this.password = pass;
     }
     public void getSpecialty(String Specialty) {
    	 this.specialty = Specialty;
     }
     public String toString()
     {
           return "Name: " + name + "     Specialty: " + specialty + "     ID: " + ID; 
     }
}