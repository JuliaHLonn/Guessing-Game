package se.iths.gamewithscoreboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameWithScoreboardApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GameWithScoreboardApplication.class, args);
    }

    @Autowired
    PlayerRepository repository;

    @Override
    public void run(String... args) throws Exception {
       // repository.save(new Player());
    }
}
