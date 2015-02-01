package eu.qualiMaster.data.inf;

/**
*Define the interface for spring financial data.
**/
public interface IFinancialData {

    /**
    *Returns the stock symbol.
    @return the stock symbol
    **/
    public String getSymbol();

    /**
    *Sets the stock symbol.
    @param the stock symbol
    **/
    public void setSymbol(String symbol);

    /**
    *Returns the stock quotes.
    @return the stock quotes
    **/
    public float getQuotes();

    /**
    *Sets the stock quotes.
    @param the stock quotes
    **/
    public void setQuotes(float quotes);

    /**
    *Returns the stock volume.
    @return the stock volume
    **/
    public int getVolume();

    /**
    *Sets the stock volume.
    @param the stock volume
    **/
    public void setVolume(int volume);

    /**
    *Returns the stock timestamp.
    @return the stock timestamp
    **/
    public String getTimestamp();

    /**
    *Sets the stock timestamp.
    @param the stock timestamp
    **/
    public void setTimestamp(String timestamp);

    /**
    *Returns the spring data as a String.
    @return the spring data
    **/
    public String getSpringData();
}
