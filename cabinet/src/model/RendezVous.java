package model;

import java.time.LocalDateTime;

public class RendezVous {
    private static int nextId = 0;  // Static variable to track the next ID 

    private int id;
    private LocalDateTime dateRV;
    private Patient patient;
    private Medcin medcin;

    public RendezVous(LocalDateTime dateRV, Patient patient, Medcin medcin) {
        this.id = nextId++;
        this.dateRV = dateRV;
        this.patient = patient;
        this.medcin = medcin;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public LocalDateTime getDateRV() {
        return dateRV;
    }

    public void setDateRV(LocalDateTime dateRV) {
        this.dateRV = dateRV;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medcin getMedcin() {
        return medcin;
    }

    public void setMedcin(Medcin medcin) {
        this.medcin = medcin;
    }

    @Override
    public String toString() {
        return "RendezVous{id=" + id + ", dateRV=" + dateRV + ", patient=" + patient.getNom() + ", medcin=" + medcin.getUsername() + "}";
    }
}

