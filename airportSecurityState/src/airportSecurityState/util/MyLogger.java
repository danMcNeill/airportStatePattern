package airportSecurityState;

public class MyLogger {

	/*Debug value=4 {Print to stdout every time a constructor is called}
	 * Debug value=3 {Print to stdout every time the state is changed}
	 * Debug value=2 {ADD OWN SCHEME}
	 * Debug value=1 {ADD OWN SCHEME}
	 * Debug vlaue=0 {No output should be printed to stdout.
	 */

	public static enum DebugLevel {NOOUTPUT, NEWDAY, NEWBADITEM, STATECHANGE, CONSTRUCTOR};
	private static DebugLevel debugLevel;

	/**
	 * @return nothing
	 * sets the Logger debug level to the specified value, if it is valid
	 */
	public static void setDebugValue(int newLevel) {
		switch(newLevel) {
			case 4: debugLevel = DebugLevel.CONSTRUCTOR;
				break;
			case 3: debugLevel = DebugLevel.STATECHANGE;
				break;
			case 2: debugLevel = DebugLevel.NEWBADITEM;
				break;
			case 1: debugLevel = DebugLevel.NEWDAY;
				break;
			case 0: debugLevel = DebugLevel.NOOUTPUT;
				break;
		}
	}

	/**
	 * @return nothing
	 * sets the Logger debug level to the specified level
	 */
	public static void setDebugValue(DebugLevel newLevel) {
		debugLevel = newLevel;
	}

	/**
	 * @return nothing
	 * writes the specified message only if the debug level matches specified
	 */
	public static void writeMessage(String message, DebugLevel newLevel) {
		if(newLevel == debugLevel)
			System.out.println(message);
	}

	/**
	 * @return String version of DebugLevel
	 */
	public String toString() {
		return "Debug level is " + debugLevel;
	}

}
