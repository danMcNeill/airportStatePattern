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
	public AirportStateI getHighRiskObject() {
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
			String[] semiColons = s.split(";");

			String[] dayArray = semiColons[0].split(":");
			String[] itemArray = semiColons[3].split(":");

			int newDaysValue = Integer.parseInt(dayArray[1]);
			if(newDaysValue != getDays()) {
				setDays(newDaysValue);
				MyLogger.writeMessage("New day: " + newDaysValue, MyLogger.DebugLevel.NEWDAY);
			}

			setTravellers(getTravellers() + 1);

			String item = itemArray[1];
			if(item.equals("Gun") || item.equals("NailCutter") || item.equals("Blade") || item.equals("Knife")) {
				setBadItems(getBadItems() + 1);
				MyLogger.writeMessage("New bad item: " + item, MyLogger.DebugLevel.NEWBADITEM);
			}

			tightenOrLoosenSecurity();
			/*


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
			*/
		}

		fp.closeFile();




	}

}
