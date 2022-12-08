package au.com.jcloud.lxd.util;

public class ProcessWithTimeout extends Thread {
	private Process process;
	private int exitCode = Integer.MIN_VALUE;

	public ProcessWithTimeout(Process process) {
		this.process = process;
	}

	public int waitForProcess(int timeoutMilliseconds) {
		this.start();

		try {
			this.join(timeoutMilliseconds);
		} catch (InterruptedException e) {
			this.interrupt();
		}

		return exitCode;
	}

	@Override
	public void run() {
		try {
			exitCode = process.waitFor();
		} catch (InterruptedException e) {
			throw new RuntimeException("Interrupt for process: " + process + ". " + e);
		} catch (Exception e) {
			throw new RuntimeException("Exception in process: " + process + ". " + e);
		}
	}
}