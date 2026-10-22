import java.time.LocalDateTime;

public class Transaction {
  private LocalDateTime time_stamp;
  private String type;
  private double amount;

  public Transaction(String type, double amount) {
    this(LocalDateTime.now(), type, amount);
  }

  public Transaction(LocalDateTime timestamp, String type, double amount) {
    this.time_stamp = timestamp;
    this.type = type;
    this.amount = amount;
  }

  public LocalDateTime getTimestamp() {
    return time_stamp;
  }

  public String getType() {
    return type;
  }

  public double getAmount() {
    return amount;
  }
}
