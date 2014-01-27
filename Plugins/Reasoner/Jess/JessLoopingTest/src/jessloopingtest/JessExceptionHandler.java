package jessloopingtest;
import java.lang.Thread.UncaughtExceptionHandler;


public class JessExceptionHandler implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		System.err.println("Uncaught exception in " + t + ": ");
		e.printStackTrace();
	}

	
}
