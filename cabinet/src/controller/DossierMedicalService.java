package controller;

import java.util.ArrayList;
import java.util.List;

import model.CertificatMedicale;
import model.DossierMedicale;
import model.FichePatient;
import model.Ordonnance;

public class DossierMedicalService {
    private static List<DossierMedicale> dossiers = new ArrayList<>();

   
    public static void ajouterdossier(DossierMedicale dossier) {
        dossiers.add(dossier);
    }

    
    public static DossierMedicale obtenirdossierParId(int id) {
      //methode pour obtenir un dossier medicale par id 
      return dossiers.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

     public static void displayAllDossiers() {
        System.out.printf("%-10s %-20s %-20s%n", "ID", "Nom et Prenom Patient", " Autres informations");
        for (DossierMedicale dossierMedicale : dossiers) {
                System.out.printf("%-10d %-20s %-20s%n",
                dossierMedicale.getId(),
                dossierMedicale.getPatient().getNom() + dossierMedicale.getPatient().getPrenom(),
                "Autres details(Afficher le dossier seul pour voir autres details)"
            );
        }
    }

    
    public void mettreAJourDos(DossierMedicale dossier) {
        // Implémentation de mise à jour
        for (int i = 0; i < dossiers.size(); i++) {
            if (dossiers.get(i).getId() == dossier.getId()) {
                dossiers.set(i, dossier);
                return;
            }
        }
    }
    
    
    
    public static void supprimerDos(int id) {
        //methode pour supprimer un dossier medicale
        dossiers.removeIf(u -> u.getId() == id);
    }
}

