package data;

import java.io.Serializable;

import eu.qualiMaster.data.inf.IFinancialData;

public class FinancialData implements Serializable, IFinancialData{

	private String symbol;
	private float quotes;
	private int volume;
	private String timestamp;
	
	/**
	 * 
	 * @param symbol
	 * @param quotes
	 * @param volume
	 * @param timestamp
	 */
	public FinancialData(String symbol, float quotes, int volume, String timestamp) {
		super();
		this.symbol = symbol;
		this.quotes = quotes;
		this.volume = volume;
		this.timestamp = timestamp;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public float getQuotes() {
		return quotes;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
		
	public String getSpringData() {
		String itemDataString = this.getSymbol() + "," + this.getQuotes() + "," + this.getVolume() + "," + this.getTimestamp();
		return itemDataString;
	}
	
	@Override
	public void setSymbol(String symbol) {
		this.symbol = symbol;
		
	}

	@Override
	public void setQuotes(float quotes) {
		this.quotes = quotes;
		
	}

	@Override
	public void setVolume(int volume) {
		this.volume = volume;
		
	}

	@Override
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
		
	}
	
}
