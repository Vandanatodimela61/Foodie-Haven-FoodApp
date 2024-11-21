package com.tap.model;

public class User {
    private int user_id; // Optional: You can keep this if you're using auto-increment for user_id
    private String username;
    private String password;
    private String email;
    private String address;
    private String role;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Constructors
    public User(int user_id, String username, String password, String email, String address, String role) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public User(String username, String password, String email, String address, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    

	@Override
    public String toString() {
        return user_id + " " + username + " " + password + " " + email + " " + address + " " + role;
    }

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
