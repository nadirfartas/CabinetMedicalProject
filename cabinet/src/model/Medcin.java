package model;

import java.util.ArrayList;
import java.util.List;

public class Medcin extends User { 
  private String specialite;
  private List<RendezVous> rendezVousList = new ArrayList<>();

  public Medcin(String username, String password, String specialite) {
    super(username, password, Role.MEDCIN);
    this.specialite = specialite;
  }

  public String getSpecialite() {
    return specialite;
  }

  public void setSpecialite(String specialite) {
    this.specialite = specialite;
  }

  public List<RendezVous> getRendezVousList() {
    return rendezVousList;
  }

  public void setRendezVousList(List<RendezVous> rendezVousList) {
    this.rendezVousList = rendezVousList;
  }
}
