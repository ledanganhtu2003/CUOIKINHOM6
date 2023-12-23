package model;

public class Users{
private int UserID;
private String username;
private String password;
public Users() {
	super();
}
public int getUserID() {
	return UserID;
}
public void setUserID(int userID) {
	UserID = userID;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Users(int userID, String username, String password) {
	super();
	UserID = userID;
	this.username = username;
	this.password = password;
}




}
