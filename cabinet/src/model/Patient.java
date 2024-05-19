package model;

public class Patient {
  private static int nextId = 0;  // Static variable to track the next ID 

  private int id;
  private String nom;
  private String prenom;
  private int age;
  private String Telephone;
  private String gender;

  public Patient(String nom, String prenom,String Telephone, int age ,String gender) {
    this.id = nextId++;  // Assign current ID and increment for the next patient
    this.nom = nom;
    this.prenom = prenom;
    this.age = age;
    this.Telephone = Telephone;
    this.gender = gender;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public static int getNextId() {
    return nextId;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getTelephone() {
    return Telephone;
  }

  public void setTelephone(String telephone) {
    Telephone = telephone;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

}
