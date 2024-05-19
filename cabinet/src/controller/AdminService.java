package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Admin;
import model.Medcin;
import model.Secretaire;

public class AdminService {
    private static List<Admin> adminDatabase = new ArrayList<>();
    private static List<Medcin> medcinDatabase = new ArrayList<>();
    private static List<Secretaire> secretaireDatabase = new ArrayList<>();

    public boolean createAdmin(Admin admin) {
        for (Admin existingAdmin : adminDatabase) {
            if (existingAdmin.getUsername().equals(admin.getUsername())) {
                return false; // Admin already exists
            }
        }
        adminDatabase.add(admin);
        return true;
    }

    public boolean login(String username, String password) {
        for (Admin admin : adminDatabase) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAdminAccountCreated() {
        return !adminDatabase.isEmpty();
    }

    public boolean createMedcin(Medcin medcin) {
        for (Medcin existingMedcin : medcinDatabase) {
            if (existingMedcin.getUsername().equals(medcin.getUsername())) {
                return false; // Medcin already exists
            }
        }
        medcinDatabase.add(medcin);
        return true;
    }

    public boolean createSecretaire(Secretaire secretaire) {
        for (Secretaire existingSecretaire : secretaireDatabase) {
            if (existingSecretaire.getUsername().equals(secretaire.getUsername())) {
                return false; // Secretaire already exists
            }
        }
        secretaireDatabase.add(secretaire);
        return true;
    }

    public static List<Medcin> getAllMedcins() {
        return medcinDatabase;
    }

    public static List<Secretaire> getAllSecretaires() {
        return secretaireDatabase;
    }

    public static List<Admin> getAllAdmins() {
        return adminDatabase;
        // Implémentez la logique pour récupérer tous les admins
    }

    public boolean deleteUserById(int userId) {
        boolean found = false;
        
        Iterator<Admin> adminIterator = adminDatabase.iterator();
        while (adminIterator.hasNext()) {
            if (adminIterator.next().getId() == userId) {
                adminIterator.remove();
                found = true;
                break;
            }
        }
        
        if (!found) {
            Iterator<Medcin> medcinIterator = medcinDatabase.iterator();
            while (medcinIterator.hasNext()) {
                if (medcinIterator.next().getId() == userId) {
                    medcinIterator.remove();
                    found = true;
                    break;
                }
            }
        }
        
        if (!found) {
            Iterator<Secretaire> secretaireIterator = secretaireDatabase.iterator();
            while (secretaireIterator.hasNext()) {
                if (secretaireIterator.next().getId() == userId) {
                    secretaireIterator.remove();
                    found = true;
                    break;
                }
            }
        }
        
        return found;
    }
}

