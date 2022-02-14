package services;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.exceptions.InsufficientFundsException;

import static org.testng.Assert.*;

public class SavingAccountTest {
    Customer customer;
    SavingAccount customerAccount;
    @BeforeClass
    public void oneTimeSetup()
    {
        customer = new Customer("Micky Mouse","Cairo", "miky@email.com");
    }
    @BeforeMethod
    public void eachTimeSetup()
    {
        customerAccount = new SavingAccount(5436, 100, customer);
    }
    @DataProvider(name="validAmountData")
    private Object[][] createValidAmountTestData()
    {
        return new Object[][] {{50,50}, {60,40}};
    }
    @Test(dataProvider = "validAmountData")
    public void testWithDrawValidAmount(double amount, double expectedBalance) throws InsufficientFundsException {
        customerAccount.withDraw(amount);
        Assert.assertEquals(   customerAccount.getBalance() , expectedBalance);
    }
    @Test
    public void testWithDrawInvalidAmount() throws InsufficientFundsException {
        try {
            customerAccount.withDraw(200);
            fail("Expected that the balance is smaller than the amount required");
        }
        catch (InsufficientFundsException insufficientFundsException)
        {
            Assert.assertEquals(customerAccount.getBalance() , 100);
        }
    }
}