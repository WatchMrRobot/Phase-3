package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintWriter;
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
	public void WriteToPatient(String name, String fileName) throws IOException
	{
		FileWriter myWriter = new FileWriter(fileName);
		myWriter.write(name);
		myWriter.close();
	}
	public void DeletePatient(String fileName) throws IOException
	{
		File file = new File(fileName);
		file.delete();
	}
}

