package airportSecurityState;


public class MODERATE_RISK implements AirportStateI {

	private SecurityFactors sf;

	public MODERATE_RISK(SecurityFactors s) {
		sf = s;
		MyLogger.writeMessage("MODERATE_RISK constructor called.", MyLogger.DebugLevel.CONSTRUCTOR);
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
			return;
		}

		if((avgTraffic >= 8) || (avgItems >= 2)) {
			sf.setState(sf.getHighRiskState());
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




}
