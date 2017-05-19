package tirelire.piggybank;

import java.util.Date;

/**
 * Created by pictime on 20/05/17.
 */
public class Transaction {

    private Integer amount;
    private Date date;
    private TypeTransaction type;

    public Transaction(Integer amount, Date date, TypeTransaction type) {
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

}
