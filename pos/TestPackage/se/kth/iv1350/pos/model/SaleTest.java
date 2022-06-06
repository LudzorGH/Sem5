package se.kth.iv1350.pos.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.model.Item;


class SaleTest {
	private Sale testSale;
	private Item testItem;
	private String testItemsIdentifier = "LEET";
	private String testItemsName = "Cool Test Item";
	private String testItemsDescription = "By tests, for tests";
	private int testItemAmount = 0;
	private float testItemsPrice = 40f;
	private float testItemsVAT = 20f;
	private float expectedPrice;
	private Item anotherTestItem;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		testSale = new Sale();
		//A test item for adding to sales and testing parameters.
		testItem = new Item(testItemsIdentifier, testItemsName, testItemsDescription, testItemsPrice, 0, testItemsVAT);
		testItemAmount = 1;
		
		//This following item is not to be added to the sale for some tests.
		anotherTestItem = new Item("Identifier", "Name", "Description", 123, 0, 50); 

	}

	@AfterEach
	void tearDown() throws Exception 
	{
		testSale = null;
		testItem = null;
		anotherTestItem = null; //This item could be created in the tests where it's required instead for every test
	}

	@Test
	void testAddingOfItemsToSale()
	{
		//First test adds one item, and therefore expects 1 as the return result.
		testSale.addItemToSale(testItem);
		if(testSale.getAmountOfItem(testItem) != 1)
		{
			fail("The sale's function getAmountOfItem() returned the wrong amount of an added item");
		}
		//The second test expects the return result 0, since the item was never added to the sale.
		//testSale.getAmountOfItem(anotherTestItem);
		if(testSale.getAmountOfItem(anotherTestItem) != 0)
		{
			fail("The sale's function getAmountOfItem() returned the wrong amount for an item that wasn't added to the sale");
		}
	}
	
	@Test
	void testPriceCalculation() 
	{
		expectedPrice = testItemsPrice*(1 + testItemsVAT/100);
		
		testSale.addItemToSale(testItem);
		if(expectedPrice != testSale.getRunningTotal())
		{
			fail("The price of the testSale calculated did not equal the price calculated in the test function");
		}
		
	}

}
