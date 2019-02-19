package sort;

/**
 * An ADT for timing the execution of code.
 * @author David Thompson
 */
public class StopWatch {

	private long begin, end;
	
	/**
	 * Make a StopWatch. Note that it starts taking time immediately
	 */
	public StopWatch() {
		begin = -1;
		end = -1;
	}
	
	/**
	 * Start the stopwatch. Runtime will be calculated from when this
	 * is called.
	 */
	public void tick() {
		begin = System.nanoTime();
		end = -1;
	}
	
	/**
	 * Stop the stopwatch. This means that the runtime will be calculating
	 * time elapsed using this as the end point.
	 */
	public void tock() {
		end = System.nanoTime();
	}
	
	/**
	 * Get how long the StopWatch ran for in nanos as a long.
	 * @return A long representing the runtime of the StopWatch in nanos
	 */
	public long getRuntimeNanos() {
		if (end < 0) return System.nanoTime() - begin;
		return end - begin;
	}
	
	/**
	 * Get how long the StopWatch ran for in seconds as a double.
	 * @return A double representing the runtime of the StopWatch in seconds
	 */
	public double getRuntimeSeconds() {
		if (end < 0) return (System.nanoTime() - begin)/1000000000.0;
		return (begin - end)/1000000000.0;
	}
	
}
