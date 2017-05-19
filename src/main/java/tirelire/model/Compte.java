package tirelire.model;

/**
 * Created by pictime on 20/05/17.
 */
public class Compte {
    Double solde;

    public Compte(Double solde) {
        this.solde = solde;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
