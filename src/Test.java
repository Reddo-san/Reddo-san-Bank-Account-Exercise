public class Test {
    public static void main(String[] args) {
        // Create a SavingsAccount instance
        SavingsAccount savingsAccount = new SavingsAccount("John Doe");

        // Display account details
        System.out.println("Account Owner: " + savingsAccount.getOwnerName());
        System.out.println("Account Number: " + savingsAccount.getAccountNumber());
        System.out.println("Initial Balance: " + savingsAccount.getBalance());

        // Perform some transactions
        savingsAccount.deposit(1000.0);
        System.out.println("Current Balance: " + savingsAccount.getBalance());

        // Deposit 0.0 to test the deposit validation
        savingsAccount.deposit(0.0); // This should not be allowed
        System.out.println("Current Balance: " + savingsAccount.getBalance());

        // Deposit a negative amount to test the deposit validation
        savingsAccount.deposit(-500.0); // This should not be allowed
        System.out.println("Current Balance: " + savingsAccount.getBalance());

        // Withdraw an amount
        savingsAccount.withdraw(500.0);
        System.out.println("Current Balance: " + savingsAccount.getBalance());

        //Withdraw an amount greater than the balance to test the withdrawal validation
        savingsAccount.withdraw(600.0); // This should not be allowed
        System.out.println("Current Balance: " + savingsAccount.getBalance());

        //withdraw a negative amount to test the withdrawal validation
        savingsAccount.withdraw(-100.0); // This should not be allowed
        System.out.println("Current Balance: " + savingsAccount.getBalance());

        // Freeze the account and attempt a withdrawal
        savingsAccount.freezeAccount();
        savingsAccount.withdraw(200.0); // This should not be allowed

        // Unfreeze the account and attempt a withdrawal again
        savingsAccount.unfreezeAccount();
        savingsAccount.withdraw(200.0);
        System.out.println("Balance after withdrawal: " + savingsAccount.getBalance());
    }
}