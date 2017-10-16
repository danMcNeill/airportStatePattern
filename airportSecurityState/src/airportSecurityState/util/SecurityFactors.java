package airportSecurityState;


public class SecurityFactors {

	private State lr;
	private State mr;
	private State hr;

	private State state = lr;

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
	public void setState(State newState) {
		state = newState;
	}

	/**
	 * @return State object representing current state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @return low risk State object
	 */
	public State getLowRiskState() {
		return lr;
	}

	/**
	 * @return moderate risk State object
	 */
	public State getModerateRiskState() {
		return mr;
	}

	/**
	 * @return high risk state object
	 */
	public State getHighRiskObject() {
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
	public void insertInfo(String inputFile) {

		File input = new File(inputFile);
		if(!input.isFile()) { // file does not exist
			System.err.println("Input file specified does not exist. Exiting.");
			System.exit(1);
		}
		String s;
		int tempInt = 0;
		FileProcessor fp = new FileProcessor(input);
		while((s = fp.readLine()) != null) {
			try {
				String array[] = s.split(";");
				tempInt = Integer.parseInt(array[0]);
				if(String.valueOf(tempInt).length() != 4)
					continue;
				if(array[array.length-1].length() != 1)
					continue;
				insert(tempInt, array[array.length-1]);
			}
			catch(NumberFormatException n) {
				System.err.println(s + " is not a number, so it was skipped");
				continue;
			}
		}
		fp.closeFile();	}




	}

}
