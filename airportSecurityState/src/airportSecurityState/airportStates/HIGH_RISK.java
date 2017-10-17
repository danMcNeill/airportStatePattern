package airportSecurityState;


public class HIGH_RISK implements AirportStateI {

	private SecurityFactors sf;

	public HIGH_RISK(SecurityFactors s) {
		sf = s;
		MyLogger.writeMessage("HIGH_RISK constructor called.", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @return nothing
	 * changes state of airport if conditions require such
	 */
	public void tightenOrLoosenSecurity() {

		if(((sf.getTravellers() / sf.getDays()) < 8) && ((sf.getBadItems() / sf.getDays()) < 2)) {
			sf.setState(sf.getModerateRiskState());
			MyLogger.writeMessage("State changed from HIGH_RISK to MODERATE_RISK.", 3);
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


}
