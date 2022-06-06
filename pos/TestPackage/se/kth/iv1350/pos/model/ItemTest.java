package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest 
{
	Item testItem;
	
	String testIdentifier = "IV1350 is a fun course";
	String testName = "Way more fun than IX1303";
	String testDescription = "Math < Programming";
	float testPrice = 10f;
	int testAmount = 0;
	float testVAT = 25f;
	
	@BeforeEach 
	/*
	 * Might be better to use BeforeAll to avoid having to create a new item every test. Also might be better to use the same item
	 * so if any get() function impacts another variable we'd notice. But in this case I'll just stick to BeforeEach because it's
	 * just simple get and set testing for this class.
	 */
	void setUp() throws Exception 
	{
		testItem = new Item(testIdentifier, testName, testDescription, testPrice, testAmount, testVAT);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testItem = null;
		testAmount = 0;
	}

	@Test
	void testGetIdentifier() 
    {
		if(!testItem.getIdentifier().equals(testIdentifier))
		{
			fail("The identifier given to a testItem was not returned in the getIdentifier() function");
		}
		
    }
	@Test
    void testGetName()
    {
		if(!testItem.getName().equals(testName))
		{
			fail("The name given to a testItem was not returned in the getName() function");
		}
    }
	@Test
    void testGetItemDescription() 
    {
		if(!testItem.getItemDescription().equals(testDescription))
		{
			fail("The item description given to a testItem was not returned in the getItemDescription() function");
		}
    }
	@Test
    void testGetPrice() 
    {
		if(testItem.getPrice() != (testPrice))
		{
			fail("The price given to a testItem was not returned in the getPrice() function");
		}
    }
	@Test
    void testGetAmount()
    {
		if(testItem.getAmount() != (testAmount))
		{
			fail("The amount given to a testItem was not returned in the getAmount() function");
		}
    }
	@Test
    void testSetAmount()
    {
		testAmount = 4;
		testItem.setAmount(testAmount);
		if(testItem.getAmount() != (testAmount))
		{
			fail("Using the setAmount() function of the testItem did not set the items amount correctly");
		}
    }
	@Test
    void testUpAmountByOne()
    {
		testAmount = 2;
		testItem.setAmount(testAmount);
		testItem.upAmountByOne();
		if(testItem.getAmount() != (testAmount + 1))
		{
			fail("The function for upping the amount of the testItem did not increase the item's amount by the correct amount");
		}
		
    }
	@Test
    void testGetVATRate() 
    {
		if(testItem.getVATRate() != (testVAT))
		{
			fail("The getVATRate() function of the testItem did not return the correct VAT rate.");
		}
    }

}
