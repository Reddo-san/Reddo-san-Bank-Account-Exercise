/**
 * Main class that demonstrates a savings account and bank account management.
 */
public class Main {
  /**
   * Demonstrates savings account transactions and account management.
   *
   * @param args command-line arguments (unused)
   */
  public static void main(String[] args) {
    // Create a SavingsAccount instance
    SavingsAccount savingsAccount = new SavingsAccount("Test0");

    // Display account details
    System.out.println("Account Owner: " + savingsAccount.getOwnerName());
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

    //Freeze the account and attempt a deposit
    savingsAccount.deposit(100.0); // This should not be allowed

    // Unfreeze the account and attempt a withdrawal again
    savingsAccount.unfreezeAccount();
    savingsAccount.withdraw(300.0);
    System.out.println("Balance after withdrawal: " + savingsAccount.getBalance());

    // Deposit an amount after unfreezing the account
    savingsAccount.deposit(200.13);

    // Display transaction history
    System.out.println("Transaction History:");
    for (Transaction transaction : savingsAccount.getTransactionHistory()) {
      System.out.println("Type: " + transaction.getType() +
                    ", Amount: " + transaction.getAmount() +
                    ", Timestamp: " + transaction.getTimestamp());
    }

    //Create a Bank Account Manager
    BankAccountManager manager = new BankAccountManager();

    //Add acc1 under the Bank Account Manager
    manager.addAccount(savingsAccount);

    //Create a new account under Bank Account Manager
    SavingsAccount acc2 = new SavingsAccount("Test1");
    manager.addAccount(acc2);

    //List all the created account under Bank Account Manager
    manager.listAccounts();

  }
}