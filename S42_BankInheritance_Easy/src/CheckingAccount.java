/**
 * CheckingAccount is a class that extends Account
 * This is a sub class of Account
 * Main purpose is to introduce an overdraft limit
 */
public class CheckingAccount extends Account {
    private double overdraft ; /**private double overdraft will keep track of the overdraft limit */
    /**
     * Constructor will set the parameters including the new one of overdraft
     * @param balance
     * @param accountNum
     * @param firstName
     * @param lastName
     * @param overdraft
     */
    public CheckingAccount(double balance, int accountNum, String firstName, String lastName,double overdraft) {
        super(balance, accountNum, firstName, lastName);
        this.overdraft = overdraft;
    }

    // good programming habit, dont technically need them
    //if I didn't have them they would be private but I could still access them

    /*public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }*/

    /**
     * will set the balance to the new balance with the withdrawal
     * makes sure the withdrawal is not greater than the overdraft plus the current balance
     * @param withdrawals
     */
    @Override
    public void Withdrawals(double withdrawals) {
        if(withdrawals > getBalance() + overdraft){
            throw  new IllegalArgumentException("Not enough money");
        }
        setBalance(getBalance() - withdrawals);
    }

    /**
     * will format the string when returning the information plus the overdraft limit
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s%n%s %.2f", super.toString(), "OverDraft Limit:", overdraft);
    }


}
