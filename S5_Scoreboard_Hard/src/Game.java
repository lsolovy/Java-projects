/**
 * Game is an abstract class that allow of abstract methods to be created
 * Game consist of four abstract classes that will be used in each class that extends Game
 */
public abstract class Game {
    // default constructor
    public Game(){}
    /**abstract ScoringMethod[] will get the score array */
    public abstract ScoringMethod[] getScoreArray();
    /**abstract boolean isGameOver will be used to tell when the game is over*/
    public abstract boolean isGameOver();
    /**abstract void updateScore will be used to update the score based on the option the user picks from the score array */
    public abstract void updateScore (int option);
    /**abstract int getPeriod will be used to return the current period*/
    public abstract int getPeriod();
    /**abstract String getPeriodName will be used to gte the period name */
    public abstract String getPeriodName();
}
