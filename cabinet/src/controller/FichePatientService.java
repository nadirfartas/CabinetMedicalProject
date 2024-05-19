package controller;

import java.util.ArrayList;
import java.util.List;

import model.FichePatient;

public class FichePatientService {
    private static List<FichePatient> fichePatients = new ArrayList<>();


    public static void ajouter(FichePatient fichePatient) {
        fichePatients.add(fichePatient);
    }

  
    public static FichePatient obtenirFichierParId(int id) {
        return fichePatients.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public List<FichePatient> obtenirTous() {
        return fichePatients;
    }
    
    public static void displayAllFiches() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", "ID", "Nom", "Prenom", "Date", "informations");
        for (FichePatient fiche : fichePatients) {
            System.out.printf("%-10d %-20s %-20s %-20s %-20s%n",
                    fiche.getId(),
                    fiche.getPatient().getNom(),
                    fiche.getPatient().getPrenom(),
                    fiche.getDateCN().toString(),
                    "Autres details(Afficher la fiche seul pour voir autres details)"
            );
        }
    }
    public void mettreAJour(FichePatient fichePatient) {
        for (int i = 0; i < fichePatients.size(); i++) {
            if (fichePatients.get(i).getId() == fichePatient.getId()) {
                fichePatients.set(i, fichePatient);
                return;
            }
        }
    }

    public static boolean supprimerFiche(int id) {
        return fichePatients.removeIf(u -> u.getId() == id);
    }
}
