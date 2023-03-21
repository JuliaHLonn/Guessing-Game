package se.iths.gamewithscoreboard;

public class GuessCounter {
    private int guess = 0;


    public void resetGuesses(){
        guess = 0;
    }
    public int getGuesses() {
        return guess;
    }

    public void tickGuesses() {
        guess ++;
    }
}
