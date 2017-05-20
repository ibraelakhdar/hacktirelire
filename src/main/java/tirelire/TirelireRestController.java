package tirelire;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import projectchild.ProjectChild;
import tirelire.exception.CantRemoveMoney;
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
    @RequestMapping(value = "/api/piggy-bank/get-account", method = RequestMethod.GET)
    public  @ResponseBody PiggyBank  get() throws JsonProcessingException {
        //piggyBank.addMoney(number);
        // System.out.println(piggyBank.getAmount());
        return piggyBank;
    }
    @RequestMapping(value = "/api/piggy-bank/add-money", method = RequestMethod.POST)
    public  @ResponseBody PiggyBank  add( @RequestBody Integer amount) throws JsonProcessingException {
        piggyBank.addMoney(amount);
        System.out.println(piggyBank.getAmount());
        return piggyBank;
    }
    @RequestMapping(value = "/api/piggy-bank/remove-money/{number}", method = RequestMethod.GET)
    public @ResponseBody PiggyBank  reduce( @PathVariable(value="number") final Integer number) throws CantRemoveMoney {
        //return compteJob.getSold(login);
        piggyBank.removeMoney(number);
        //  System.out.println(piggyBank.getAmount());
        return piggyBank;
    }
    @RequestMapping(value = "/api/piggy-bank/create-project/{number}", method = RequestMethod.GET)
    public @ResponseBody PiggyBank  create( @PathVariable(value="number") final Integer number,
                                            @RequestParam(required = false, value="name") final String name) throws CantRemoveMoney {
        ProjectChild projectChild;
        if(name!=null)
            projectChild = new ProjectChild(name,number);
        else
             projectChild = new ProjectChild("project"+number,number);

        //return compteJob.getSold(login);
        piggyBank.createProject(projectChild);
        //  System.out.println(piggyBank.getAmount());
        System.out.print(piggyBank);
        return piggyBank;
    }





}
