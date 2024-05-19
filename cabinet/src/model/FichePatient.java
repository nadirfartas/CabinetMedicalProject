package model;

import java.time.LocalDateTime;


public class FichePatient {
    private static int nextId = 0;  // Static variable to track the next ID 
    private int id;
    private Patient patient;
    private LocalDateTime dateCN;
    private String antecedentsMedicaux;
    private String Operations;
    private String gynéco_obstétricaux;
    private double poids;
    private double taille;
    private String constantesVitales;
    private String tares;
    

    public FichePatient(Patient patient, LocalDateTime dateCN){
        this.id = nextId++;
        this.patient = patient;
        this.dateCN = dateCN;
        this.antecedentsMedicaux = null;
        this.Operations = null;
        this.gynéco_obstétricaux = null;
        this.poids = 0;
        this.taille = 0;
        this.constantesVitales = null;
        this.tares = null;
    }

    public int getId(){
        return id;
    }

    public Patient getPatient(){
        return patient;
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }
    
    public LocalDateTime getDateCN(){
        return dateCN;
    }

    public void setDateCN(LocalDateTime dateCN){
        this.dateCN = dateCN;
    }

    public String getantecedentsMedicaux(){
        return antecedentsMedicaux;
    }

    public void setantecedentsMedicaux(String antecedentsMedicaux){
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public String getOperations(){
        return Operations;
    }

    public void setOperations(String Operations) {
        this.Operations = Operations;
    }
    public String getGynéco_obstétricaux() {
        return gynéco_obstétricaux;
    }

    public void setGynéco_obstétricaux(String gynéco_obstétricaux) {
        this.gynéco_obstétricaux = gynéco_obstétricaux;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getTaille() {
        return taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public String getConstantesVitales() {
        return constantesVitales;
    }

    public void setConstantesVitales(String constantesVitales) {
        this.constantesVitales = constantesVitales;
    }

    public String getTares(){
        return tares;
    }

    public void setTares(String tares) {
        this.tares = tares;
    }

    

}
