package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import eu.qualiMaster.data.inf.IFinancialData;

public class FinancialDataGenerator {
	private static float MIN_QUOTE=1;
	private static float MAX_QUOTE=500;
	private static int MIN_VOLUME=1;
	private static int MAX_VOLUME=1000;
	private static int SYMBOL_NUM=5;	
	
	public static IFinancialData getFinancialData() {	
		String[] symbolList={"Forex International","Madrid","IDC Poland","Euronext","Borsa Italiana"};
		Random random = new Random();
        int randomSymInt = random.nextInt(4);
        String symbol=symbolList[randomSymInt];
        float randomQuote=random.nextFloat() * (MAX_QUOTE - MIN_QUOTE) + MIN_QUOTE;
        int randomVolume=MIN_VOLUME + (int)(Math.random()*((MAX_VOLUME-MIN_VOLUME) + 1));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();       
		IFinancialData financialdata=new FinancialData(symbol,randomQuote,randomVolume, dateFormat.format(cal.getTime()));
		return financialdata;
	}
}
