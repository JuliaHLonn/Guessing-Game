package se.iths.gamewithscoreboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*     Laboration 1
 * När man ska göra ändringar/ lägga till saker i en player i databasen måste vi ha tag i den
 * och inte objektet som skapats i intellij. save() returnerar playern som den skapar
 * p=rep.save(p) sparar objektet i databasen i p. Efter varje ändring på objektet i intellij
 * måste vi göra save så.
 * Findby ger också access till databas objektet.*/
@Controller
public class GameController {

    @Autowired
    GameService service;

    String currentUser;

    @GetMapping("/guessgame")
    public String addForm() {
        return "guessgame";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username) {
        currentUser = username;

        if (service.findUser(username) == null) {
            service.createUser(username);
            return "guessgame";
        } else if (username.equalsIgnoreCase(service.findUser(username).getUserName()))
            return "guessgame";
        else
            service.createUser(username);
        return "guessgame";
    }

    @PostMapping("/guessgame")
    public String guessGame(Model m, @RequestParam int userguess) {
        m.addAttribute("response", service.compareGuess(userguess,currentUser));
        return "guessgame";
    }

    @GetMapping("/scoreboard")
    public String displayScoreBoard(Model m){
        m.addAttribute("toplist",service.displayScoreboard());
        return "scoreboard";
    }


}
