package model;

public class Course {
    private int courseId;
    private String courseName;
    private int teacherId;
    private String time;
    public Course() {
    }
    public Course(int courseId, String courseName, int teacherId, String time) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.time = time;
    }
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
