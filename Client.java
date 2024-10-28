import java.util.ArrayList;

public class Client {
    private static  int nombreClients=0;
    private int idClient;
    private final String nom;
    private final String  prenom;
    private String permisConduire;
    private final String  numero ;
    private static ArrayList<Client> ListeDeClients = new ArrayList<>();
    private ArrayList<Vehicule> listeVehicule;

    public Client(String nom, String prenom, int permisConduire, String  numero) {
        this.nom = nom;
        this.prenom = prenom;
        setPermisConduire(permisConduire);
        this.numero = numero;
        this.listeVehicule = new ArrayList<>();
        nombreClients++;
        idClient=nombreClients;
        ListeDeClients.add(this);
        listeVehicule=new ArrayList<>();
    }

    //Getters


    public String getnom() {
        return nom;
    }

    public String getprenom() {
        return prenom;
    }

    public String getPermisConduire() {
        return permisConduire;
    }

    public String  getNumero() {
        return numero;
    }

    public static ArrayList<Client> getListeDeClients() {
        return ListeDeClients;
    }

    public static int getNombreClients() {
        return nombreClients;
    }

    public int getIdClient() {
        return idClient;
    }

    public ArrayList<Vehicule> getListeVehicule() {
        return listeVehicule;

    }


    //Setters
    public void setPermisConduire(int permisConduire) {
        switch (permisConduire) {
            case 1:
                this.permisConduire ="C";
                break;
            case 2 :
                this.permisConduire="BC";
                break;
            default:
                this.permisConduire ="B";

        }


    }

    //methode

    public void louerVehicule(Vehicule vehicule) throws ClientNonAutoriseException {
        if (vehicule instanceof Camion camion) {
            if (this.permisConduire.equals("B")) {
                throw new ClientNonAutoriseException("Vous n'êtes pas autorisé à louer ce véhicule");
            } else {
                try {
                    camion.louer();
                    this.listeVehicule.add(camion);
                    System.out.println("\nVéhicule loué avec succès...");
                    System.out.println("Le prix de location est de : " + camion.calculerPrixLoccation());
                } catch (VehiculeIndisponibleException e) {
                    System.out.println("\n" + e.getMessage());
                }
            }
        } else if (vehicule instanceof Voiture voiture) {
            try {
                voiture.louer();
                this.listeVehicule.add(voiture);
                System.out.println("\nVéhicule loué avec succès...");
                System.out.println("Le prix de location est de : " + voiture.calculerPrixLoccation());
            } catch (VehiculeIndisponibleException e) {
                System.out.println("\n" + e.getMessage());
            }
        }

    }


        public void retournerVehicule(Vehicule vehicule ){
           if (vehicule instanceof Camion ){
               ((Camion ) vehicule ). retourner();

           } else if (vehicule instanceof Voiture ) {
               ((Voiture) vehicule).retourner();
           }


        }

    public String toString() {
        return this.idClient + " - {\n" +
                "\nNom: " + nom +
                "\nPrenoms: " + prenom +
                "\nPermis de conduire: " + permisConduire +
                "\nNumero de telephone: " + numero+" }";
   }
}












