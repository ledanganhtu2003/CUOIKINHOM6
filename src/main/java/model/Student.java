package model;

import java.sql.Date;

public class Student {
	   private int SID;
	    private String FirstName;
	    private String LastName;
	    private Date DOB;
	    private String Email;
	    private int CourseID;
		public Student() {
			super();
		}
		public Student(int sID, String firstName, String lastName, Date dOB, String email, int CourseID) {
			super();
			SID = sID;
			FirstName = firstName;
			LastName = lastName;
			DOB = dOB;
			Email = email;
			this.CourseID = CourseID;
		}
		public int getSID() {
			return SID;
		}
		public void setSID(int sID) {
			SID = sID;
		}
		public String getFirstName() {
			return FirstName;
		}
		public void setFirstName(String firstName) {
			FirstName = firstName;
		}
		public String getLastName() {
			return LastName;
		}
		public void setLastName(String lastName) {
			LastName = lastName;
		}
		public Date getDOB() {
			return DOB;
		}
		public void setDOB(Date dOB) {
			DOB = dOB;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public int getCourseID() {
			return CourseID;
		}
		public void setCourseID(int courseID) {
			CourseID = courseID;
		}
		@Override
		public String toString() {
			return "Student [SID=" + SID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", DOB=" + DOB
					+ ", Email=" + Email + ", CourseID=" + CourseID + "]";
		}

}
