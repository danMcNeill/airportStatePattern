package airportSecurityState;

import java.io.File;

public class SecurityFactors {

	private AirportStateI lr;
	private AirportStateI mr;
	private AirportStateI hr;

	private AirportStateI state;

	private int days;
	private int badItems;
	private int travellers;

	public SecurityFactors() {
		lr = new LOW_RISK(this);
		mr = new MODERATE_RISK(this);
		hr = new HIGH_RISK(this);
		days = 0;
		badItems = 0;
		travellers = 0;
		state = lr;
		MyLogger.writeMessage("SecurityFactors constructor called.", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @return nothing
	 * calls tightenOrLoosen on currents state to decide which state to be in
	 */
	public void tightenOrLoosenSecurity() {
		state.tightenOrLoosenSecurity();
	}

	/**
	 * @return nothing
	 * sets state to new state
	 */
	public void setState(AirportStateI newState) {
		state = newState;
	}

	/**
	 * @return State object representing current state
	 */
	public AirportStateI getState() {
		return state;
	}

	/**
	 * @return low risk State object
	 */
	public AirportStateI getLowRiskState() {
		return lr;
	}

	/**
	 * @return moderate risk State object
	 */
	public AirportStateI getModerateRiskState() {
		return mr;
	}

	/**
	 * @return high risk state object
	 */
	public AirportStateI getHighRiskState() {
		return hr;
	}

	/**
	 * @return nothing
	 * sets days variable to new value
	 */
	public void setDays(int newDays) {
		days = newDays;
	}

	/**
	 * @return days variable
	 */
	public int getDays() {
		return days;
	}

	/**
	 * @return nothing
	 * sets badItems variable to new value
	 */
	public void setBadItems(int b) {
		badItems = b;
	}

	/**
	 * @return badItems variable
	 */
	public int getBadItems() {
		return badItems;
	}

	/**
	 * @return nothing
	 * sets travellers variable to new value
	 */
	public void setTravellers(int trav) {
		travellers = trav;
	}

	/**
	 * @return travellers variable
	 */
	public int getTravellers() {
		return travellers;
	}

	/**
	 * @return nothing
	 * processes inout file and deals with new travellers
	 */
	public void insertInfo(String inputFile, Results results) {

		File input = new File(inputFile);
		if(!input.isFile()) { // file does not exist
			System.err.println("Input file specified does not exist. Exiting.");
			System.exit(1);
		}
		String s;
		int tempInt = 0;
		FileProcessor fp = new FileProcessor(input);
		while((s = fp.readLine()) != null) {
			state.insertInput(s);
			state.tightenOrLoosenSecurity();
			
			results.storeNewResult(state.operations());
		}

		fp.closeFile();




	}

}
