

public class Voiture extends Vehicule implements Louable {
    private int nbPlaces;
    private String typeCarburant;
    private String idVehicule;
    private String Statut;


    public Voiture(String immatriculation, String marque, String model, int annee, int kilométrage, int nbPlaces, int typeCarburant) {
        super(immatriculation, marque, model, annee, kilométrage);
        setTypeCarburant(typeCarburant);
        setNbPlaces(nbPlaces);
    }

    public String toString() {
        return this.idVehicule + ".Voiture{\n" +
                super.toString() +
                "\nNombre de places: " + nbPlaces +
                "\nType d'essence: " + typeCarburant + "}";
    }


    //Getters

    public int getNbPlaces() {
        return nbPlaces;
    }

    public String getTypeCarburant() {
        return typeCarburant;
    }

    //Setters

    public void setTypeCarburant(int typeCarburant) {
        switch (typeCarburant) {
            case 1:
                this.typeCarburant = "Electrique";
                break;
            case 2:
                this.typeCarburant = "Diesel";
            default:
                this.typeCarburant = "Essence";


        }
    }

    public void setNbPlaces(int nbPlaces) {
        if (nbPlaces > 0) {
            this.nbPlaces = 5;

        }
    }
    // methode


    @Override
    public void louer() throws VehiculeIndisponibleException {
        if (this.statut.equals(ParcAutomobile.LOUE)) {
            throw new VehiculeIndisponibleException("le véhicule est déjà loué ");
        } else {
            this.statut = ParcAutomobile.LOUE;
        }
    }

    @Override
    public void retourner() {
        this.Statut = ParcAutomobile.DISPONIBLE;
    }

    @Override
    public double calculerPrixLoccation() {
        if (typeCarburant.equals("Essence")) {
            return 25000;
        } else if (typeCarburant.equals("Diesiel")) {
            return 500000;

        } else if (typeCarburant.equals("Electrique ")) {
            return 400000;
        } else {
            return 25000;
        }
    }


}