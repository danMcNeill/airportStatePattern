package airportSecurityState;


public class LOW_RISK implements AirportStateI {

	private SecurityFactors sf;

	public LOW_RISK(SecurityFactors s) {
		sf = s;
		MyLogger.writeMessage("LOW_RISK constructor called.", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * @return nothing
	 * changes state if conditions indicate to do so
	 */
	public void tightenOrLoosenSecurity() {

		if(((sf.getTravellers() / sf.getDays()) >= 4) || ((sf.getBadItems() / sf.getDays()) >= 1)) {
			sf.setState(sf.getModerateRiskState());
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
