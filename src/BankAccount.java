import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with deposit, withdrawal, and freeze/unfreeze capabilities.
 *
 * <p>This class manages a bank account's balance, account number, and frozen status.
 * Deposits and withdrawals are disallowed while the account is frozen.</p>
 *
 * @author Arman Redrino
 * @version 1.0
 * @since 2026-10-22
 */
public class BankAccount {
  private String accountNumber;
  private double balance;
  private boolean isFrozen;
  private List<Transaction> transactionHistory;

  /**
   * Creates a bank account with the specified account number and initial balance.
   *
   * @param accountNumber the account's number
   * @param initialBalance the account's starting balance
   */
  public BankAccount(String accountNumber, double initialBalance) {
    this.accountNumber = accountNumber;
    this.balance = initialBalance;
    this.isFrozen = false;
    this.transactionHistory = new ArrayList<>();
    checkFrozenStatus();
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public String getOwnerName() {
    return accountNumber;
  }

  /**
   * Returns the account's current balance.
   *
   * @return the current balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Deposits a positive amount into the account unless the account is frozen.
   *
   * @param amount the amount to deposit
   */
  public void deposit(double amount) {
    if (isFrozen) {
      System.out.println("Account " + accountNumber + " is frozen. Deposit not allowed.");
      return;
  }
    if (amount > 0) {
      balance += amount;
      transactionHistory.add(new Transaction("Deposit", amount));
      System.out.println("Amount Deposited: " + amount);
    } else {
      System.out.println("Amount Deposited: " + amount);
      System.out.println("Invalid deposit amount. Deposit must be greater than 0.");
    }
  }

  /**
   * Withdraws a positive amount from the account unless it is frozen or has
   * insufficient funds.
   *
   * @param amount the amount to withdraw
   */
  public void withdraw(double amount) {
    if (isFrozen) {
      System.out.println("Account " + accountNumber + " is frozen. Withdrawal not allowed.");
      return;
    }
    if (amount > 0) {
      if (amount <= balance) {
        balance -= amount;
        transactionHistory.add(new Transaction("Withdraw", amount));
        System.out.println("Amount Withdrawn: " + amount);
      } else {
        System.out.println("Amount Withdrawn: " + amount);
        System.out.println("Insufficient balance.");
      }
    } else {
      System.out.println("Amount Withdrawn: " + amount);
      System.out.println("Invalid withdrawal amount.");
    }
  }

  public List<Transaction> getTransactionHistory() {
    return transactionHistory;
  }

  public void freezeAccount() {
    isFrozen = true;
    System.out.println("Account " + accountNumber + " has been frozen.");
  }

  public void unfreezeAccount() {
    isFrozen = false;
    System.out.println("Account " + accountNumber + " has been unfrozen.");
  }

  public boolean isFrozen() {
    return isFrozen;
  }

  private void checkFrozenStatus() {
    if (isFrozen) {
      System.out.println("Account " + accountNumber + " is currently frozen.");
    } else {
      System.out.println("Account " + accountNumber + " is active.");
    }
  }
}
