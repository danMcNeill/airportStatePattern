package airportSecurityState;


public class LOW_RISK implements AirportStateI {

	private SecurityFactors sf;

	public LOW_RISK(SecurityFactors s) {
		sf = s;
		MyLogger.writeMessage("LOW_RISK constructor called.", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @return nothing
	 * insert new line of input
	 */
	public void insertInput(String line) {
		try {

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
		catch(Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * @return nothing
	 * changes state if conditions indicate to do so
	 */
	public void tightenOrLoosenSecurity() {

		if(((sf.getTravellers() / sf.getDays()) >= 4) || ((sf.getBadItems() / sf.getDays()) >= 1)) {
			sf.setState(sf.getModerateRiskState());
			MyLogger.writeMessage("State changed from LOW_RISK to MODERATE_RISK.", MyLogger.DebugLevel.STATECHANGE);
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
	 * @return String consisting of operation numbers associated with this state
	 */
	public String operations() {
		return "1 3 5 7 9";
	}

}
