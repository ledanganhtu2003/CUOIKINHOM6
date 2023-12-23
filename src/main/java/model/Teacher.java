package model;

import java.sql.Date;

public class Teacher {
	  private int TeacherID;
	    private String FirstName;
	    private String LastName;
	    private Date DOB;
	    private String Email;
		public Teacher() {
			super();
		}
		public Teacher(int teacherID, String firstName, String lastName, Date dOB, String email) {
			super();
			TeacherID = teacherID;
			FirstName = firstName;
			LastName = lastName;
			DOB = dOB;
			Email = email;
		}
		public int getTeacherID() {
			return TeacherID;
		}
		public void setTeacherID(int teacherID) {
			TeacherID = teacherID;
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
		@Override
		public String toString() {
			return "Teacher [TeacherID=" + TeacherID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", DOB="
					+ DOB + ", Email=" + Email + "]";
		}
		
}
