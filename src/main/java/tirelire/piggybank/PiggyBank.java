package tirelire.piggybank;

import tirelire.exception.CantRemoveMoney;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pictime on 20/05/17.
 */
public class PiggyBank {

    private PiggyBank(){}
    private Integer amount = 0;
    private ArrayList<Transaction> history = new ArrayList<Transaction>(l);

    private static PiggyBank PIGGYBANK = new PiggyBank();

    public static PiggyBank getInstance()
    {
        return PIGGYBANK;
    }

    public Integer addMoney(Integer value){
        System.out.println(value);
        history.add(new Transaction(value, new Date(), TypeTransaction.DEPOT));
        return amount+=value;
    }

    public Integer removeMoney(Integer value) throws CantRemoveMoney {
        if( amount > value ) throw new CantRemoveMoney();
        history.add(new Transaction(value, new Date(), TypeTransaction.RETRAIT));
        return amount-=value;
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
}
