package controller;

import model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientController {

    private static List<Patient> patients = new ArrayList<>();

    public PatientController() {
        this.patients = new ArrayList<>();

    }
     // setter and getter 
    public void setAllPatiens(List<Patient> patients){
        this.patients = patients;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }
    


    public static void ajouterPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
            System.out.println("Patient ajouté avec succès : " + patient.getNom() + " " + patient.getPrenom());
        } else {
            System.out.println("Erreur : le patient ne peut pas être nul.");
        }
    }

    public List<Patient> obtenirTousLesPatients() {
        return patients;
    }

    public static Patient obtenirPatientParId(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }


    public boolean mettreAJourPatient(int id, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.set(i, updatedPatient);
                return true;
            }
        }
        return false;
    }

    public boolean supprimerPatient(int id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                patients.remove(i);
                return true;
            }
        }
        return false;
    }

    public void afficherTousLesPatients() {
        if (patients.isEmpty()) {
            System.out.println("Aucun patient trouvé.");
        } else {
            System.out.println("Liste des patients :");
            for (Patient patient : patients) {
                System.out.println("ID: " + patient.getId() + ", Nom: " + patient.getNom() + ", Prénom: " + patient.getPrenom() + ", Age: " + patient.getAge() + ", Téléphone: " + patient.getTelephone() + ", Genre: " + patient.getGender());
            }
        }
    }

    
    
}

