package controller;
import model.Ordonnance;
import java.util.ArrayList;
import java.util.List;

import model.CertificatMedicale;

public class OrdonnanceService {
    private static List<Ordonnance> ordonnances = new ArrayList<>() ;


    public static void ajouterOrdonnance(Ordonnance ordonnance) {
        ordonnances.add(ordonnance);
    }

  
    public static Ordonnance obtenirOrdonnanceParId(int id) {
        return ordonnances.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    
    public static void displayAllOrdonnances() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Date", "Nom et Prenom Patient", "Nom Medcin", "Medicaments", "instructions");
        for (Ordonnance ordonnance : ordonnances) {
            System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s%n",
                    ordonnance.getId(),
                    ordonnance.getDateO().toString(),
                    ordonnance.getPatient().getNom() + ordonnance.getPatient().getPrenom(),
                    ordonnance.getMedcin().getUsername(),
                    ordonnance.getMedicaments(),
                    ordonnance.getInstructions()
            );
        }
    }

    public static void mettreAJour(Ordonnance ordonnance) {
        for (int i = 0; i < ordonnances.size(); i++) {
            if (ordonnances.get(i).getId() == ordonnance.getId()) {
                ordonnances.set(i, ordonnance);
                return;
            }
        }
    }

    public static boolean supprimerOrdonnance(int id) {
        return ordonnances.removeIf(u -> u.getId() == id);
    }
    
}
