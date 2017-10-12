package airportSecurityState;


public class LOW_RISK implements AirportStateI {

	private SecurityFactors sf;

	public LOW_RISK(SecurityFactors s) {
		sf = s;
	}

	public void tightenOrLoosenSecurity(int operation) {

		if(!operation) { // tighten
			sf.setState(sf.getModerateState());
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
