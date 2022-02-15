package services;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.exceptions.InsufficientFundsException;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class CheckingAccountTest {
    Customer customer;
    CheckingAccount checkingAccount;

    @Mock
    Check mockCheck;

    @BeforeClass
    public void oneTimeSetup()
    {
        customer = new Customer("Micky Mouse","Cairo", "miky@email.com");

    }
    @BeforeMethod
    public void eachTimeSetup()
    {
        checkingAccount = new CheckingAccount(customer, 250, 5436);
        // this line tell the class that everytime we start, we have to initialize all of our mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testWithDrawValidAmountViaCheck_CheckTheFinalBalance() throws InsufficientFundsException {
        // when getAmount get a call, return 100.0
        when(mockCheck.getAmount()).thenReturn(100.0);
        when(mockCheck.getCheckNumber()).thenReturn(4325);
        checkingAccount.processCheck(mockCheck);
        assertEquals( checkingAccount.getBalance(), 150);
    }

    @Spy
    EmailService spiedEmailService = new EmailService();

    @Test
    public void usingSpy_CheckEmailNotificationIsInvoked() {
        // when getAmount get a call, return 100.0
        when(mockCheck.getAmount()).thenReturn(100.0);
        when(mockCheck.getCheckNumber()).thenReturn(4325);
        spiedEmailService.notify("Processed Check #", "abdz@email.com");
        // check email notification
        verify(spiedEmailService).notify(contains("Processed Check #"), eq("abdz@email.com"));
    }

}