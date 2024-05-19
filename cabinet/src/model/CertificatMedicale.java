package model;

import java.time.LocalDateTime;

public class CertificatMedicale {
  //les attributs 
	private static int nextId = 0;  // Static variable to track the next ID 
	private int id;
    private LocalDateTime date;
    private Medcin medcin;
	private Patient patient;
    private String reason;
    
  //Constructeur
    public CertificatMedicale(LocalDateTime date, Medcin medcin, Patient patient, String reason) {
    	this.id = nextId++;
		this.date = date;
    	this.medcin = medcin;
		this.patient = patient;
    	this.reason = reason;
    }
  //setters et getters
	public int getId() {
		return id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	  


}
