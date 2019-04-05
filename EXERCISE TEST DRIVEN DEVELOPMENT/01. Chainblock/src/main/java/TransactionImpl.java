import java.util.Objects;

public class TransactionImpl implements Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }



    public int getId() {
        return this.id;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public String getSender() {
        return this.from;
    }

    public String getReceiver() {
        return this.to;
    }

    public double getAmount() {
        return this.amount;
    }

    public int compareTo(Transaction o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionImpl that = (TransactionImpl) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
