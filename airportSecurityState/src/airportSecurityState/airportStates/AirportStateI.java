package airportSecurityState;


public interface AirportStateI {

	public void tightenOrLoosenSecurity();
	public void setSecurityFactors(SecurityFactors s);
	public SecurityFactors getSecurityFactors();
	public void insertInput(String line);
	public String operations();

}
