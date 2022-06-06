package se.kth.iv1350.pos.integration;

public class ExternalAccountingSystem 
{
	public ExternalAccountingSystem() {}
	
	/**
	 * Logs the sale made
	 */
	public void logSale(String sale)
	{
		/*
		 * This print is not meant for the view, since the accountingsystem wouldn't be able to contact the view.
		 * I'm unsure if you wanted the accountingsystem to show you that it "logs" sales by printing, or if the comment under the print if enough
		 * So I'll just comment out the println beneath. 
		 */
		//System.out.println("Accountingsystem logging sale: \n" + sale);
		//Logging the sale o.O
	}
	
	/**
	 * This method updates the accountingsystem accordingly 
	 */
	public void updateAccountingSystem()
	{
		//Updating the accounting system...
	}
	
}
