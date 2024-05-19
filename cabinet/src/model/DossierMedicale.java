package model;

import java.util.List;
import java.util.ArrayList;

public class DossierMedicale {

  // les attributs /*needs :  */
  private static int nextId = 0;  // Static variable to track the next ID 
  private int id; 
  private Patient patient;
  private List<ResumeMedical> resumeMedicals;
  private List<Ordonnance> ordonnances;
  private List<CertificatMedicale> certificates;
  private List<FichePatient> fichePatients;

  // Constructeur
    public DossierMedicale(Patient patient) {
    	this.id = nextId++;
      this.patient = patient;
    	this.resumeMedicals = new ArrayList<>();
      this.ordonnances = new ArrayList<>();
      this.certificates = new ArrayList<>();
      this.fichePatients = new ArrayList<>();
    }
    
  //Méthodes pour ajouter une consultation au dossier médical
    public void ajouterResumeMedical(ResumeMedical resumeMedical) {
    	resumeMedicals.add(resumeMedical);
    }

    public void supprimerResume(int id){
      resumeMedicals.removeIf(u -> u.getId() == id);
    }
    
  //Méthodes pour ajouter une ordonnance au dossier médical
    public void ajouterOrdonnance(Ordonnance ordonnance){// Patient patient) {
        ordonnances.add(ordonnance);
    }
    
    public void supprimerOrdonnance(int id){
      ordonnances.removeIf(u -> u.getId() == id);
    }
  //Méthodes pour ajouter un certificat médical au dossier médical
    public void ajouterCertificat(CertificatMedicale certificat) {
        certificates.add(certificat);//
    }

    public void supprimerCertificat(int id){
      certificates.removeIf(u -> u.getId() == id);
    }
    
  //Méthodes pour ajouter un Fiche Patient au dossier médical
  public void ajouterFichePatients(FichePatient fichePatient ) {
    fichePatients.add(fichePatient);
  }  

  public void supprimerFichePatient(int id){
    fichePatients.removeIf(u -> u.getId() == id);
  }
 // Méthodes pour accéder aux informations du dossier médical
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient){
      this.patient = patient;
    }

    //
    public int getId() {
      return id;
    }

    public List<ResumeMedical> getResumeMedicals() {
        return resumeMedicals;
    }

    public List<Ordonnance> getOrdonnances() {
        return ordonnances;
    }

    public List<CertificatMedicale> getCertificat() {
        return certificates;//
    }
    

    public List<FichePatient> getFichePatients() {
        return fichePatients;
    }
}
