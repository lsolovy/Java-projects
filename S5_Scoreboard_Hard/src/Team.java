/** Team class is used to create the two teams in the game*/
public class Team {
    String name;
    int score;

    /**
     * Constructor will set the name to the team name and the score to 0
     */
    Team(String name){
        this.name = name;
        score = 0;
    }

    /**
     * getName returns the team name
     */
    public String getName() {
        return name;
    }

    /**
     *setName set the name to the team name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *getScore returns the score of the team
     */
    public int getScore() {
        return score;
    }

    /**
     *setScore sets the score of the team
     */
    public void setScore(int score) {
        this.score = score;
    }
}
