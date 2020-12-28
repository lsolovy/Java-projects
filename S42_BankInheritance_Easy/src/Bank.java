import java.util.Scanner;
/**
 * Bank is the main program that will run
 * It allows for the user to create as many accounts as they wish
 * They can choose any of the three accounts to create
 * If they wish to exit and not create as many as they said they will type -1
 */
public class Bank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the bank");
        System.out.println("Enter the amount of accounts you would like to make");
        int numOfAcc = scan.nextInt();
        for(int i = 0; i < numOfAcc; i++){
            System.out.println("What account would you like to access");
            System.out.println("Type 1, for Savings");
            System.out.println("Type 2, for Checkings");
            System.out.println("Type 3, for Loan");
            System.out.println("Type -1, to EXIT");
            int type = scan.nextInt();
            if(type == 1){

                System.out.println("Please enter your balance (Must be above $0)");
                double balance = scan.nextDouble();
                System.out.println("Please enter your account number");
                int accNum = scan.nextInt();
                System.out.println("Please enter your first name");
                String first = scan.next();
                System.out.println("Please enter your last name");
                String last = scan.next();
                System.out.println("Please enter interest rate");
                double rate = scan.nextDouble();
                System.out.println("Please enter a deposit");
                double deposit = scan.nextDouble();
                System.out.println("Please enter a withdrawal");
                double withdrawal = scan.nextDouble();
                SavingsAccount saving = new SavingsAccount(balance,accNum,first,last,rate);
                System.out.println(saving.toString());
                saving.setRate(rate);
                saving.addInterest();
                saving.Deposit(deposit);
                saving.Withdrawals(withdrawal);
                double newBalance = saving.getBalance();
                System.out.println("New Balance with interest,deposit,and withdrawal:"+newBalance);
            }
            if(type == 2){

                System.out.println("Please enter your balance (Must be above $0)");
                double balance = scan.nextDouble();
                System.out.println("Please enter your account number");
                int accNum = scan.nextInt();
                System.out.println("Please enter your first name");
                String first = scan.next();
                System.out.println("Please enter your last name");
                String last = scan.next();
                System.out.println("Please enter a deposit");
                double deposit = scan.nextDouble();
                System.out.println("Please enter a withdrawal");
                double withdrawal = scan.nextDouble();
                CheckingAccount checking = new CheckingAccount(balance,accNum,first,last,500);
                System.out.println(checking.toString());
                checking.Withdrawals(withdrawal);
                checking.Deposit(deposit);
                double newBalance = checking.getBalance();
                System.out.println("New Balance with interest,deposit,and withdrawal:"+newBalance);
            }
            if(type == 3){
                System.out.println("Please enter your balance (Must be above $0)");
                double balance = scan.nextDouble();
                System.out.println("Please enter your account number");
                int accNum = scan.nextInt();
                System.out.println("Please enter your first name");
                String first = scan.next();
                System.out.println("Please enter your last name");
                String last = scan.next();
                System.out.println("Please enter interest rate");
                double rate = scan.nextDouble();
                System.out.println("Enter Payment amount");
                double payment = scan.nextDouble();
                LoanAccount loan = new LoanAccount(balance,accNum,first,last,rate,payment);
                System.out.println(loan.toString());
                loan.setRate(rate);
                loan.addInterest();
                loan.Deposit(payment);
                double newBalance = loan.getBalance();
                System.out.println("New Balance with interest & payment:"+newBalance);
            }
            if(type == -1){
                i = numOfAcc;
            }



        }
    }

}
