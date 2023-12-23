package model;

public class Result {
	 private int ResultID;
	 private int SID;
	 private int CourseID;
	 private int Grade;
	public Result() {
		super();
	}

    public Result(int resultID, int sID, int courseID, int grade) {
        this.ResultID = resultID;
        this.SID = sID;
        this.CourseID = courseID;
        this.Grade = grade;
    }
	public int getResultID() {
		return ResultID;
	}
	public void setResultID(int resultID) {
		ResultID = resultID;
	}
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int getCourseID() {
		return CourseID;
	}
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	
	}