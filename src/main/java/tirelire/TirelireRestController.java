package tirelire;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import projectchild.ProjectChild;
import tirelire.exception.CantRemoveMoney;
import tirelire.job.CompteJob;
import tirelire.piggybank.Autorisation;
import tirelire.piggybank.PiggyBank;

import java.text.ParseException;

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
    @RequestMapping(value = "/api/piggy-bank/get-account", method = RequestMethod.GET)
    public  @ResponseBody PiggyBank  get() throws JsonProcessingException {
        //piggyBank.addMoney(number);
        // System.out.println(piggyBank.getAmount());
        return piggyBank;
    }
    @RequestMapping(value = "/api/piggy-bank/add-money", method = RequestMethod.POST)
    public  @ResponseBody PiggyBank  add( @RequestBody Integer amount)  {
        piggyBank.addMoney(amount);
        System.out.println(piggyBank.getAmount());
        return piggyBank;
    }
    @RequestMapping(value = "/api/piggy-bank/update-autorisation", method = RequestMethod.POST)
    public  @ResponseBody PiggyBank  updateAutorisation( @RequestBody Integer amount)  {
        piggyBank.setAutorisation(new Autorisation(amount));
        System.out.println(piggyBank.getAmount());
        return piggyBank;
    }
    @RequestMapping(value = "/api/piggy-bank/remove-money", method = RequestMethod.POST)
    public @ResponseBody PiggyBank  reduce( @RequestBody Integer number) throws CantRemoveMoney, ParseException {
        //return compteJob.getSold(login);
        piggyBank.removeMoney(number);
        //  System.out.println(piggyBank.getAmount());
        return piggyBank;
    }
    @RequestMapping(value = "/api/piggy-bank/create-project", method = RequestMethod.POST)
    public @ResponseBody PiggyBank  create( @RequestBody Integer number,
                                            @RequestBody String name) throws CantRemoveMoney {
        ProjectChild projectChild = null;
        if(name!=null && number!=null)
            projectChild = new ProjectChild(name,number);
        else if(number!=null)
             projectChild = new ProjectChild("project"+number,number);

        //return compteJob.getSold(login);
        piggyBank.createProject(projectChild);
        //  System.out.println(piggyBank.getAmount());
        System.out.print(piggyBank);
        return piggyBank;
    }





}
