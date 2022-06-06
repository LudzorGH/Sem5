package se.kth.iv1350.pos.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.integration.ExternalInventorySystem;
import se.kth.iv1350.pos.integration.InvalidItemIdentifierException;
import se.kth.iv1350.pos.model.Item;
import se.kth.iv1350.pos.model.Sale;

class ControllerTest {

	private ExternalInventorySystem testInventory; //This is for direct accessing items for comparing to the items the controller returns
	private Controller testController;
	private Sale testSale;
	private Item testItem;
	private String testIdentifier = "0004";
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testController = new Controller();
		testController.startSale();
		testInventory = new ExternalInventorySystem();
		testSale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testController = null;
		testSale = null;
		testItem = null;
	
	}

	@Test
	void testItemRetrieval() 
	{
		
		try 
		{
			testItem = testInventory.getItem(testIdentifier);
			testSale.addItemToSale(testItem);
			
			String testInventoryString = "\nAdded " + testItem.getName() + " to cart." +
					"\n  VAT: " + testItem.getVATRate() + "%" +
					"\n  Description: '" + testItem.getItemDescription() + "'" +
					"\n  Price: $" + testItem.getPrice() +
					"\n  Amount: " + testItem.getAmount() + 
					"\nRunning Total: $" + testSale.getRunningTotal();
			if(!testInventoryString.equals(testController.scanItem(testIdentifier, 1)))
			{
				fail("The information returned after adding an item did not equal the expected String.");
			}
		}
		catch (InvalidItemIdentifierException invalidIdentifierException)
		{
			fail("An invalidIdentifierException was thrown by the testInventory during a test of the controller item retrieval");
		}
		
	}
	
	@Test
	void testRunningTotalRetrieval()
	{
		try 
		{
			testItem = testInventory.getItem(testIdentifier);
			testSale.addItemToSale(testItem);
			double expectedPrice = testSale.getRunningTotal();
			
			testController.scanItem(testIdentifier, 1);
			if(expectedPrice != testController.endSale())
			{
				fail("The price returned by the testController did not match the expected price for the testSale");
			}
			
		}
		catch (InvalidItemIdentifierException invalidIdentifierException)
		{
			fail("An invalidIdentifierException was thrown by the testInventory during a test of the controller end sale");
		}
	}

}
