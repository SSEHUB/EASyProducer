package spring;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.util.Vector;

import org.apache.thrift7.TException;








import data.FinancialData;
import data.Symbol;



/**
 * 
 * Class template to handle TCP/IP data connection
 * 
 */
public class DataConnector extends Thread {

	public static final String SERVER_IP = "83.169.11.157";// Quote Server IP
	public static final int SERVER_Port = 9003; // Quote Server Port

	private boolean running = false;
	private Socket tcpSocket = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;
	public static final int OK = 0;
	public static final int NO_INTERNET = 1;
	public static final int CONNECTION_ERROR = 2;
	private String userName = "";
	private QuoteInterface quote;
	public boolean sending = false;
    private FinancialData financialData;
	public DataConnector(QuoteInterface quote) {
		this.quote = quote;
	}

	/**
	 * connect to server using socket connection
	 * 
	 * @return Returns connection status, one of DataConnector.OK,
	 *         DataConnector.NO_INTERNET, DataConnector.CONNECTION_ERROR
	 */
	public int connect() {
		try {
			tcpSocket = new Socket(SERVER_IP, SERVER_Port);
			out = new DataOutputStream(new BufferedOutputStream(
					tcpSocket.getOutputStream()));
			in = new DataInputStream(new BufferedInputStream(
					tcpSocket.getInputStream()));

			running = true;
			start();
			return OK;
		} catch (NoRouteToHostException e) {
			System.out.println(e);
			return NO_INTERNET;
		} catch (IOException e) {
			System.out.println(e);
			return CONNECTION_ERROR;

		}

	}

	/**
	 * Run method of the extended Thread class, to read server response stream
	 */
	@Override
	public void run() {

		while (running) {
			if (!sending && tcpSocket != null && in != null) {

				try {
					StringBuilder response = new StringBuilder();
					int c;
					while (in != null && (c = in.read()) != -1) {
						response.append((char) c);
						if ((char) c == '!') {// All messages are separated by
												// '!'
							break;
						}

					}

					resolveResponse(response.toString());
				} catch (Exception ex) {
					System.err
							.println("Server read error : " + ex.getMessage());
				}
			}

		}
		System.out.println("< Server response reader stopped >");

	}

	/*
	 * Login to server with username and password
	 */
	public void login(String username, String pw) throws IOException {
		sendData(username + ",login," + pw + "!");
		this.userName = username;
		DataOutputController.init();
	}

	/**
	 * Request server to send symbols list
	 * 
	 * @throws IOException
	 */
	public void getSymbols() throws IOException {
		sendData(userName + ",quotelist!");

	}

	/**
	 * Request server to start quotes for symbol
	 * 
	 * @param Object
	 *            symbol - The Object symbol to send to server
	 * @throws IOException
	 */
	public void startQuote(Symbol symbol) throws IOException {
		String request = userName + ",orderquote,";

		sendData(request, false);
		sendSymbol(symbol);
		System.out.println("sent data : " + request + symbol + "!");

	}

	/**
	 * Request server to to stop quotes for symbol
	 * 
	 * @param Object
	 *            symbol - The Object symbol to send to server
	 * @throws IOException
	 */
	public void stopQuote(Symbol symbol) throws IOException {
		String request = userName + ",cancelquote,";
		sendData(request, false);
		sendSymbol(symbol);
		System.out.println("sent data : " + request + symbol + "!");
	}

	/**
	 * Request server to to start depth for symbol
	 * 
	 * @param Object
	 *            symbol - The Object symbol to send to server
	 * @throws IOException
	 */
	public void startDepth(Object symbol) throws IOException {
		String request = userName + ",orderdepth,";
		sendData(request, false);
		sendSymbol(symbol + "");
		System.out.println("sent data : " + request + symbol + "!");
	}

	/**
	 * Request server to to stop depth for symbol
	 * 
	 * @param Object
	 *            symbol - The Object symbol to send to server
	 * @throws IOException
	 */
	public void stopDepth(Object symbol) throws IOException {
		String request = userName + ",canceldepth,";
		sendData(request, false);
		sendSymbol(symbol + "");
		System.out.println("sent data : " + request + symbol + "!");
	}

	/**
	 * private method to only send symbol data to server (this method invoke
	 * from an other method inside this class)
	 * 
	 * @param String
	 *            symbol - The String symbol to send to server
	 * @throws IOException
	 */
	private void sendSymbol(String symbol) throws IOException {

		if (out != null && symbol != null && !symbol.trim().isEmpty()) {

			symbol = symbol.trim();
			String ar[] = symbol.split("·");
			out.writeBytes(ar[0]);
			out.write(183);
			out.writeBytes(ar[1]);
			out.write(183);
			out.writeBytes(ar[2]);
			out.writeBytes("!");
			out.flush();

		}
	}
	
