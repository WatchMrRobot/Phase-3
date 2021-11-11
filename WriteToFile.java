package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
public class WriteToFile {
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

