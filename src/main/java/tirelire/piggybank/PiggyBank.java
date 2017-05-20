package tirelire.piggybank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import projectchild.ProjectChild;
import tirelire.exception.CantRemoveMoney;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pictime on 20/05/17.
 */
public class PiggyBank implements Serializable {

    private PiggyBank(){}
    private Integer amount = 0;
    private ArrayList<Transaction> history = new ArrayList<Transaction>();
    private ProjectChild project;
    private static PiggyBank PIGGYBANK = new PiggyBank();

    public static PiggyBank getInstance()
    {
        return PIGGYBANK;
    }

    public Integer addMoney(Integer value){
        System.out.println(value);
        history.add(new Transaction(value,  (new SimpleDateFormat("MM-dd-yyyy").format(new Date())).toString(), TypeTransaction.DEPOT));
        amount+=value;
        updatePourcentageProject();
        return amount;    }

    public Integer removeMoney(Integer value) throws CantRemoveMoney {
        if( amount < value ) throw new CantRemoveMoney();
        history.add(new Transaction(value, ((new SimpleDateFormat("MM-dd-yyyy").format(new Date())).toString()).toString(), TypeTransaction.RETRAIT));

         amount-=value;
        updatePourcentageProject();
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
        if(this.project==null)
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
    @Override
    public String toString() {
        return "PiggyBank{" +
                "amount=" + amount +
                ", history=" + history +
                ", project=" + project +
                '}';
    }
}
