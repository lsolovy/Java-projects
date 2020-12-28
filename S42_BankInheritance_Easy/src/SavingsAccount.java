/**
 * SavingsAccount is a class that extends Account
 * This is a sub class of Account
 * Main purpose is to introduce an interest rate variable to the balance
 */
public class SavingsAccount extends Account {
    private double rate; /**private double rate to keep track of interest rate */
    /**
     * Constructor that will set the parameters including the new one of rate
     * @param balance
     * @param accountNum
     * @param firstName
     * @param lastName
     * @param rate
     */
    public SavingsAccount(double balance, int accountNum, String firstName, String lastName, double rate) {
        super(balance, accountNum, firstName, lastName);
        this.rate = rate;
    }

    /**
     * will return the rate
     * @return
     */
    public double getRate() {
        return rate;
    }

    /**
     * will set the rate
     * @param rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * will add the interest rate to the balance
     */
    public void addInterest(){
       setBalance(getBalance() * (1 + getRate()));

    }

    /**
     * will format the string when returning the information plus the rate
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s%n%s %.2f", super.toString(), "Interest Rate:", rate);
    }
}
