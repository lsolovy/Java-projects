/**
 * LoanAccount is a class that extends Account
 * This is a sub class of Account
 * Main purpose is to introduce a payment and interest rate
 */
public class LoanAccount extends Account {
    /**private double will keep track of the interest rate */
    private double rate;
    /**private payment will keep track of the payment amount */
    private double payment;
    /**
     * Constructor will set the parameters including the new one of rate and payment
     * @param balance
     * @param accountNum
     * @param firstName
     * @param lastName
     * @param rate
     * @param payment
     */
    public LoanAccount(double balance, int accountNum, String firstName, String lastName, double rate, double payment) {
        super(balance, accountNum, firstName, lastName);
        this.rate = rate;
        this.payment = payment;

    }

    /*public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }*/

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
     * will subtract the payment amount from the balance
     * @param payment
     */
    @Override
    public void Deposit(double payment) {
        setBalance(getBalance() - payment);
    }

    /**
     * will format the string when returning the information plus the interest rate and payment amount
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s%n%s %.2f%n%s: %.2f", super.toString(), "Interest Rate:", rate, "Payment amount", payment);
    }

}