	private void sendSymbol(Symbol symbol) throws IOException {

		if (out != null && symbol != null ) {

			out.writeBytes(symbol.getFullname());
			out.write(183);
			out.writeBytes(symbol.getShortname());
			out.write(183);
			out.writeBytes(symbol.getExtension());
			out.writeBytes("!");
			out.flush();

		}
	}

	/**
	 * return financial data from this class
	 * @return
	 */
	public FinancialData getFinancialData() {
		return financialData;
	}
	
	/**
	 * Send data to server
	 * 
	 * @param String
	 *            line - The String line to send to server
	 * @throws IOException
	 */
	public void sendData(String line) throws IOException {
		sendData(line, true);
	}

	/**
	 * Send data to server and prints sent data in the standard output (command
	 * line)
	 * 
	 * @param line
	 *            - The String line to send to server
	 * @param print
	 *            - Whether it should print in the command line, or not
	 * @throws IOException
	 */
	public void sendData(String line, boolean print) throws IOException {
		// All messages are separated by '!'

		if (out != null) {
			out.writeBytes(line);
			out.flush();
			if (print)
				System.out.println("sent data : " + line);
		}
	}

	/**
	 * Decide the actions for the received response from the server
	 * 
	 * @param String
	 *            response- The response line received from server
	 * @throws TException 
	 * @throws NumberFormatException 
	 */
	private void resolveResponse(String response) throws NumberFormatException, TException {
		if (response == null) {
			return;
		}

		if (response.replace("!", "").trim().isEmpty()) {
			return;
		}
		response = response.trim();
		if (response.toUpperCase().startsWith("LOGIN,")) {
			quote.enableLoginComp(!(response.toUpperCase()
					.contains("LOGGED IN") && !response.toLowerCase().contains(
					"already")));
			quote.log(response);
		} else if (response.toUpperCase().startsWith("ORDERQUOTE,")) {

			quote.log("SERVER:" + response);
			// /counter++;
		} else if (response.toUpperCase().startsWith("QUOTELIST,")) {

			response = response.substring(10);
			String lines[] = response.split("\n");
			Vector list = new Vector();
			for (int i = 0; i < lines.length; i++) {
				if (lines[i] != null) {
					String line = lines[i];
					String data[] = line.split("\\|");
					if (data.length > 3) {
						list.add((data[0] + "·" + data[1] + "·" + data[3]));
					}
				}
			}

			quote.setQuotesList(list, false);
		} else if (response.toUpperCase().startsWith("HEARTBEAT,")) {
			try {
				sendData(userName + ",heartbeatanswer,!");
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		} else if (response.toUpperCase().startsWith("QUOTE,")) {
			System.out.println(response);
			String ar[] = response.split(",");
			if (ar.length > 7) {
				String line = ar[6] + "," + ar[7] + "," + ar[4] + "," + ar[5];
				String splitSymbol[]=ar[1].split("·");
				Symbol symbol=new Symbol(splitSymbol[0],splitSymbol[1],splitSymbol[2]);
				String symbolString = splitSymbol[0]+","+splitSymbol[1]+","+splitSymbol[2];
				financialData=new FinancialData(symbolString,Float.parseFloat(ar[4]), Integer.parseInt(ar[5]), ar[1] + " " + ar[2]);
				quote.addQuote(symbol + " " + line);
				quote.addQuote(symbolString, ar[6], ar[7], Float.parseFloat(ar[4]), Integer.parseInt(ar[5]));

				if (quote.shouldSaveQuote()) {// Save quote data to file
					String fileName = ar[1];
					try {
						DataOutputController.saveQuoteData(fileName, line);
					} catch (Exception ex) {
						quote.log("Error Writing to File, " + fileName + " : "
								+ ex.getMessage());
					}
				}
			}

		} else if (response.toUpperCase().startsWith("DEPTH,")) {

			String line = response.endsWith("!") ? response.substring(0,
					response.length() - 1) : response;
			quote.addDepth(line);

		} else if (response.toUpperCase().startsWith("ERROR,")) {
			quote.log(response);
		} else {
			System.out.println("got data  : " + response.toString());
			quote.log("SERVER:" + response);
		}

	}

	/**
	 * Stop the server TCP IP connection
	 * 
	 */
	public void stopRunning() {
		running = false;
		try {
			stop();
		} catch (Exception e) {
		}
		try {
			in.close();
			in = null;
		} catch (Exception e) {
		}
		try {
			out.close();
			out = null;
		} catch (Exception e) {
		}
		try {
			tcpSocket.shutdownInput();
		} catch (Exception e) {
		}
		try {
			tcpSocket.shutdownOutput();
		} catch (Exception e) {
		}
		try {
			tcpSocket.close();
		} catch (Exception e) {
		}
	}

}
