package se.iths.gamewithscoreboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


@Service
@SessionScope
public class GameService {
    private int secretNumber;
    Random rand = new Random();

    Player player;

    @Autowired
    PlayerRepository repository;

    private GuessCounter guessCounter = new GuessCounter();

    private Result result = new Result();


    public GameService() {

        this.secretNumber = rand.nextInt(100);

    }

    public void setNumber(int random) {
        this.secretNumber = random;
    }

    public String compareGuess(int guess, String user) {
        if (guess < secretNumber) {
            guessCounter.tickGuesses();
            return ("Your guess was: " + (guess) + " that is too low. \n" +
                    "You have guessed " + guessCounter.getGuesses() + " times");
        } else if (guess > secretNumber) {
            guessCounter.tickGuesses();
            return ("Your guess was: " + (guess) + " that is too high. \n" +
                    "You have guessed " + guessCounter.getGuesses() + " times");
        } else {
            guessCounter.tickGuesses();
            String winString = ("Your guess was: " + (guess) + " that is right! \n" +
                    "You have guessed " + guessCounter.getGuesses() + " times." +
                    "There is now a new secret number if you want to play again!");
            setNumber(rand.nextInt(100));
            result.setResult(guessCounter.getGuesses());
            enterScoreBoard(user);
            guessCounter.resetGuesses();
            return winString;
        }
    }

    public Player findUser(String name) {
        return repository.findByuserName(name);
    }

    public void createUser(String name) {
        player = new Player(name);
        player = repository.save(player);
    }

    public void enterScoreBoard(String user) {
        player = findUser(user);
        player.addToList(result);
        player.setAverage();
        player = repository.save(player);

    }

    public List<Player> displayScoreboard() {
        List<Player> list = repository.findAll();
        list.sort(Comparator.comparingDouble(p -> p.getAverage()));
               return list;
    }
}
