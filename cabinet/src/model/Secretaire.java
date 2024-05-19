package model;

public class Secretaire extends User {
  public Secretaire(String username, String password) {
    super(username, password, Role.SECRETAIRE);
  }
}

