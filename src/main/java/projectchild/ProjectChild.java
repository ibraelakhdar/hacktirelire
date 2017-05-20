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
public class ProjectChild {

    private String name;
    private Integer amount = 0;
    private double pourcentage;


     public ProjectChild(String name,Integer amount ){this.name=name;this.amount=amount;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    @Override
    public String toString() {
        return "ProjectChild{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
