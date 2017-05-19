package tirelire.piggybank;

import tirelire.exception.CantRemoveMoney;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pictime on 20/05/17.
 */
public class PiggyBank {

    private PiggyBank(){}
    private Integer amount;
    private ArrayList<Transaction> history;

    private static PiggyBank PIGGYBANK = new PiggyBank();

    public static PiggyBank getInstance()
    {
        return PIGGYBANK;
    }

    public Integer addMoney(Integer value){
        history.add(new Transaction(value, new Date(), TypeTransaction.DEPOT));
        return amount++;
    }

    public Integer removeMoney(Integer value) throws CantRemoveMoney {
        if( amount > value ) throw new CantRemoveMoney();
        history.add(new Transaction(value, new Date(), TypeTransaction.RETRAIT));
        return amount++;
    }
}
