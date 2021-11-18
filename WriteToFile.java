package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintWriter;
import java.util.Scanner;
public class WriteToFile {
	public void WriteToDoctors(String name, int DOB, int ID) throws IOException
	{
		File write = new File("Patient.txt");
		if(write.exists() == false)
		{
			write.createNewFile();
		}
		PrintWriter patient = new PrintWriter(new FileWriter(write, true));
		patient.write(name + "\n");
		patient.write(DOB + "\n");
		patient.write(ID + "\n");	
		patient.close();
	} 
	public void WriteToPatient(String name, String fileName, int DOB, int ID, int height, int weight, String BP, int Cholesterol, String Vaccinations, String Conditions, String Active) throws IOException
	{
		File write = new File(ID +".txt");
		PrintWriter myWriter = new PrintWriter(new FileWriter(write, true));
		myWriter.write(name + "\n");
		myWriter.write(DOB + "\n");
		myWriter.write(ID + "\n");
		myWriter.write(height + "\n");
		myWriter.write(weight + "\n");
		myWriter.write(BP + "\n");
		myWriter.write(Cholesterol + "\n");
		myWriter.write(Vaccinations + "\n");
		myWriter.write(Conditions + "\n");
		myWriter.write(Active + "\n");
		
		
		myWriter.close();
	}
	public void DeletePatient(int ID) throws IOException
	{
		File file = new File(ID + ".txt");
		file.delete();
	}
	public void WriteToLogin(String name) throws IOException
	{
		  File file = new File("PatientLogin.txt");
	      FileWriter fr = new FileWriter(file, true);
	      BufferedWriter br = new BufferedWriter(fr);
	      br.write(name + "\n");
	      br.close();
	      fr.close();
	}
	public void DeleteLogin(String name) throws IOException
	{
		File Delete = new File("PatientLogin.txt");
		File temp = new File("Temp.txt");
		Scanner Read = new Scanner(Delete);
		PrintWriter patient = new PrintWriter(new FileWriter(temp, true));
		while(Read.hasNextLine())
		{
			String write = Read.nextLine();
			if(write.compareTo(name) != 0)
			{
				patient.write(write + "\n");
			}
		}
		Read.close();
		patient.close();
		Read = new Scanner(temp);
		PrintWriter pw = new PrintWriter(new FileWriter(Delete, false));
		pw.print("");
		while(Read.hasNextLine() == true)
		{
			String grab = Read.nextLine();
			pw.write(grab + "\n");
		}
		pw.close();
		Read.close();
		temp.delete();
		
		
	}
	public void DeleteFromPatientFile(String fileName, int ID) throws IOException
	{
		File Delete = new File("Patient.txt");
		File temp = new File("Temp.txt");
		Scanner Read = new Scanner(Delete);
		PrintWriter patient = new PrintWriter(new FileWriter(temp, true));
		while(Read.hasNextLine() == true)
		{
			String name = Read.nextLine();
			String DOB = Read.nextLine();
			String Identification = Read.nextLine();
			int Num = Integer.parseInt(Identification);
			if(Num != ID)
			{
				patient.write(name + "\n");
				patient.write(DOB + "\n");
				patient.write(Identification + "\n");
			}
		}
		Read.close();
		patient.close();
		Read = new Scanner(temp);
		PrintWriter pw = new PrintWriter(new FileWriter(Delete, false));
		pw.print("");
		pw = new PrintWriter(new FileWriter(Delete, true));
		while(Read.hasNextLine() == true)
		{
			String name = Read.nextLine();
			String DOB = Read.nextLine();
			String Identify = Read.nextLine();
			pw.write(name + "\n");
			pw.write(DOB + "\n");
			pw.write(Identify + "\n");
		}
		pw.close();
		Read.close();
		temp.delete();
	}
}
