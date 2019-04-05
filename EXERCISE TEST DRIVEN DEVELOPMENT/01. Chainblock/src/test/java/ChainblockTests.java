import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class ChainblockTests {

    private Transaction defaultTransaction;
    private Transaction secondTransaction;
    private Transaction thirdTransaction;
    private Chainblock chainblock;

    private static final int NUMBER_OF_DEFAULT_SEED_BLOCK_TRANSACTIONS = 3;

    private static final int DEFAULT_ID = 1;
    private static final TransactionStatus DEFAULT_TRANSACTION_STATUS_SUCCESSFUL = TransactionStatus.SUCCESSFUL;
    private static final String DEFAULT_SENDER = "PESHO";
    private static final String DEFAULT_RECEIVER = "GOSHO";
    private static final double DEFAULT_AMOUNT = 20;


    private static final int SECOND_ID = 2;
    private static final TransactionStatus SECOND_TRANSACTION_STATUS_FAILED = TransactionStatus.FAILED;
    private static final String SECOND_SENDER = "PESHO" + 2;
    private static final String SECOND_RECEIVER = "GOSHO" + 2;
    private static final double SECOND_AMOUNT = 40;


    private static final int THIRD_ID = 3;
    private static final TransactionStatus THIRD_TRANSACTION_STATUS_UNAUTHORIZED = TransactionStatus.UNAUTHORIZED;
    private static final String THIRD_SENDER = "PESHO" + 3;
    private static final String THIRD_RECEIVER = "GOSHO" + 3;
    private static final double THIRD_AMOUNT = 90;

    private Transaction[] defaultTransactions;

    private Transaction[] orderedDescByAmountTransactionsWithSameStatus;
    private Transaction[] notOrderedByAmountWithSameStatus;
    private Transaction[] orderedByAmountAndIdBothDesc;
    private Transaction[] notOrderedByAmountAndIdBothDesc;
    private Transaction[] orderedDescByAmountWithSameSenders;
    private Transaction[] notOrderedByAmountWithSameSenders;

    private Transaction[] orderedByAmountWithSameReceiversDescAndIdAsc;
    private Transaction[] notOrderedByAmountWithSameReceiversDescAndIdAsc;


    @Before
    public void init() {
        this.defaultTransaction = new TransactionImpl(DEFAULT_ID, TransactionStatus.SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, DEFAULT_AMOUNT);
        this.secondTransaction = new TransactionImpl(SECOND_ID, SECOND_TRANSACTION_STATUS_FAILED, SECOND_SENDER, SECOND_RECEIVER, SECOND_AMOUNT);
        this.thirdTransaction = new TransactionImpl(THIRD_ID, THIRD_TRANSACTION_STATUS_UNAUTHORIZED, THIRD_SENDER, THIRD_RECEIVER, THIRD_AMOUNT);

        this.defaultTransactions = new Transaction[]{defaultTransaction, secondTransaction, thirdTransaction};
        this.orderedDescByAmountTransactionsWithSameStatus = new Transaction[]
                {
                        new TransactionImpl(THIRD_ID, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, THIRD_SENDER, THIRD_RECEIVER, THIRD_AMOUNT),
                        new TransactionImpl(SECOND_ID, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, SECOND_SENDER, SECOND_RECEIVER, SECOND_AMOUNT),
                        new TransactionImpl(DEFAULT_ID, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, DEFAULT_AMOUNT)
                };

        this.notOrderedByAmountWithSameStatus = new Transaction[]
                {
                        new TransactionImpl(DEFAULT_ID, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, DEFAULT_AMOUNT),
                        new TransactionImpl(SECOND_ID, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, SECOND_SENDER, SECOND_RECEIVER, SECOND_AMOUNT),
                        new TransactionImpl(THIRD_ID, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, THIRD_SENDER, THIRD_RECEIVER, THIRD_AMOUNT),
                        secondTransaction,
                        thirdTransaction
                };

        this.orderedByAmountAndIdBothDesc = new Transaction[]{
                new TransactionImpl(5, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(4, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(3, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 40),
                new TransactionImpl(2, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 20),
                new TransactionImpl(1, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 10)
        };

        this.notOrderedByAmountAndIdBothDesc = new Transaction[]{
                new TransactionImpl(3, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 40),
                new TransactionImpl(1, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 10),
                new TransactionImpl(4, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(2, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 20),
                new TransactionImpl(5, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50)
        };

        this.orderedDescByAmountWithSameSenders = new Transaction[]{
                new TransactionImpl(2, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(1, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(3, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 40),
                new TransactionImpl(4, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 30)
        };

        this.notOrderedByAmountWithSameSenders = new Transaction[]{
                new TransactionImpl(3, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 40),
                new TransactionImpl(2, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(1, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(4, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 30),
                new TransactionImpl(5, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, THIRD_SENDER, THIRD_RECEIVER, 1000),
                new TransactionImpl(6, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, THIRD_SENDER, THIRD_RECEIVER, 4210)
        };


        this.orderedByAmountWithSameReceiversDescAndIdAsc = new Transaction[]{
                new TransactionImpl(1, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(2, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(3, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 40),
                new TransactionImpl(4, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 30),
        };

        this.notOrderedByAmountWithSameReceiversDescAndIdAsc = new Transaction[]{
                new TransactionImpl(3, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 40),
                new TransactionImpl(2, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(1, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 50),
                new TransactionImpl(4, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, 30),
                new TransactionImpl(5, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, THIRD_SENDER, THIRD_RECEIVER, 1000),
                new TransactionImpl(6, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, THIRD_SENDER, THIRD_RECEIVER, 4210)
        };

        this.chainblock = new ChainblockImpl();

    }


    @Test
    public void constructorShouldInitCollection() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.chainblock.getClass().getDeclaredField("transactions");
        field.setAccessible(true);
        LinkedHashMap<Integer, Transaction> collection = (LinkedHashMap<Integer, Transaction>)field.get(this.chainblock);
        assertNotNull(collection);
    }

    @Test
    public void constructorShouldInitCollectionWith0Elements() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.chainblock.getClass().getDeclaredField("transactions");
        field.setAccessible(true);
        LinkedHashMap<Integer, Transaction> collection = (LinkedHashMap<Integer, Transaction>) field.get(this.chainblock);

        assertEquals(0, collection.values().size());
    }

    @Test
    public void addShouldNotAddNullTransactions() {
        chainblock.add(null);

        assertEquals(0, chainblock.getCount());
    }

    @Test
    public void addShouldNotAddNonUniqueTransactions() {
        chainblock.add(defaultTransaction);
        chainblock.add(new TransactionImpl(1, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, DEFAULT_AMOUNT));

        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void addShouldAddTransactionAndContainsIt() {
        this.seedBlock();
        assertTrue(this.chainblock.contains(defaultTransaction));
    }


    @Test
    public void containsShouldReturnFalseForNull() {
        this.seedBlock();
        assertFalse(this.chainblock.contains(null));
    }

    @Test
    public void containsShouldReturnFalse() {
        this.seedBlock();
        assertFalse(this.chainblock.contains(new TransactionImpl(120, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL, DEFAULT_SENDER, DEFAULT_RECEIVER, DEFAULT_AMOUNT)));
    }

    @Test
    public void containsShouldReturnTrueForMultiple() {
        this.seedBlock();
        for (int i = 0; i < defaultTransactions.length; i++) {
            assertTrue(this.chainblock.contains(defaultTransactions[i]));
        }
    }

    @Test
    public void containsIdShouldReturnTrueResults() {
        this.seedBlock();
        for (int i = 0; i < defaultTransactions.length; i++) {
            assertTrue(this.chainblock.contains(defaultTransactions[i].getId()));
        }
    }

    @Test
    public void containsIdShouldReturnFalse() {
        this.seedBlock();
        assertFalse(this.chainblock.contains(120));
    }

    @Test
    public void getCountShouldReturn0OnEmptyBlock() {
        assertEquals(0, this.chainblock.getCount());
    }

    @Test
    public void getCountShouldIncrementWhenAddTransaction() {
        this.chainblock.add(this.defaultTransaction);
        assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void getCountShouldIncrementWhenAddMultipleTransactions() {
        this.seedBlock();
        assertEquals(NUMBER_OF_DEFAULT_SEED_BLOCK_TRANSACTIONS, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionByIdShouldThrowOnEmptyCollection() throws NoSuchFieldException, IllegalAccessException {
        this.chainblock.changeTransactionStatus(10, SECOND_TRANSACTION_STATUS_FAILED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionByIdShouldThrowForInvalidId() throws IllegalAccessException, NoSuchFieldException {
        this.seedBlock();
        this.chainblock.changeTransactionStatus(10, SECOND_TRANSACTION_STATUS_FAILED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionByIdShouldThrowForNullTransaction() throws NoSuchFieldException, IllegalAccessException {
        this.seedBlock();
        this.chainblock.changeTransactionStatus(1, null);
    }

    @Test
    public void changeTransactionByIdShouldChange() throws NoSuchFieldException, IllegalAccessException {
        this.seedBlock();
        this.chainblock.changeTransactionStatus(1, SECOND_TRANSACTION_STATUS_FAILED);

        assertEquals(this.chainblock.getById(1).getStatus(), SECOND_TRANSACTION_STATUS_FAILED);
    }

    @Test
    public void changeTransactionByIdShouldChangeMultiple() throws NoSuchFieldException, IllegalAccessException {
        this.seedBlock();
        this.chainblock.changeTransactionStatus(1, THIRD_TRANSACTION_STATUS_UNAUTHORIZED);
        this.chainblock.changeTransactionStatus(3, DEFAULT_TRANSACTION_STATUS_SUCCESSFUL);

        assertEquals(this.chainblock.getById(1).getStatus(), THIRD_TRANSACTION_STATUS_UNAUTHORIZED);
        assertEquals(this.chainblock.getById(3).getStatus(), DEFAULT_TRANSACTION_STATUS_SUCCESSFUL);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowOnEmpty() {
        this.chainblock.getById(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowOnInvalidId() {
        this.seedBlock();
        this.chainblock.getById(50);
    }

    @Test
    public void getByIdShouldReturnTransaction() {
        this.seedBlock();
        assertEquals(this.defaultTransaction, this.chainblock.getById(1));
    }

    @Test
    public void getByIdShouldReturnMultipleTransactionS() {
        this.seedBlock();
        for (int i = 0; i < this.defaultTransactions.length; i++) {
            assertEquals(this.defaultTransactions[i], this.chainblock.getById(this.defaultTransactions[i].getId()));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowOnEmpty() {
        this.chainblock.removeTransactionById(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowOnInvalidId() {
        this.seedBlock();
        this.chainblock.removeTransactionById(120);
    }

    @Test
    public void removeTransactionByIdShouldRemoveAndUpdateCount() {
        this.seedBlock();
        this.chainblock.removeTransactionById(1);
        assertFalse(this.chainblock.contains(1));
        assertEquals(2, this.chainblock.getCount());
    }

    @Test
    public void removeTransactionByIdShouldRemoveMultipleAndUpdateCount() {
        this.seedBlock();
        for (int i = 0; i < this.defaultTransactions.length; i++) {
            this.chainblock.removeTransactionById(this.defaultTransactions[i].getId());
            assertFalse(this.chainblock.contains(this.defaultTransactions[i].getId()));
        }
        assertEquals(0, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowOnEmpty() {
        this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowOnNoTransactionsWithGivenStatus() {
        this.seedWithSameStatus();
        this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldReturnOne() {
        this.seedWithSameStatus();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatus(this.thirdTransaction.getStatus()).iterator();

        assertEquals(thirdTransaction.getStatus(), actual.next().getStatus());
        assertFalse(actual.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldReturnMultipleSortedDesc() {
        this.seedWithSameStatus();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatus(this.thirdTransaction.getStatus()).iterator();

        for (int i = 0; i < this.orderedDescByAmountTransactionsWithSameStatus.length; i++) {
            assertEquals(orderedDescByAmountTransactionsWithSameStatus[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }


    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowOnEmpty() {
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowOnNullStatus() {
        this.seedBlock();
        this.chainblock.getAllSendersWithTransactionStatus(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowOnNoTransactionsWithThatStatus() {
        this.seedBlock();
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnOneTransaction() {
        this.seedBlock();
        Iterator<String> actual = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();

        assertEquals(this.defaultTransaction.getSender(), actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnMultipleSortedDescTransactionS() {
        this.seedWithSameStatus();
        Iterator<String> actual = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();

        for (int i = 0; i < this.orderedDescByAmountTransactionsWithSameStatus.length; i++) {
            assertEquals(this.orderedDescByAmountTransactionsWithSameStatus[i].getSender(), actual.next());
        }

        assertFalse(actual.hasNext());
    }


    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowOnEmpty() {
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowOnNullStatus() {
        this.seedBlock();
        this.chainblock.getAllReceiversWithTransactionStatus(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowOnNoTransactionsWithThatStatus() {
        this.seedBlock();
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnOneTransaction() {
        this.seedBlock();
        Iterator<String> actual = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();

        assertEquals(this.defaultTransaction.getReceiver(), actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnMultipleSortedDescTransactionS() {
        this.seedWithSameStatus();
        Iterator<String> actual = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL).iterator();

        for (int i = 0; i < this.orderedDescByAmountTransactionsWithSameStatus.length; i++) {
            assertEquals(this.orderedDescByAmountTransactionsWithSameStatus[i].getReceiver(), actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnEmptyForEmpty() {
        assertFalse(this.chainblock.getAllOrderedByAmountDescendingThenById().iterator().hasNext());
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnSortedByAmount() {
        this.seedWithSameStatus();

        Iterator<Transaction> actual = this.chainblock.getAllOrderedByAmountDescendingThenById().iterator();

        for (int i = 0; i < orderedDescByAmountTransactionsWithSameStatus.length; i++) {
            assertEquals(orderedDescByAmountTransactionsWithSameStatus[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnSortedByAmountAndId() {
        this.seedNotOrderedByAmountAndIdDesc();

        Iterator<Transaction> actual = this.chainblock.getAllOrderedByAmountDescendingThenById().iterator();

        for (int i = 0; i < this.orderedByAmountAndIdBothDesc.length; i++) {
            assertEquals(this.orderedByAmountAndIdBothDesc[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowOnEmpty(){
        this.chainblock.getBySenderOrderedByAmountDescending(DEFAULT_SENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowOnNullSender(){
        this.seedBlock();
        this.chainblock.getBySenderOrderedByAmountDescending(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowOnNoSuchSender(){
        this.seedBlock();
        this.chainblock.getBySenderOrderedByAmountDescending("Not in the collection");
    }

    @Test
    public void getBySenderOrderedByAmountDescendingShouldReturnSender(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getBySenderOrderedByAmountDescending(defaultTransaction.getSender()).iterator();
        assertEquals(this.defaultTransaction, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getBySenderOrderedByAmountDescendingShouldReturnMultipleSendersSorted(){
        this.seedNotOrderedByAmountWithSameSenders();
        Iterator<Transaction> actual = this.chainblock.getBySenderOrderedByAmountDescending(defaultTransaction.getSender()).iterator();

        for (int i = 0; i < this.orderedDescByAmountWithSameSenders.length; i++) {
            assertEquals(this.orderedDescByAmountWithSameSenders[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowOnEmpty(){
        this.chainblock.getByReceiverOrderedByAmountThenById(defaultTransaction.getReceiver());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowOnNullReceiver(){
        this.seedBlock();
        this.chainblock.getByReceiverOrderedByAmountThenById(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowOnNoSuchReceiver(){
        this.seedBlock();
        this.chainblock.getByReceiverOrderedByAmountThenById("No such receiver");
    }

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldReturnReceiver(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getByReceiverOrderedByAmountThenById(this.defaultTransaction.getReceiver()).iterator();

        assertEquals(this.defaultTransaction, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldReturnMultipleReceiversSorted(){
        this.seedNotOrderedByAmountWithSameReceivers();
        Iterator<Transaction> actual = this.chainblock.getByReceiverOrderedByAmountThenById(this.defaultTransaction.getReceiver()).iterator();

        for (int i = 0; i < this.orderedByAmountWithSameReceiversDescAndIdAsc.length; i++) {
            assertEquals(this.orderedByAmountWithSameReceiversDescAndIdAsc[i], actual.next());
        }
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyForNullStatus(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(null, 100).iterator();
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyForNegativeAmount(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, -10).iterator();
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyForEmpty(){
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 100).iterator();
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyForNoSuchStatus(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 100).iterator();
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyForNullNoSuchAmount(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 10).iterator();
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnOneTransactionEdge(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 20).iterator();
        assertEquals(defaultTransaction, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnMultipleTransactions(){
        this.seedNotOrderedByAmountWithSameSenders();
        Iterator<Transaction> actual = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 40).iterator();

        for (int i = 2; i < this.orderedDescByAmountWithSameSenders.length; i++) {
            assertEquals(this.orderedDescByAmountWithSameSenders[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowOnEmpty(){
        this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_SENDER, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowOnNoSuchSender(){
        this.seedBlock();
        this.chainblock.getBySenderAndMinimumAmountDescending("No such sender", 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowOnNullSender(){
        this.seedBlock();
        this.chainblock.getBySenderAndMinimumAmountDescending(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowOnNoNegativeAmount(){
        this.seedBlock();
        this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_SENDER, -50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowOnNoTransactionsWithThisAmount(){
        this.seedBlock();
        this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_SENDER, 550);
    }

    @Test
    public void getBySenderAndMinimumAmountDescendingShouldReturnOneTransaction(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_SENDER, 0).iterator();

        assertEquals(this.defaultTransaction, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getBySenderAndMinimumAmountDescendingShouldReturnMultipleTransactionsEdgeSortedDescAmount(){
        this.seedNotOrderedByAmountWithSameSenders();
        Iterator<Transaction> actual = this.chainblock.getBySenderAndMinimumAmountDescending(DEFAULT_SENDER, 30).iterator();

        for (int i = 0; i < this.orderedDescByAmountWithSameSenders.length - 1; i++) {
            assertEquals(this.orderedDescByAmountWithSameSenders[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowOnEmpty(){
        this.chainblock.getByReceiverAndAmountRange(DEFAULT_RECEIVER, 0, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowOnNullReceiver(){
        this.seedBlock();
        this.chainblock.getByReceiverAndAmountRange(null, 0, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowOnNoSuchReceiver(){
        this.seedBlock();
        this.chainblock.getByReceiverAndAmountRange("NO SUCH RECEIVER", 0, -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowOnNegativeLower(){
        this.seedBlock();
        this.chainblock.getByReceiverAndAmountRange(DEFAULT_RECEIVER, -50, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowOnNegativeHigher(){
        this.seedBlock();
        this.chainblock.getByReceiverAndAmountRange(DEFAULT_RECEIVER, 0, -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowInvalidLower(){
        this.seedBlock();
        this.chainblock.getByReceiverAndAmountRange(DEFAULT_RECEIVER, 10, 0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowOnNoTransactionsInRange(){
        this.seedNotOrderedByAmountWithSameReceivers();
        this.chainblock.getByReceiverAndAmountRange(DEFAULT_RECEIVER, 100, 400);
    }

    @Test
    public void getByReceiverAndAmountRangeShouldReturnOneTransactionOnLowerEdge(){
        this.seedNotOrderedByAmountWithSameReceivers();
        Iterator<Transaction> actual = this.chainblock.getByReceiverAndAmountRange(DEFAULT_RECEIVER, 30, 35).iterator();

        assertEquals(this.orderedByAmountWithSameReceiversDescAndIdAsc[3], actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getByReceiverAndAmountRangeShouldReturnOneTransactionOnHigherEdge(){
        this.seedNotOrderedByAmountWithSameReceivers();
        Iterator<Transaction> actual = this.chainblock.getByReceiverAndAmountRange(DEFAULT_RECEIVER, 30, 40).iterator();

        assertEquals(this.orderedByAmountWithSameReceiversDescAndIdAsc[3], actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyOnEmpty(){
        assertFalse(this.chainblock.getAllInAmountRange(0, 200).iterator().hasNext());
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyOnNoTransactionsNotInRange(){
        this.seedBlock();
        assertFalse(this.chainblock.getAllInAmountRange(100, 200).iterator().hasNext());
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyOnNoNegativeLower(){
        this.seedBlock();
        assertFalse(this.chainblock.getAllInAmountRange(-10, 40).iterator().hasNext());
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyOnNoNegativeHigher(){
        this.seedBlock();
        assertFalse(this.chainblock.getAllInAmountRange(10, -40).iterator().hasNext());
    }

    @Test
    public void getAllInAmountRangeShouldReturnOneTransactionInLowerEdge(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getAllInAmountRange(20, 21).iterator();

        assertEquals(defaultTransaction, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getAllInAmountRangeShouldReturnOneTransactionInHigherEdge(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getAllInAmountRange(21, 40).iterator();

        assertEquals(secondTransaction, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void getAllInAmountRangeShouldReturnMultipleTransactions(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.getAllInAmountRange(0, 100).iterator();

        for (int i = 0; i < this.defaultTransactions.length; i++) {
            assertEquals(this.defaultTransactions[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void getIteratorShouldReturnEmptyOnEmpty(){
        assertFalse(this.chainblock.iterator().hasNext());
    }

    @Test
    public void getIteratorShouldReturnElements(){
        this.seedBlock();
        Iterator<Transaction> actual = this.chainblock.iterator();

        for (int i = 0; i < this.defaultTransactions.length; i++) {
            assertEquals(this.defaultTransactions[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    private void seedBlock() {
        this.chainblock.add(defaultTransaction);
        this.chainblock.add(secondTransaction);
        this.chainblock.add(thirdTransaction);
    }

    private void seedNotOrderedByAmountAndIdDesc() {
        for (int i = 0; i < notOrderedByAmountAndIdBothDesc.length; i++) {
            this.chainblock.add(notOrderedByAmountAndIdBothDesc[i]);
        }
    }

    private void seedNotOrderedByAmountWithSameSenders() {
        for (int i = 0; i < notOrderedByAmountWithSameSenders.length; i++) {
            this.chainblock.add(notOrderedByAmountWithSameSenders[i]);
        }
    }

    private void seedNotOrderedByAmountWithSameReceivers() {
        for (int i = 0; i < notOrderedByAmountWithSameReceiversDescAndIdAsc.length; i++) {
            this.chainblock.add(notOrderedByAmountWithSameReceiversDescAndIdAsc[i]);
        }
    }

    private void seedWithSameStatus() {
        for (int i = 0; i < this.notOrderedByAmountWithSameStatus.length; i++) {
            this.chainblock.add(notOrderedByAmountWithSameStatus[i]);
        }
    }

}
