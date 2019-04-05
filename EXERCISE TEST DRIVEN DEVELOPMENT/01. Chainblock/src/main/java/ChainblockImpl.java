import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        if (transaction == null || this.contains(transaction.getId())) {
            return;
        }

        this.transactions.put(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        if (transaction == null) {
            return false;
        }
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) throws IllegalAccessException {
        if (!this.contains(id) || newStatus == null) {
            throw new IllegalArgumentException();
        }

        Transaction transaction = this.getById(id);

        try {
            Field field = transaction.getClass().getDeclaredField("status");
            field.setAccessible(true);
            field.set(transaction, newStatus);
        } catch (NoSuchFieldException ex) {

        }

    }

    public void removeTransactionById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        this.transactions.remove(id);
    }

    public Transaction getById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }

        return this.transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(final TransactionStatus status) {
        Iterable<Transaction> result = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());

        if (!result.iterator().hasNext()) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Iterator<Transaction> iterator = this.getByTransactionStatus(status).iterator();

        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next().getSender());
        }

        return result;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        Iterator<Transaction> iterator = this.getByTransactionStatus(status).iterator();

        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next().getReceiver());
        }

        return result;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactions
                .values()
                .stream()
                .sorted((t1, t2) -> {
                    int amountDescSortResult = Double.compare(t2.getAmount(), t1.getAmount());

                    if (amountDescSortResult == 0) {
                        return Integer.compare(t2.getId(), t1.getId());
                    }

                    return amountDescSortResult;
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        Iterable<Transaction> result = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getSender().equals(sender))
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());

        if (!result.iterator().hasNext()) {
            throw new IllegalArgumentException();
        }
        return result;

    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        Iterable<Transaction> result = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getReceiver().equals(receiver))
                .sorted((t1, t2) -> {
                    int amountDescResult = Double.compare(t2.getAmount(), t1.getAmount());
                    if(amountDescResult == 0){
                        return Double.compare(t1.getId(), t2.getId());
                    }
                    return amountDescResult;
                }).collect(Collectors.toList());

        if(!result.iterator().hasNext()){
            throw new IllegalArgumentException();
        }

        return result;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {

        if(status == null || amount < 0){
            return new ArrayList<>();
        }

        return this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status) && transaction.getAmount() <= amount)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        if(sender == null || amount < 0){
            throw new IllegalArgumentException();
        }

        Iterable<Transaction> result = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getSender().equals(sender) && transaction.getAmount() > amount)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .collect(Collectors.toList());

        if(!result.iterator().hasNext()){
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        if(receiver == null || lo < 0 || hi < 0 || hi < lo){
            throw new IllegalArgumentException();
        }

        Iterable<Transaction> result = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getReceiver().equals(receiver) && transaction.getAmount() >= lo && transaction.getAmount() < hi)
                .sorted((t1, t2) ->{
                    int amountDescResult = Double.compare(t2.getAmount(), t1.getAmount());
                    if(amountDescResult == 0){
                        return Integer.compare(t1.getId(), t2.getId());
                    }
                    return amountDescResult;
                }).collect(Collectors.toList());

        if(!result.iterator().hasNext()){
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        if(lo < 0 || hi < 0 || hi < lo){
            return new ArrayList<>();
        }

        return this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getAmount() >= lo && transaction.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return this.transactions.values().iterator();
    }
}
