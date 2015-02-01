package spring;

import java.util.Vector;

import org.apache.thrift7.TException;

import data.Symbol;
/**
 * 
 * This interface used to handle data between GUI main window and TCP/IP DataController class
 *
 */
public interface QuoteInterface {
	public void enableLoginComp(boolean enabled);

	public void log(String message);

	public void setQuotesList(Vector list,boolean clear);

	public void addQuote(String quote);
	
	public void addQuote(String symbol, String date, String time, float quotes, int volume) throws TException;

	public void addDepth(String depth);

	public boolean shouldSaveQuote();

	public boolean shouldSaveDepth();
}
