import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Manages bank accounts stored by their IDs.
 */
public class BankAccountManager implements Bank {
  private final Map<Integer, BankAccount> accounts;
  private int id;

  public BankAccountManager() {
    accounts = new HashMap<>();
    id = 0;
  }

  @Override
  public void addAccount(BankAccount account) {
    Objects.requireNonNull(account, "account");
    if (accounts.size() >= 100) {
      throw new IllegalStateException("Cannot add more than 100 bank accounts.");
    }

    accounts.put(id, account);
    id++;
  }

  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  @Override
  public void listAccounts() {
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      BankAccount account = entry.getValue();
      System.out.printf("ID: %d, Owner: %s, Balance: %.2f%n",
          entry.getKey(), account.getOwnerName(), account.getBalance());
    }
  }
}
