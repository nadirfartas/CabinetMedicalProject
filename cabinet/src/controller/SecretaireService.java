package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Patient;
import model.RendezVous;
import model.Secretaire;

public class SecretaireService {

    private Secretaire secretaire;
    private List<RendezVous> rendezVousList;
    private static List<Patient> patientList;
    private PatientController patientController = new PatientController();
    private RendezVousController rendezVousController = new RendezVousController();
    private List<Secretaire> secretaires;

  
    public SecretaireService() {
      this.secretaires = AdminService.getAllSecretaires();
      this.rendezVousList = new ArrayList<>();
      this.patientList = new ArrayList<>();
  }

  public boolean login(String username, String password) {
      for (Secretaire secretaire : secretaires) {
          if (secretaire.getUsername().equals(username) && secretaire.getPassword().equals(password)) {
              return true;
          }
      }
      return false;
  }


  public boolean deleteRendezVous(int id) {
    return rendezVousList.removeIf(rendezVous -> rendezVous.getId() == id);
}


  
  public boolean createRendezVous(RendezVous rendezVous) {
    return rendezVousList.add(rendezVous);
}


  public void displayAllRendezVous() {
    System.out.printf("%-10s %-20s %-20s %-20s%n", "ID", "Date et Heure", "Patient", "Médecin");
    for (RendezVous rendezVous : rendezVousList) {
        System.out.printf("%-10d %-20s %-20s %-20s%n",
                rendezVous.getId(),
                rendezVous.getDateRV().toString(),
                rendezVous.getPatient().getNom() + rendezVous.getPatient().getPrenom(),
                rendezVous.getMedcin().getUsername());
    }
}

  public boolean isMedcinAvailable(int medcinId, LocalDateTime dateTime) {
        for (RendezVous rendezVous : rendezVousList) {
            if (rendezVous.getMedcin().getId() == medcinId && rendezVous.getDateRV().equals(dateTime)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean deletePatient(int id) {
        return patientList.removeIf(patient -> patient.getId() == id);
    }
    
    
    public boolean createPatient(Patient patient) {
      return patientList.add(patient);
  }

  public Patient obtenirPatientParId(int id) {
      for (Patient patient : patientList) {
          if (patient.getId() == id) {
              return patient;
          }
      }
      return null;
  }

  public static void displayAllpatients() {
    System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Nom", "Prenom", "age", "Telephone", "gender");
    for (Patient patient : patientList) {
        System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s%n",
                patient.getId(),
                patient.getNom(),
                patient.getPrenom(),
                patient.getAge(),
                patient.getTelephone(),
                patient.getGender());
    }
}
}
