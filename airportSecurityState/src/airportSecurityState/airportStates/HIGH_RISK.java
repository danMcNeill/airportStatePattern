package airportSecurityState;


public class HIGH_RISK implements AirportStateI {

	private SecurityFactors sf;

	public HIGH_RISK(SecurityFactors s) {
		sf = s;
		MyLogger.writeMessage("HIGH_RISK constructor called.", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void tightenOrLoosenSecurity() {


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
