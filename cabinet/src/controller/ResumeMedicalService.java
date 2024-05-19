package controller;
import java.util.List;
import java.util.ArrayList;
import model.ResumeMedical;

public class ResumeMedicalService {
    private static List<ResumeMedical> resumeMedicals = new ArrayList<>();


    public static void ajouterResume(ResumeMedical resumeMedical) {
        resumeMedicals.add(resumeMedical);
    }

  
    public static ResumeMedical obtenirResumeParId(int id) {
        return resumeMedicals.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    
    public static void displayAllResumes() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", "ID", "Date", "Nom et Prenom Patient", "Nom Medcin", "Observations medicaux");
        for (ResumeMedical resumeMedical : resumeMedicals) {
            System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s%n",
                    resumeMedical.getId(),
                    resumeMedical.getDateR().toString(),
                    resumeMedical.getPatient().getNom() + resumeMedical.getPatient().getPrenom(),
                    resumeMedical.getMedcin().getUsername(),
                    resumeMedical.getObservations()
            );
        }
    }

    public static void mettreAJourResume(ResumeMedical resumeMedical) {
        for (int i = 0; i < resumeMedicals.size(); i++) {
            if (resumeMedicals.get(i).getId() == resumeMedical.getId()) {
                resumeMedicals.set(i, resumeMedical);
                return;
            }
        }
    }

    public static boolean supprimerResume (int id) {
        return resumeMedicals.removeIf(u -> u.getId() == id);
    }
}
