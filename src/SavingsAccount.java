/**
 * Represents a savings account with an initial balance of zero.
 *
 * @author Arman Redrino
 * @version 1.0
 * @since 2026-10-22
 */
public class SavingsAccount extends BankAccount {
  /** The name of the account owner. */
  private String ownerName;

  public SavingsAccount(String ownerName) {
    // Call the superclass constructor with ownerName and initial balance of 0.0
    super(ownerName, 0.0);
    this.ownerName = ownerName;
  }

  @Override
  public String getOwnerName() {
    return ownerName;
  }
}