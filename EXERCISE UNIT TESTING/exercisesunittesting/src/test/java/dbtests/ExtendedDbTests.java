package dbtests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class ExtendedDbTests {

    Database validDb;

    @Before
    public void createValidDb() throws OperationNotSupportedException {
        validDb = new Database(new Person(1, "Pesho"));
    }



    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnFindByUsernameWithNoSuchUsername() throws OperationNotSupportedException {
        validDb.findByUsername("NOT IN THE DB");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnUsernameNull() throws OperationNotSupportedException {
        validDb.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldNotReturnUserByNameCaseSensetive() throws OperationNotSupportedException {
        validDb.findByUsername("PeShO");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnNegativeId() throws OperationNotSupportedException {
        validDb.findById(-10);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnInvalidId() throws OperationNotSupportedException {
        validDb.findById(100);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnNotUniqueIdAdd() throws OperationNotSupportedException {
        validDb.add(new Person(1, "Invalid User"));
    }
}
