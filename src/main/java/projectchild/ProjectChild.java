package projectchild;

import com.fasterxml.jackson.databind.ObjectMapper;
import tirelire.exception.CantRemoveMoney;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pictime on 20/05/17.
 */
public class ProjectChild implements Serializable {

    private ProjectChild(){}
    private String name;
    private Integer amount = 0;


    private static ProjectChild PROJECTYCHILD = new ProjectChild();

    public static ProjectChild getInstance()
    {
        return PROJECTYCHILD;
    }

    public Integer addMoney(Integer value){
        return amount+=value;
    }

    public Integer removeMoney(Integer value) throws CantRemoveMoney {
        if( amount < value ) throw new CantRemoveMoney();
        return amount-=value;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }



}
