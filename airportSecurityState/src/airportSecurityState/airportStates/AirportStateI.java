package airportSecurityState;


public interface AirportStateI {

	// operation will be 0 if tightening, 1 if loosening
	public void tightenOrLoosenSecurity(int operation);

	public void newTraveller();

	public void newProItem();


}
