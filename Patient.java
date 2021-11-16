package application;

import java.util.Date;

public class Patient
{
     private String name;
     private int DOB;
     private int ID;
     private String username;
     private String password;
     
     private String address;
     private int height;
     private int weight;
     private int bloodPressure;
     private int cholesterol;
     private String vaccinations;
     private String conditions;
     
     public static int counter;
     
     public Patient()
     {
           name = "?";
           DOB = 0;
           ID = 0;
           address = "?";
           username = "?";
           password = "?";
           height = 0;
           weight = 0;
           bloodPressure = 0;
           cholesterol = 0;
           vaccinations = "none";
           conditions = "none";
           counter++;
     }
     
     public Patient(String name, int DOB, int ID, String addy)
     {
         this.name = name;
         this.DOB = 0;
         this.ID = 0;
         this.address = addy;
         username = "?";
         password = "?";
         counter++;
     }
     
     public Patient(String name, int DOB, int ID, String addy, int h, int w, int BP, int chol, String vacc, String conds)
     {
         this.name = name;
         this.DOB = DOB;
         this.ID = ID;
         this.address = addy;
         username = "?";
         password = "?";
         this.height = h;
         this.weight = w;
         this.bloodPressure = BP;
         this.cholesterol = chol;
         this.vaccinations = vacc;
         this.conditions = conds;
         counter++;
     }
     
     public String getName()
     {
           return name;
     }
     public int getDOB()
     {
           return DOB;
     }
     public int getID()
     {
           return ID;
     }
     public String getAddress()
     {
    	 return address;
     }
     public int getHeight()
     {
           return height;
     }
     public int getWeight()
     {
           return weight;
     }
     public int getBloodPressure()
     {
           return bloodPressure;
     }
     public int getCholesterol()
     {
           return cholesterol;
     }
     public String getVaccinations()
     {
           return vaccinations;
     }
     public String getConditions()
     {
           return conditions;
     }
     public void setName(String name)
     {
           this.name = name;
     }
     public void setDOB(int DOB)
     {
           this.DOB = DOB;
     }
     public void setID(int ID)
     {
           this.ID = ID;
     }
     public void setAddress(String addy)
     {
    	 this.address = addy;
     }
     public void setUsername(String user)
     {
           this.username = user;
     }
     public void setPassword(String pass)
     {
           this.password = pass;
     }
     public void setHeight(int h)
     {
    	 this.height = h;
     }
     public void setWeight(int w)
     {
    	 this.weight = w;
     }
     public void setBloodPressure(int BP)
     {
    	 this.bloodPressure = BP;
     }
     public void setCholesterol(int chol)
     {
    	 this.cholesterol = chol;
     }
     public void setVaccinations(String vacc)
     {
    	 this.vaccinations = vacc;
     }
     public void setConditions(String conds)
     {
    	 this.conditions = conds;
     }
     public String toString()
     {
           return "Name: " + name + "     DOB: " + DOB + "     ID: " + ID; 
     }
}

