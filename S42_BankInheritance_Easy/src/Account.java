/**
 * Class Account is the super class of this program. All other Accounts will extend this class
 * This class's main purpose is to get the balance, account number, and name
 */
public class Account {
    /**private double balance will keep track of the balance */
    private double balance;
    /**private int accountNum will keep track of the account number*/
    private int accountNum;
    /**private String firstName will keep track of the first name*/
    private String firstName;
    /**private String lastName will keep track of the last name*/
    private String lastName;

    /**
     * Constructor that will set the parameters
     * @param balance
     * @param accountNum
     * @param firstName
     * @param lastName
     */
    public Account(double balance, int accountNum, String firstName, String lastName){
        this.accountNum = accountNum;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;

    }
    public Account(){

    }

    /**
     * will set the balance
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * will get the balance
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /*public int getAccountNum() {
        return accountNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }*/

    /**
     * will increase the balance by the deposit
     * @param deposit
     */
    public void Deposit (double deposit){
        balance = balance + deposit;
    }

    /**
     * will decrease the balance by the withdrawal
     * will throw if the withdrawal is bigger than the balance
     * @param withdrawals
     */
    public void Withdrawals(double withdrawals){
        if(withdrawals > balance){
            throw  new IllegalArgumentException("Not enough money");
        }
        balance = balance - withdrawals;

    }

    /**
     * will format the string when returning the information
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s %d%n%s: %.2f ", "Account", firstName, lastName,
                "Account Number:", accountNum, "Bank Balance", balance);
    }
}
