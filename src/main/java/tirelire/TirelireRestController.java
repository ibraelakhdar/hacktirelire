package tirelire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tirelire.job.CompteJob;
import tirelire.piggybank.PiggyBank;

/**
 * Created by sleroy on 19/05/17.
 */
@RestController
public class TirelireRestController {

    @Autowired
    CompteJob compteJob;

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello";
    }

    private PiggyBank piggyBank = PiggyBank.getInstance();


    @RequestMapping(value = "/api/solde", method = RequestMethod.GET)
    public Double getSolde(@RequestParam(required = true, value="login") final String login) {
        //return compteJob.getSold(login);
        return new Double(500);
    }
    @RequestMapping(value = "/api/piggy-bank/add-money/{number}", method = RequestMethod.GET)
    public Integer add( @PathVariable(value="number") Integer number) {
        piggyBank.addMoney(number);
        System.out.println(piggyBank.getAmount());
        return piggyBank.getAmount();
    }
    @RequestMapping(value = "/api/reduceSolde", method = RequestMethod.GET)
    public Double reduce(@RequestParam(required = true, value="login") final String login,
                         @RequestParam(required = true, value="amount") final Double amount) {
        //return compteJob.getSold(login);
        return new Double(500-amount);
    }




}
