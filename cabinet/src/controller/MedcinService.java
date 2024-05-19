package controller;

import java.util.ArrayList;
import java.util.List;

import model.Admin;
import model.Medcin;
import model.RendezVous;

public class MedcinService {
    private List<Medcin> medcins;


  public MedcinService() {
    this.medcins = new ArrayList<>();
}

public boolean login(String username, String password) {
    for (Medcin medcin : medcins) {
        if (medcin.getUsername().equals(username) && medcin.getPassword().equals(password)) {
            return true;
        }
    }
    return false;
}
  

public boolean createMedcin(Medcin medcin) {
    return medcins.add(medcin);
}



    // Method to add a medcin
    public void ajouterMedcin(Medcin medcin) {
        medcins.add(medcin);
    }

    // Method to remove a medcin
    public void supprimerMedcin(int id) {
        medcins.removeIf(m -> m.getId() == id);
    }

    // Method to find a medcin by ID
    public Medcin trouverMedcinParId(int id) {
        for (Medcin medcin : medcins) {
            if (medcin.getId() == id) {
                return medcin;
            }
        }
        return null;
    }

    // Method to find a medcin by username
    public Medcin trouverMedcinParNomUtilisateur(String username) {
        for (Medcin medcin : medcins) {
            if (medcin.getUsername().equals(username)) {
                return medcin;
            }
        }
        return null;
    }

    // Method to add a rendez-vous for a medcin
    public void ajouterRendezVous(Medcin medcin, RendezVous rendezVous) {
        medcin.getRendezVousList().add(rendezVous);
    }

    // Method to remove a rendez-vous for a medcin
    public void supprimerRendezVous(Medcin medcin, RendezVous rendezVous) {
        medcin.getRendezVousList().remove(rendezVous);
    }

    // Method to get all rendez-vous for a medcin
    public List<RendezVous> obtenirTousLesRendezVous(Medcin medcin) {
        return medcin.getRendezVousList();
    }

    public List<Medcin> getAllMedcins() {
        return medcins;
      
    }

    public void setMedcins(List<Medcin> medcins) {
        this.medcins = medcins;
    }
    
}

