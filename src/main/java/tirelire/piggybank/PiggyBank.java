package tirelire.piggybank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import projectchild.ProjectChild;
import tirelire.exception.CantRemoveMoney;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by pictime on 20/05/17.
 */
public class PiggyBank implements Serializable {


    private Integer amount = 0;
    private ArrayList<Transaction> history = new ArrayList<Transaction>();
    private ProjectChild project;
    private Autorisation autorisation = new Autorisation(this.soldeAutorise);
    private Integer soldeAutorise = 50;
    private static PiggyBank PIGGYBANK = new PiggyBank();

    public static PiggyBank getInstance()
    {
        return PIGGYBANK;
    }
    private PiggyBank(){

    }
    public Integer addMoney(Integer value){
        System.out.println(value);
        history.add(new Transaction(value,  (new SimpleDateFormat("MM-dd-yyyy").format(new Date())).toString(), TypeTransaction.DEPOT));
        amount+=value;
        updatePourcentageProject();
        return amount;    }


    public Integer removeMoney(Integer value) throws CantRemoveMoney, ParseException {
        if( amount < value ) throw new CantRemoveMoney();
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.FRANCE);
        Date dateLastTransation = format.parse(history.get(history.size()-1).getDate());
        if(new Date().getTime() - dateLastTransation.getTime() > 262974600 ) {
            history.add(new Transaction(value, ((new SimpleDateFormat("MM-dd-yyyy").format(new Date())).toString()).toString(), TypeTransaction.RETRAIT));
            amount -= value;
            updatePourcentageProject();
        }
        return amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Transaction> history) {
        this.history = history;
    }
    public void createProject(ProjectChild project) {
        if(this.project==null && project!=null )
            this.project = project;
    }

    public ProjectChild getProject() {
        return project;
    }

    public void setProject(ProjectChild project) {
        this.project = project;
    }

    public void updatePourcentageProject() {
        if(this.project!=null)
            this.project.setPourcentage(this.amount/this.project.getAmount());
    }

    public Autorisation getAutorisation() {
        return autorisation;
    }

    public void setAutorisation(Autorisation autorisation) {
        this.autorisation = autorisation;
    }

    public Integer getSoldeAutorise() {
        return soldeAutorise;
    }

    public void setSoldeAutorise(Integer soldeAutorise) {
        this.soldeAutorise = soldeAutorise;
    }

    @Override
    public String toString() {
        return "PiggyBank{" +
                "amount=" + amount +
                ", history=" + history +
                ", project=" + project +
                '}';
    }
}
