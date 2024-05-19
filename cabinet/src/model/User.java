package model;

public class User {
  private static int nextId = 0;  // Static variable to track the next ID 

  private int id;
  private String username;
  private String password;
  private Role role;

  public User(String username, String password, Role role) {
    this.id = nextId++;  // Assign current ID and increment for the next user
    this.username = username;
    this.password = password;
    this.role = role;
  }

  // Getters and Setters
  public int getId() {
    return id;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}

