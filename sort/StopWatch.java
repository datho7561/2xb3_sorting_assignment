package sort;

/**
 * A ADT for timing the execution of code,
 * @author David Thompson
 */
public class StopWatch {

	private long begin, end;
	
	/**
	 * Make a enw StopWatch. Note that it starts taking time immediately
	 */
	public StopWatch() {
		begin = System.currentTimeMillis();
		end = -1;
	}
	
	/**
	 * Stop the stopwatch. This means that the runtime will be calculating
	 * time elapsed using this as the end point.
	 */
	public void tock() {
		end = System.currentTimeMillis();
	}
	
	/**
	 * Get how long the StopWatch ran for in millis as a long.
	 * @return A long representing the runtime of the StopWatch in millis
	 */
	public long getRuntimeMillis() {
		if (end < 0) return System.currentTimeMillis() - begin;
		return end - begin;
	}
	
	/**
	 * Get how long the StopWatch ran for in seconds as a double.
	 * @return A double representing the runtime of the StopWatch in seconds
	 */
	public double getRuntimeSeconds() {
		if (end < 0) return (System.currentTimeMillis() - begin)/1000.0;
		return (begin - end)/1000.0;
	}
	
}
