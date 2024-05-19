package model;

import java.time.LocalDateTime;


public class Ordonnance {
  //les attributs
	private static int nextId = 0;  // Static variable to track the next ID 
	private int id;
	private LocalDateTime dateO;
	private Medcin medcin;
	private Patient patient;
	private String medicaments;
    private String instructions;
  // Constructeur
    public Ordonnance(LocalDateTime dateO, Medcin medcin, Patient patient, String instructions, String medicaments) {
		this.id = nextId++;
		this.dateO = dateO;
		this.medcin = medcin;
		this.patient = patient;
    	this.medicaments = medicaments;
    	this.instructions = instructions;
}
  // Getters et Setters
	public int getId(){
		return id;
	}
	public LocalDateTime getDateO(){
        return dateO;
    }

	public void setDateO(LocalDateTime dateO){
        this.dateO = dateO;
    }

	public Medcin getMedcin() {
		return medcin;
	}

	public void setMedcin(Medcin medcin) {
		this.medcin = medcin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(String medicaments) {
		this.medicaments = medicaments;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
    
}
