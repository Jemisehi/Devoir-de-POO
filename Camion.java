public class Camion  extends Vehicule implements Louable {
    private double capacite;
    private double nbDeEssieux;


    public Camion(String immatriculation, String marque, String model, int annee, int kilométrage, double capacite, double nbDeEssieux) {
        super(immatriculation, marque, model, annee, kilométrage);
        setCapacite(capacite);
        setNbDeEssieux(nbDeEssieux);
    }

    //Getters and setters


    public double getCapacite() {
        return capacite;
    }

    public void setCapacite(double capacite) {
        if (capacite > 0) {
            ;
            this.capacite = capacite;
        } else {

            this.capacite = 10;
        }
    }

    public double getNbDeEssieux() {
        return nbDeEssieux;
    }

    public void setNbDeEssieux(double nbDeEssieux) {
        if (nbDeEssieux > 0) {
            this.nbDeEssieux = nbDeEssieux;
        } else {

            {

                this.capacite = 10;
            }

        }
    }

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
        this.statut = ParcAutomobile.DISPONIBLE;
    }

    @Override
    public double calculerPrixLoccation() {
        if (this.capacite > 12) {
            return 250000;
        } else {
            return 50000;
        }
    }


}






