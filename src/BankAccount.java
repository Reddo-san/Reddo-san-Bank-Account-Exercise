public class BankAccount {
    private String accountNumber;
    private double balance;
    private boolean isFrozen;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.isFrozen = false;
        checkFrozenStatus();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        } else {
            System.out.println("Amount Deposited: " + amount);
            System.out.println("Invalid deposit amount. Deposit must be greater than 0.");
        }
    }

    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account " + accountNumber + " is frozen. Withdrawal not allowed.");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Amount Withdrawn: " + amount);
            System.out.println("Invalid withdrawal amount.");
        }
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

