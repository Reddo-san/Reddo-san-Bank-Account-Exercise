public class SavingsAccount extends BankAccount {
    private String ownerName;

 public SavingsAccount(String ownerName) {
        super(ownerName, 0.0); // Call the superclass constructor with ownerName and initial balance of 0.0
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }
}