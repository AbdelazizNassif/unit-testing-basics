package services;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomerTest {
    /*
    Given: I create a new customer
    When: I init their info
    Then: their info should be stored
     */
    @Test
    public void createCustomerWithValidData_checkSpecificData() {
        Customer customer = new Customer("Micky Mouse" , "Maadi, Cairo" , "mix@disney.com");
        Assert.assertNotNull(customer);
        Assert.assertEquals(customer.getName(), "Micky Mouse");
        Assert.assertEquals(customer.getAddress(), "Maadi, Cairo");
        Assert.assertEquals(customer.getEmail(), "mix@disney.com");
    }

    @Test
    public void updateCustomerWithValidData_checkCustomerDataIsUpdated() {
        Customer customer = new Customer("Micky Mouse" , "Maadi, Cairo" , "mix@disney.com");
        customer.setName("Minnie Mouse");
        customer.setAddress("Zayed, Cairo");
        customer.setEmail("Minnie@disney.com");
        Assert.assertNotNull(customer);
        Assert.assertEquals(customer.getName(), "Minnie Mouse");
        Assert.assertEquals(customer.getAddress(), "Zayed, Cairo");
        Assert.assertEquals(customer.getEmail(), "Minnie@disney.com");
    }

}