package controller;



import model.Medcin;
import model.RendezVous;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RendezVousController {
    private List<RendezVous> rendezVousList = new ArrayList<>();

    public void ajouter(RendezVous rendezVous) {
        rendezVousList.add(rendezVous);
    }

    public List<RendezVous> obtenirTous() {
        return rendezVousList;
    }

    public boolean isMedcinAvailable(Medcin medcin, LocalDateTime dateTime) {
        for (RendezVous rendezVous : rendezVousList) {
            if (rendezVous.getMedcin().equals(medcin) && rendezVous.getDateRV().equals(dateTime)) {
                return false;
            }
        }
        return true;
    }

    public void supprimer(int id) {
        rendezVousList.removeIf(rendezVous -> rendezVous.getId() == id);
    }
}

