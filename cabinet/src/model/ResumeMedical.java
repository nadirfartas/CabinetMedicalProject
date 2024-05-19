package model;

import java.time.LocalDateTime;

public class ResumeMedical {
    /* will need a service and private int id; and its getter and setter */
    private static int nextId = 0;  // Static variable to track the next ID 
    private int id;
    private Medcin medcin;
    private Patient patient;
    private LocalDateTime dateR;
    private String observations;

    public ResumeMedical (LocalDateTime dateR, Medcin medcin, Patient patient, String observations) {
      this.id = nextId++;
      this.medcin = medcin;
      this.patient = patient;
      this.dateR = dateR;
      this.observations = observations;
    }
    
    // setters and getters
    public int getId() {
      return id;
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

    public LocalDateTime getDateR() {
      return dateR;
    }
    public void setDateR(LocalDateTime dateR) {
      this.dateR = dateR;
    }
    
    public String getObservations() {
      return observations;
    }
    public void setObservations(String observations) {
      this.observations = observations;
    }

    
}
