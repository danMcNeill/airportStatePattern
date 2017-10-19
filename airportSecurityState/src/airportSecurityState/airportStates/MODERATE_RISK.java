package airportSecurityState;


public class MODERATE_RISK implements AirportStateI {

	private SecurityFactors sf;

	public MODERATE_RISK(SecurityFactors s) {
		sf = s;
		MyLogger.writeMessage("MODERATE_RISK constructor called.", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @return nothing
	 * insert new line of input
	 */
	public void insertInput(String line) {
		String[] semiColons = line.split(";");
	
		String[] dayArray = semiColons[0].split(":");
		String[] itemArray = semiColons[3].split(":");

		int newDaysValue = Integer.parseInt(dayArray[1]);
		if(newDaysValue != sf.getDays()) {
			sf.setDays(newDaysValue);
			MyLogger.writeMessage("New day: " + newDaysValue, MyLogger.DebugLevel.NEWDAY);
		}

		sf.setTravellers(sf.getTravellers() + 1);

		String item = itemArray[1];
		if(item.equals("Gun") || item.equals("NailCutter") || item.equals("Blade") || item.equals("Knife")) {
			sf.setBadItems(sf.getBadItems() + 1);
			MyLogger.writeMessage("New bad item: " + item, MyLogger.DebugLevel.NEWBADITEM);
		}

	}

	/**
	 * @return nothing
	 * changes state if conditions are met to do such
	 */
	public void tightenOrLoosenSecurity() {

		int numTrav = sf.getTravellers();
		int days = sf.getDays();
		int items = sf.getBadItems();
		int avgTraffic = numTrav / days;
		int avgItems = items / days;

		if((avgTraffic < 4) && (avgItems < 1)) {
			sf.setState(sf.getLowRiskState());
			MyLogger.writeMessage("State changed from MODERATE_RISK to LOW_RISK.", MyLogger.DebugLevel.STATECHANGE);
			return;
		}

		if((avgTraffic >= 8) || (avgItems >= 2)) {
			sf.setState(sf.getHighRiskState());
			MyLogger.writeMessage("State changed from MODERATE_RISK to HIGH_RISK.", MyLogger.DebugLevel.STATECHANGE);
			return;
		}

	}

	/**
	 * @return nothing
	 * setter for SecurityFactors var
	 */
	public void setSecurityFactors(SecurityFactors s) {
		sf = s;
	}

	/**
	 * @return SecurityFactors object with this state
	 */
	public SecurityFactors getSecurityFactors() {
		return sf;
	}

	/**
	 * @return String consisting of operations associated with this state
	 */
	public String operations() {
		return "2 3 5 8 9";
	}

}
