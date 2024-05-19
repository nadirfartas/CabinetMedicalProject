package controller;

import java.util.ArrayList;
import java.util.List;

import model.CertificatMedicale;

public class CertificatService {
    private static List<CertificatMedicale> certificatMedicales = new ArrayList<>();

    public CertificatService(){
        this.certificatMedicales = new ArrayList<>();
    }

    public static void ajouterCertificat(CertificatMedicale certificatMedicale) {
        certificatMedicales.add(certificatMedicale);
    }

  
    public static CertificatMedicale obtenirCertificatParId(int id) {
        return certificatMedicales.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    
    public static void displayAllCertificatmedicaux() {
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Date", "Nom Patient", "Prenom Patient", "Nom Medcin", "description");
        for (CertificatMedicale certificatMedicale : certificatMedicales) {
            System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s%n",
                    certificatMedicale.getId(),
                    certificatMedicale.getDate().toString(),
                    certificatMedicale.getPatient().getNom(),
                    certificatMedicale.getPatient().getPrenom(),
                    certificatMedicale.getMedcin().getUsername(),
                    certificatMedicale.getReason()
            );
        }
    }

    public static void mettreAJour(CertificatMedicale certificatMedicale) {
        for (int i = 0; i < certificatMedicales.size(); i++) {
            if (certificatMedicales.get(i).getId() == certificatMedicale.getId()) {
                certificatMedicales.set(i, certificatMedicale);
                return;
            }
        }
    }

    public static boolean supprimerCertificat(int id) {
        return certificatMedicales.removeIf(u -> u.getId() == id);
    }
}
