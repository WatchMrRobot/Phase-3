package application;

public class pastAppointment
{
	 String patientName;
	 String appointmentDate;
	 String startTime;
	 String endTime;
	 String doctorName;
	 
	 public pastAppointment(String patientName, String appointmentDate, String startTime, String endTime, String doctorName) 
	 {
		 this.patientName = patientName;
		 this.appointmentDate = appointmentDate;
		 this.startTime = startTime;
		 this.endTime = endTime;
		 this.doctorName = doctorName;
	 }
	 
	 public String toString()
	 {
		 return patientName + "  " + appointmentDate + "  " + startTime + "  " + endTime + "  " + doctorName;
	 }
	 
}
	 
