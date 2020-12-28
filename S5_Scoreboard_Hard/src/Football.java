/**
 * Football is a class that extend Game and implements the abstract methods
 * This class will set up a game that replicates scoring in football
 */
public class Football extends Game {
    /**private ScoringMethod[] will be used to get the score array */
    private ScoringMethod[] scoreArray;
    /**private Team team1 will be used to set team2 */
    private Team team1;
    /**private Team team2 will be used to set team2*/
    private Team team2;
    /**private int numPeriods is used to set the max number of periods in football */
    private int numPeriods;
    /**private int currentPeriods is used to get track of the current period */
    private int currentPeriods;
    /**private String periodName is used to set the period type*/
    private String periodName;

    /**
     * Football constructor will take in two teams and set the score array with each team
     * will also set the periodName,numPeriods, and currentPeriods
     */
    Football(Team team1, Team team2) {
        periodName = "Quarter";
        numPeriods = 4;
        currentPeriods = 1;
        this.team1 = team1;
        this.team2 = team2;
        scoreArray = new ScoringMethod[10];
        // 5 ways to score in football
        scoreArray[0] = new ScoringMethod(team1.getName() + " Touchdown", 6);
        scoreArray[1] = new ScoringMethod(team1.getName() + " Extra Point", 1);
        scoreArray[2] = new ScoringMethod(team1.getName() + " Field Goal", 3);
        scoreArray[3] = new ScoringMethod(team1.getName() + " Two-point conversion" ,2);
        scoreArray[4] = new ScoringMethod(team1.getName() + " Safety", 2);
        scoreArray[5] = new ScoringMethod(team2.getName() + " Touchdown", 6);
        scoreArray[6] = new ScoringMethod(team2.getName() + " Extra Point", 1);
        scoreArray[7] = new ScoringMethod(team2.getName() + " Field Goal", 3);
        scoreArray[8] = new ScoringMethod(team2.getName() + " Two-point conversion" ,2);
        scoreArray[9] = new ScoringMethod(team2.getName() + " Safety", 2);
    }

    /**
     * ScoringMethod[] will return the scoreArray from the Football constructor
     */
    public ScoringMethod[] getScoreArray() {
        return scoreArray;
    }

    /**
     * will update the score based on the index of the scoreArray
     * will be chosen by the user
     */
    public void updateScore(int option) {
        if(option <= 4){
            team1.setScore(team1.getScore() + scoreArray[option].score);
        }
        else if(option <= 9){
            team2.setScore((team2.getScore() + scoreArray[option].score));
        }
        else if(option == 10){
            currentPeriods++;
        }

    }

    /**
     * will return the current period
     */
    public int getPeriod() {
        return currentPeriods;
    }

    /**
     * will return the period name
     */
    public String getPeriodName() {
        return periodName;
    }

    /**
     * true if the current period > number of periods
     */
    public boolean isGameOver() {
        return currentPeriods > numPeriods;
    }
}
