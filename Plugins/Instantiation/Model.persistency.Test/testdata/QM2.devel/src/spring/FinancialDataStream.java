package spring;


import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

import org.apache.thrift7.TException;

import data.FinancialData;
import data.Symbol;
import spring.DataConnector;
import spring.QuoteInterface;


public class FinancialDataStream implements QuoteInterface, Serializable{
	
	
	private DataConnector connection;
	
	
	public void connectDataAPI(String username,String password) {
		// TODO Auto-generated method stub

		connection = new DataConnector(this);
	

		int result = connection.connect();
		if (result == DataConnector.OK) {
			System.out.println("SERVER: Connection success");

			try {
				connection.login(username, password);

			} catch (IOException ex) {
				System.out.println("SERVER: Login Error : " + ex.getMessage());
				// JOptionPane.showMessageDialog(this, ex.getMessage(),
				// "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			switch (result) {
			case DataConnector.CONNECTION_ERROR:
				// JOptionPane.showMessageDialog(this, "Connection Error",
				// "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("SERVER: Connection Error");
				break;
			case DataConnector.NO_INTERNET:
				// JOptionPane.showMessageDialog(this,
				// "Connection Error\nCheck your internet connection",
				// "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println("SERVER: Connection Error, Check your internet connection");
				break;
			}
		}
		
		//String symbol = "Borsa Italiana·ENEL               .·NoExpiry";
		Symbol symbol=new Symbol("Borsa Italiana","ENEL               .","NoExpiry");
		try {
			connection.sending = true;
			connection.startQuote(symbol);
		} catch (IOException ex) {
			System.out.println("SERVER: Start Quote " + symbol
					+ " Error, " + ex.getMessage());
		}
		connection.sending = false;
	}

	public DataConnector getConnection(){
		return connection;
	}
	
	@Override
	public void enableLoginComp(boolean enabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void log(String message) {		
		System.out.println(message);	
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setQuotesList(Vector list, boolean clear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addQuote(String quote) {
		// TODO Auto-generated method stub
		System.out.println(quote);		
	}

	@Override
	public void addDepth(String depth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean shouldSaveQuote() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldSaveDepth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addQuote(String symbol,String date, String time, float quotes, int volume) throws TException {
		
		FinancialData financialData=new FinancialData(symbol,quotes,volume,date);
		System.out.println("Get quotes in addQuote:"+financialData.getSymbol()+","+financialData.getQuotes()+","+financialData.getVolume()+","+financialData.getTimestamp());		
		
	}
	




}
