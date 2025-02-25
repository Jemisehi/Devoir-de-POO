public abstract class Vehicule {
    protected  final String immatriculation ;
    protected final  String marque ;
    protected final String model ;
    protected  final int annee ;
    protected  int kilométrage ;
    protected String statut ;
    protected static int nbreVehicule=0;
    protected int idVehicule;

    public Vehicule(String immatriculation, String marque, String model, int annee, int kilométrage) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.model = model;
        this.annee = annee;
        this.kilométrage = kilométrage;
        nbreVehicule++;
        idVehicule=nbreVehicule;
        this.statut= ParcAutomobile.DISPONIBLE;
    }


    // Getters


    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public String getModel() {
        return model;
    }

    public int getAnnee() {
        return annee;
    }

    public int getKilométrage() {
        return kilométrage;
    }

    public String getStatut() {
        return statut;
    }

    public static int getNbreVehicule() {
        return nbreVehicule;
    }

    public int getIdVehicule() {
        return idVehicule;
    }
//settters

    public void setKilométrage(int kilométrage) {
        this.kilométrage = kilométrage;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    //méthode
    public abstract double calculerPrixLoccation ();

    @Override
    public String toString() {
        return "Immatriculation: " + immatriculation +
                "\nMarque: " + marque +
                "\nModel: " + model +
                "\nAnnee: " + annee +
                "\nKilometrage: " + kilométrage +
                "\nStatut: " +statut;

    }
}






