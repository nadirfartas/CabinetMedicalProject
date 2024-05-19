import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import controller.*;
import model.*;

public class App  {
    private static AdminService adminService = new AdminService();
    private static SecretaireService secretaireService = new SecretaireService();
    private static MedcinService medcinService = new MedcinService();
    private static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
        
        if (!adminService.isAdminAccountCreated()) {
            System.out.println("Créer le premier compte Administrateur");
            createAdminAccount();
        }
    // Récupérer la liste des médecins existants
    List<Medcin> medcins = adminService.getAllMedcins();

    // Définir la liste des médecins dans MedcinService
    medcinService.setMedcins(medcins);
        while (true) {
            try {
                System.out.println("1. Connexion en tant qu'Admin");
                System.out.println("2. Connexion en tant que Secrétaire");
                System.out.println("3. Connexion en tant que Médecin");
                System.out.println("4. Quitter");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        adminLogin();
                        break;
                    case 2:
                        secretaireLogin();
                        break;
                    case 3:
                        medcinLogin();
                        break;
                    case 4:
                        System.out.println("Au revoir!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                System.out.println("ERROR de saisie !");
            }
        }
            
    }

    private static void createAdminAccount() {
        try {
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            Admin admin = new Admin(username, password);
            if (adminService.createAdmin(admin)) {
                System.out.println("Compte administrateur créé avec succès.");
            } else {
                System.out.println("Erreur lors de la création du compte administrateur.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void adminLogin() {
        try {
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            if (adminService.login(username, password)) {
                System.out.println("Connexion réussie.");
                adminMenu();
            } else {
                System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }   
    }

    private static void adminMenu() {
        while (true) {
            try {
                System.out.println("1. Gérer les utilisateurs");
                System.out.println("2. Afficher tous les utilisateurs");
                System.out.println("3. Supprimer un utilisateur");
                System.out.println("4. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());
        
                switch (choice) {
                    case 1:
                        manageUsers();
                        break;
                    case 2:
                    displayAllUsers();
                        break;
                        
                    case 3:
                    deleteUser();
                    break;
                    case 4:
                    return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
    }

    private static void displayAllUsers() {
        List<Admin> admins = adminService.getAllAdmins();
        List<Medcin> medcins = adminService.getAllMedcins();
        List<Secretaire> secretaires = adminService.getAllSecretaires();
    
        System.out.println("\nAdministrateurs:");
        for (Admin admin : admins) {
            System.out.println("ID: " + admin.getId() + ", Nom d'utilisateur: " + admin.getUsername());
        }
    
        System.out.println("\nMédecins:");
        for (Medcin medcin : medcins) {
            System.out.println("ID: " + medcin.getId() + ", Nom d'utilisateur: " + medcin.getUsername() + ", Spécialité: " + medcin.getSpecialite());
        }
    
        System.out.println("\nSecrétaires:");
        for (Secretaire secretaire : secretaires) {
            System.out.println("ID: " + secretaire.getId() + ", Nom d'utilisateur: " + secretaire.getUsername());
        }
    }
    private static void deleteUser() {
        System.out.print("Entrez l'ID de l'utilisateur à supprimer: ");
        int userId = Integer.parseInt(scanner.nextLine());int cppt11 = 0;
        for(Admin admin: AdminService.getAllAdmins()){
            cppt11++;
        }
        if(cppt11 != 1){
            if (adminService.deleteUserById(userId)) {
                System.out.println("Utilisateur supprimé avec succès.");
            } else {
                System.out.println("Erreur lors de la suppression de l'utilisateur.");
            }
        }else{
            System.out.println("Vous pouvez pas supprimer le seul admin.");
        }    
    }


    private static void manageUsers() {
        while (true) {
            try{
                System.out.println("1. Créer un compte médecin");
                System.out.println("2. Créer un compte secrétaire");
                System.out.println("3. Retour");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        createMedcinAccount();
                        break;
                    case 2:
                        createSecretaireAccount();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
    }

    private static void createMedcinAccount() {
        try{
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            System.out.print("Spécialité: ");
            String specialite = scanner.nextLine();
            Medcin medcin = new Medcin(username, password, specialite);
            if (adminService.createMedcin(medcin)) {
                System.out.println("Compte médecin créé avec succès.");
            } else {
                System.out.println("Erreur lors de la création du compte médecin.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void createSecretaireAccount() {
        try{
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            Secretaire secretaire = new Secretaire(username, password);
            if (adminService.createSecretaire(secretaire)) {
                System.out.println("Compte secrétaire créé avec succès.");
            } else {
                System.out.println("Erreur lors de la création du compte secrétaire.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void secretaireLogin() {
        try{
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            if (secretaireService.login(username, password)) {
                System.out.println("Connexion réussie.");
                secretaireMenu();
            } else {
                System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void secretaireMenu() {
        while (true) {
            try{
                System.out.println("1. Gérer les Patients");
                System.out.println("2. Gérer les rendez-vous");
                System.out.println("3. Gérer les fiches patients");
                System.out.println("4. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        managePatients();
                        break;
                    case 2:
                        manageRendezVous();
                        break;    
                    case 3:
                        manageFichesPatients();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
    }

    private static void manageRendezVous() {
        while (true) {
            try {
                System.out.println("\n1. Ajouter un rendez-vous");
                System.out.println("2. Afficher tous les rendez-vous");
                System.out.println("3. Supprimer un rendez-vous");
                System.out.println("4. Retour");
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                scanner.nextLine();
        
                switch (choice) {
                    case 1:
                        System.out.print("ID du patient: ");
                        int idPatient = scanner.nextInt();
                        scanner.nextLine();
                        if(PatientController.obtenirPatientParId(idPatient) == null){
                            System.out.println("Patient introuvable. Veuillez vérifier l'ID du patient ou créer le patient d'abord.");
                            break;
                        }
                        System.out.print("ID du médecin: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();                  
                        Patient patient = PatientController.obtenirPatientParId(idPatient);
                        secretaireService.createPatient(patient);
        
                        System.out.print("Date et heure (yyyy-MM-ddTHH:mm) : ");
                        String dateTimeString = scanner.nextLine();
                        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                        Medcin medcin = medcinService.trouverMedcinParId(id);
                        
                        if (medcin != null && medcin.getId() == id) {
                            if (secretaireService.isMedcinAvailable(medcin.getId(), dateTime)) {
                                RendezVous rendezVous = new RendezVous(dateTime, patient, medcin);
                                if (secretaireService.createRendezVous(rendezVous)) {
                                    System.out.println("Rendez-vous créé avec succès.");
                                } else {
                                    System.out.println("Erreur lors de la création du rendez-vous.");
                                }
                            } else {
                                System.out.println("Le médecin n'est pas disponible à ce créneau. Choisissez une autre date ou heure.");
                            }
                        } else {
                            System.out.println("Médecin introuvable ou ne possède pas l'ID recherchée. Créez le compte médecin d'abord ou vérifiez l'ID.");
                        }
                        break;
                    case 2:
                        secretaireService.displayAllRendezVous();
                        break;
                    case 3:
                        System.out.print("ID du rendez-vous à supprimer : ");
                        int idToDelete = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (secretaireService.deleteRendezVous(idToDelete)) {
                            System.out.println("Rendez-vous supprimé avec succès.");
                        } else {
                            System.out.println("Erreur lors de la suppression du rendez-vous.");
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie");
            }
        }
    }
    
    private static void managePatients(){
        while (true) {
            try{
                System.out.println("\n1. Ajouter un Patients");
                System.out.println("2. Afficher tous les Patients");
                System.out.println("3. Supprimer un Patients");
                System.out.println("4. Retour");
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                scanner.nextLine();
        
                switch (choice) {
                    case 1:
                        System.out.print("Nom du patient: ");
                        String nom = scanner.nextLine();
                        System.out.print("Prénom du patient: ");
                        String prenom = scanner.nextLine();
                        System.out.print("Téléphone du patient: ");
                        String telephone = scanner.nextLine();
                        System.out.print("Age du patient: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Genre du patient: ");
                        String gender = scanner.nextLine();
                        Patient patient = new Patient(nom, prenom, telephone, age, gender);
                        DossierMedicale dossier = new DossierMedicale(patient);
                        DossierMedicalService.ajouterdossier(dossier);
                        PatientController.ajouterPatient(patient);
                        if(secretaireService.createPatient(patient)){
                            System.out.println("Patient est crée avec succés.");
                            break;
                        }else{
                            System.out.println("Erreur lors de la création du patient.");
                            break;
                        }
                    case 2:
                        SecretaireService.displayAllpatients();    
                        break;
                    case 3:
                        System.out.println("Le ID de patient à supprimer :");
                        int idToDelete = scanner.nextInt();
                        scanner.nextLine();
                        DossierMedicalService.supprimerDos(idToDelete);
                        if(secretaireService.deletePatient(idToDelete)){
                            System.out.println("Patient supprimé avec succés");
                            break;
                        }else{
                            System.out.println("Erreur lors de la suppression du patient.");
                            break;
                        }
                    case 4:
                        return;
                    default :
                        System.out.println("Option invalide. Veuillez réessayer.");    
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
    }
}

    private static void manageFichesPatients() {
        while (true) {
            try{
                System.out.println("\n1. Créer une fiche patient");
                System.out.println("2. Afficher une fiche patient");
                System.out.println("3. supprimer une fiche patient");
                System.out.println("4. Afficher tous les fiches patients");
                System.out.println("5. Retour");
                System.out.print("Choisissez une option : ");
                int choice = scanner.nextInt();
                scanner.nextLine();
        
                switch (choice) {
                    case 1:
                        creerFichePatient();
                        break;
                    case 2:
                        afficherFichePatient();
                        break;
                    case 3:
                        supprimerFichePatient();    
                    case 4:
                        FichePatientService.displayAllFiches();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
    }

    private static void creerFichePatient() {
        try{
            System.out.print("ID du patient: ");
            int patientId = scanner.nextInt();
            scanner.nextLine();
            // Rechercher le patient dans la base de données
            Patient patient = PatientController.obtenirPatientParId(patientId);
            DossierMedicale dossier = DossierMedicalService.obtenirdossierParId(patientId);
            if (patient != null && dossier != null) {
                // Remplir les informations de la fiche patient
                System.out.print("date d'aujourd'hui et heure (yyyy-MM-ddTHH:mm) : ");
                String dateTimeString = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                // Le patient existe, créer une nouvelle fiche patient pour ce patient
                FichePatient fichePatient = new FichePatient(patient, dateTime);
                // Ajouter la fiche patient au dossier medical
                dossier.ajouterFichePatients(fichePatient);
                FichePatientService.ajouter(fichePatient);
                System.out.println("Fiche patient crée avec succès pour " + patient.getNom() + " " + patient.getPrenom());
                } else {
                    System.out.println("Patient ou dossier introuvable. Veuillez vérifier l'ID du patient ou créer le patient d'abord.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void afficherFichePatient() {
        try{
            System.out.print("ID du patient: ");
            int dossierId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("ID du fiche: ");
            int ficheId = scanner.nextInt();
            scanner.nextLine();

            // Rechercher le patient dans la base de données
            Patient patient = PatientController.obtenirPatientParId(dossierId);
            DossierMedicale dossier = DossierMedicalService.obtenirdossierParId(dossierId);
            FichePatient fichePatient = FichePatientService.obtenirFichierParId(ficheId);

            if (dossier != null && fichePatient != null && patient != null) {
                // Afficher les informations de la fiche patient
                System.out.println("Fiche Patient pour " + patient.getNom() + " " + patient.getPrenom());
                System.out.println("date de fiche " + fichePatient.getDateCN().toString());
                if (fichePatient.getantecedentsMedicaux() == null && fichePatient.getOperations() == null && fichePatient.getGynéco_obstétricaux() == null && fichePatient.getPoids() == 0 && fichePatient.getTaille() == 0 && fichePatient.getConstantesVitales() == null && fichePatient.getTares() == null  ) {
                    System.out.println("les autres informations n'ont pas été remplies par le medcin.");
                }else{
                    // Afficher d'autres informations de la fiche patient...
                    System.out.println("L'observation : %n");
                    System.out.println("Les antecedents Medicaux : " + fichePatient.getantecedentsMedicaux());
                    System.out.println("Les antecedents Chirurgicaux : Operations : " + fichePatient.getOperations() + ",Gynéco obstétricaux : " + fichePatient.getGynéco_obstétricaux() + ",poids : " + fichePatient.getPoids() + ",taille : " + fichePatient.getTaille() + ",ConstantesVitales : " + fichePatient.getConstantesVitales() + ",tares : " + fichePatient.getTares());
                }
            } else {
                System.out.println("Patient introuvable ou pas de fiche patient associée.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void supprimerFichePatient() {
        try{
            System.out.println("Le ID de fiche à supprimer :");
            int idToDelete = scanner.nextInt();
            scanner.nextLine();
            DossierMedicalService.obtenirdossierParId(FichePatientService.obtenirFichierParId(idToDelete).getPatient().getId()).supprimerFichePatient(idToDelete);
            if(FichePatientService.supprimerFiche(idToDelete)){
                System.out.println("Fiche supprimé avec succés");
            }else{
                System.out.println("Erreur lors de la suppression du fiche.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }            
    }

    private static void medcinLogin() {
        try{
            System.out.print("Nom d'utilisateur: ");
            String username = scanner.nextLine();
            System.out.print("Mot de passe: ");
            String password = scanner.nextLine();
            if (medcinService.login(username, password)) {
                System.out.println("Connexion réussie.");
                medcinMenu();
            } else {
                System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void medcinMenu() {
        while (true) {
            try{
                System.out.println("1. Gérer les dossiers médicaux");
                System.out.println("2. Gérer les Fiches Patient.");
                System.out.println("3. Gérer les Ordonnances");
                System.out.println("4. Gérer les Certificates Médicaux.");
                System.out.println("5. Voir les rendez-vous");
                System.out.println("6. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        manageDossierMedical();
                        break;
                    case 2:
                        modifierFichesPatients();
                        break;
                    case 3:
                        manageOrdonnances();
                        break;
                    case 4:
                        manageCertificatMedicaux();
                        break;
                    case 5:
                        secretaireService.displayAllRendezVous();
                        break;    
                    case 6:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
    }

    private static void manageDossierMedical() {
        while (true) {
            try{
                System.out.println("Gestion des dossiers médicaux ");
                System.out.println("1.Consulter les dossiers médicaux.");
                System.out.println("2.creer un Résumé Médical d'un dossier medical");
                System.out.println("3.supprimer un Résumé Médical d'un dossier medical");
                System.out.println("4. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        consulterDossierMedical();
                        break;
                    case 2:
                        creerResumeMedical();
                        break;
                    case 3:
                        supprimerResumeMedical();
                        break;    
                    case 4:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
    }

    public static void consulterDossierMedical() {
        while (true) {
            try{
                System.out.println("1.Consulter un dossier médical.");
                System.out.println("2.Voir tous les dossiers medicaux.");
                System.out.println("3. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        consDosMedical();
                        break;
                    case 2:
                        DossierMedicalService.displayAllDossiers();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
        
    }    

    public static void consDosMedical(){
        try{
            System.out.println("DossierID :");
            int idDossier = scanner.nextInt();
            scanner.nextLine();
            DossierMedicale dos = DossierMedicalService.obtenirdossierParId(idDossier);
            System.out.println("Patient : " + dos.getPatient().getNom() + dos.getPatient().getPrenom());
            while (true) {
                try{
                    System.out.println("1.Consulter les résumés médicaux.");
                    System.out.println("2.Consulter les Ordonnances");
                    System.out.println("3.Consulter les certificates médicaux.");
                    System.out.println("4.Consulter les fiches Patient.");
                    System.out.println("5. Retour.");
                    System.out.print("Choisissez une option: ");
                    int choice1 = Integer.parseInt(scanner.nextLine());

                    switch (choice1) {
                        case 1:
                            System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", "ID", "Date", "Nom et Prenom Patient", "Nom Medcin", "Observations medicaux");
                            for (ResumeMedical resumeMedical : dos.getResumeMedicals()) {
                                System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s%n",
                                        resumeMedical.getId(),
                                        resumeMedical.getDateR().toString(),
                                        resumeMedical.getPatient().getNom() + resumeMedical.getPatient().getPrenom(),
                                        resumeMedical.getMedcin().getUsername(),
                                        resumeMedical.getObservations()
                                );
                            }
                            break;
                        case 2:
                            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Date", "Nom et Prenom Patient", "Nom Medcin", "Medicaments", "instructions");
                            for (Ordonnance ordonnance : dos.getOrdonnances()) {
                                System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s%n",
                                        ordonnance.getId(),
                                        ordonnance.getDateO().toString(),
                                        ordonnance.getPatient().getNom() + ordonnance.getPatient().getPrenom(),
                                        ordonnance.getMedcin().getUsername(),
                                        ordonnance.getMedicaments(),
                                        ordonnance.getInstructions()
                                );
                            }
                            break;
                        case 3:
                            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID", "Date", "Nom Patient", "Prenom Patient", "Nom Medcin", "description");
                            for (CertificatMedicale certificatMedicale : dos.getCertificat()) {
                                System.out.printf("%-10d %-20s %-20s %-20s %-20s %-20s%n",
                                        certificatMedicale.getId(),
                                        certificatMedicale.getDate().toString(),
                                        certificatMedicale.getPatient().getNom(),
                                        certificatMedicale.getPatient().getPrenom(),
                                        certificatMedicale.getMedcin().getUsername(),
                                        certificatMedicale.getReason()
                                );
                            }
                            break;
                        case 4:
                            System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", "ID", "Nom", "Prenom", "Date", "informations");
                            for (FichePatient fiche : dos.getFichePatients()) {
                                System.out.printf("%-10d %-20s %-20s %-20s %-20s%n",
                                        fiche.getId(),
                                        fiche.getPatient().getNom(),
                                        fiche.getPatient().getPrenom(),
                                        fiche.getDateCN().toString(),
                                        "Autres details(Afficher la fiche seul dans 'Gerer les fiches patient.' pour voir autres details)"
                                );
                            }
                            break;    
                        case 5:
                            return;
                        default:
                            System.out.println("Choix invalide. Réessayez.");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("ERROR de saisie !");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }            
    }

    public static void creerResumeMedical(){
        try{
            System.out.println("Le ID du dossier :");
            int idDossier = scanner.nextInt();
            scanner.nextLine();
            Patient patient = PatientController.obtenirPatientParId(idDossier);
            System.out.println("Le ID du medcin :");
            int idMedcin = scanner.nextInt();
            scanner.nextLine();
            Medcin medcin = medcinService.trouverMedcinParId(idMedcin);
            if(patient != null && medcin !=null){
                System.out.print("Date et heure (yyyy-MM-ddTHH:mm) : ");
                String dateTimeString = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                System.out.print("Observations : ");
                String observation = scanner.nextLine();
                ResumeMedical resumeMedical = new ResumeMedical(dateTime,medcin,patient,observation);
                ResumeMedicalService.ajouterResume(resumeMedical);
                DossierMedicalService.obtenirdossierParId(idDossier).ajouterResumeMedical(resumeMedical);
                System.out.println("Résumé Médical créé avec succès.");
            }else{
                System.out.println("dossier ou Medcin introuvable.Veuillez vérifier l'ID ou creer le dossier d'abord.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void supprimerResumeMedical(){
        try{
            System.out.println("Le ID de résumé à supprimer :");
            int idToDelete = scanner.nextInt();
            scanner.nextLine();
            DossierMedicalService.obtenirdossierParId(ResumeMedicalService.obtenirResumeParId(idToDelete).getPatient().getId()).supprimerResume(idToDelete);
            if(ResumeMedicalService.supprimerResume(idToDelete)){
                System.out.println("Résumé supprimé avec succès.");
            }else{
                System.out.println("Erreur lors de la suppression du résumé.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    private static void modifierFichesPatients() {
        while (true) {
            try{
                System.out.println("Gestion des fiches patient ");
                System.out.println("1.Remplir une fiche patient");
                System.out.println("2.Afficher une fiche patient");
                System.out.println("3.supprimer une fiche patient");
                System.out.println("4.Afficher tous les fiches patient.");
                System.out.println("5. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        RemplirFichePatient();
                        break;
                    case 2:
                        afficherFichePatient();
                        break;
                    case 3:
                        supprimerFichePatient();
                        break; 
                    case 4:
                        FichePatientService.displayAllFiches();   
                    case 5:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }
    }

    public static void RemplirFichePatient(){
        try{
            System.out.println("Le ID fiche à remplir:");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine();
            FichePatient fichePatient = FichePatientService.obtenirFichierParId(idToUpdate);
            if (fichePatient != null) {
                System.out.print("AntecedentsMedicaux : ");
                String antecedentsMedicaux = scanner.nextLine();
                fichePatient.setantecedentsMedicaux(antecedentsMedicaux);
                System.out.print("Operations : ");
                String operations = scanner.nextLine();
                fichePatient.setOperations(operations);
                System.out.print("Gynéco obstétricaux : ");
                String gynéco_obstétricaux = scanner.nextLine();
                fichePatient.setGynéco_obstétricaux(gynéco_obstétricaux);
                System.out.print("Poids : ");
                double poids = scanner.nextInt();
                scanner.nextLine();
                fichePatient.setPoids(poids);
                System.out.print("Taille : ");
                double taille = scanner.nextInt();
                scanner.nextLine();
                fichePatient.setTaille(taille);
                System.out.print("constantes Vitales : ");
                String constantesVitales = scanner.nextLine();
                fichePatient.setConstantesVitales(constantesVitales);
                System.out.print("Tares : ");
                String tares = scanner.nextLine();
                fichePatient.setTares(tares);
                System.out.println("fiche Remplie avec succès.");
            }else{
                System.out.println("Fiche introuvable, Veulliez vérifier le ID ou créer la fiche d'abord");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    public static void manageOrdonnances(){
        while (true) {
            try{
                System.out.println("Gestion des Ordonnances.");
                System.out.println("1.creer une ordonnance");
                System.out.println("2.Afficher une ordonnance");
                System.out.println("3.supprimer une ordonnance");
                System.out.println("4.Afficher tous les ordonnances.");
                System.out.println("5. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        creerOrdonnance();
                        break;
                    case 2:
                        afficherOrdonnance();
                        break;
                    case 3:
                        supprimerOrdonnance();
                        break; 
                    case 4:
                        OrdonnanceService.displayAllOrdonnances();
                        break;   
                    case 5:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        } 
    }

    public static void creerOrdonnance(){
        try{
            System.out.println("Le ID du dossier :");
            int idDossier = scanner.nextInt();
            scanner.nextLine();
            Patient patient = PatientController.obtenirPatientParId(idDossier);
            System.out.println("Le ID du medcin :");
            int idMedcin = scanner.nextInt();
            scanner.nextLine();
            Medcin medcin = medcinService.trouverMedcinParId(idMedcin);
            if(patient != null && medcin !=null){
                System.out.print("Date et heure (yyyy-MM-ddTHH:mm) : ");
                String dateTimeString = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                System.out.print("Medicaments : ");
                String medicaments = scanner.nextLine();
                System.out.print("Instructions : ");
                String instructions = scanner.nextLine();
                Ordonnance ordonnance = new Ordonnance(dateTime, medcin, patient, instructions, medicaments);
                OrdonnanceService.ajouterOrdonnance(ordonnance);
                DossierMedicalService.obtenirdossierParId(idDossier).ajouterOrdonnance(ordonnance);
                System.out.println("Ordonnance créé avec succès.");
            }else{
                System.out.println("dossier ou Medcin introuvable.Veuillez vérifier l'ID ou creer le dossier d'abord.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    public static void afficherOrdonnance(){
        try{
            System.out.print("ID du patient: ");
            int dossierId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("ID de l'ordonnance : ");
            int ordonnanceId = scanner.nextInt();
            scanner.nextLine();

            // Rechercher le patient dans la base de données
            Patient patient = PatientController.obtenirPatientParId(dossierId);
            DossierMedicale dossier = DossierMedicalService.obtenirdossierParId(dossierId);
            Ordonnance ordonnance = OrdonnanceService.obtenirOrdonnanceParId(ordonnanceId);

            if (dossier != null && ordonnance != null && patient != null) {  
                System.out.println("Date et heure: " + ordonnance.getDateO().toString());          
                System.out.println("Nom et Prenom du patient : " + ordonnance.getPatient().getNom() + ordonnance.getPatient().getPrenom());
                System.out.println("Nom du medcin : " + ordonnance.getMedcin().getUsername());
                System.out.println("Les médicaments : " +  ordonnance.getMedicaments());
                System.out.println("Les instructions : " + ordonnance.getInstructions());
            }else{
                System.out.println("Patient introuvable ou pas de ordonnances associée.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }                           
    }

    public static void supprimerOrdonnance(){
        try{
            System.out.println("Le ID de l'ordonnance à supprimer :");
            int idToDelete = scanner.nextInt();
            scanner.nextLine();
            DossierMedicalService.obtenirdossierParId(OrdonnanceService.obtenirOrdonnanceParId(idToDelete).getPatient().getId()).supprimerOrdonnance(idToDelete);
            if(OrdonnanceService.supprimerOrdonnance(idToDelete)){
                System.out.println("Ordonnance supprimé avec succès.");
            }else{
                System.out.println("Erreur lors de la suppression de l'ordonnance.");
            }  
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    public static void manageCertificatMedicaux(){
        while (true) {
            try{
                System.out.println("Gestion des certificats médicaux.");
                System.out.println("1.creer une certificat médicale");
                System.out.println("2.Afficher une certificat médicale");
                System.out.println("3.supprimer une certificat médicale");
                System.out.println("4.Afficher tous les certificats médicaux.");
                System.out.println("5. Retour au menu principal");
                System.out.print("Choisissez une option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        creerCertificatmedicale();
                        break;
                    case 2:
                        afficherCertificatmedicale();
                        break;
                    case 3:
                        supprimerCertificatmedicale();
                        break; 
                    case 4:
                        CertificatService.displayAllCertificatmedicaux();
                        break;  
                    case 5:
                        return;
                    default:
                        System.out.println("Choix invalide. Réessayez.");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("ERROR de saisie !");
            }
        }

    }
    
    public static void creerCertificatmedicale(){
        try{
            System.out.println("Le ID du dossier :");
            int idDossier = scanner.nextInt();
            scanner.nextLine();
            Patient patient = PatientController.obtenirPatientParId(idDossier);
            System.out.println("Le ID du medcin :");
            int idMedcin = scanner.nextInt();
            scanner.nextLine();
            Medcin medcin = medcinService.trouverMedcinParId(idMedcin);
            if(patient != null && medcin !=null){
                System.out.print("Date et heure (yyyy-MM-ddTHH:mm) : ");
                String dateTimeString = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                System.out.print("Description : ");
                String reason = scanner.nextLine();
                CertificatMedicale certificatMedicale = new CertificatMedicale(dateTime, medcin, patient, reason);
                CertificatService.ajouterCertificat(certificatMedicale);
                DossierMedicalService.obtenirdossierParId(idDossier).ajouterCertificat(certificatMedicale);
                System.out.println("Certificat créé avec succès.");
            }else{
                System.out.println("dossier ou Medcin introuvable.Veuillez vérifier l'ID ou creer le dossier d'abord.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }

    public static void afficherCertificatmedicale(){
        try{
            System.out.print("ID du patient: ");
            int dossierId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("ID du certificat : ");
            int certificatId = scanner.nextInt();
            scanner.nextLine();

            // Rechercher le patient dans la base de données
            Patient patient = PatientController.obtenirPatientParId(dossierId);
            DossierMedicale dossier = DossierMedicalService.obtenirdossierParId(dossierId);
            CertificatMedicale certificatMedicale = CertificatService.obtenirCertificatParId(certificatId);

            if (dossier != null && certificatMedicale != null && patient != null) {  
                System.out.println("Date et heure: " + certificatMedicale.getDate().toString());          
                System.out.println("Nom et Prenom du patient : " + certificatMedicale.getPatient().getNom() + certificatMedicale.getPatient().getPrenom());
                System.out.println("Nom du medcin : " + certificatMedicale.getMedcin().getUsername());
                System.out.println("Description : " +  certificatMedicale.getReason());
            }else{
                System.out.println("Patient introuvable ou pas de certificat Medicale associée.");
            }         
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }                  
    }

    public static void supprimerCertificatmedicale(){
        try{
            System.out.println("Le ID du Certificat à supprimer :");
            int idToDelete = scanner.nextInt();
            scanner.nextLine();
            DossierMedicalService.obtenirdossierParId(CertificatService.obtenirCertificatParId(idToDelete).getPatient().getId()).supprimerCertificat(idToDelete);
            if(CertificatService.supprimerCertificat(idToDelete)){
                System.out.println("Certificat supprimé avec succès.");
            }else{
                System.out.println("Erreur lors de la suppression du Certificat médical.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("ERROR de saisie !");
        }
    }


    
}


