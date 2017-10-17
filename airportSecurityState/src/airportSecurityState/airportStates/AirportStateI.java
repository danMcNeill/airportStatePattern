package airportSecurityState;


public interface AirportStateI {

	public void tightenOrLoosenSecurity();
	public void setSecurityFactors(SecurityFactors s);
	public SecurityFactors getSecurityFactors();


}
