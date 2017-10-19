package airportSecurityState;


public class Driver {

	public static void main(String[] args) {

		if((args.length != 3) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
			System.err.println("Must specify all three arguments: <input file> <output file> <Logger number>");
			System.exit(1);
		}

		int bug = 0;

		try {
			bug = Integer.parseInt(args[2]);
		}
		catch(NumberFormatException n) {
			System.err.println(args[2] + " is not a valid integer. Exiting.");
			System.exit(1);
		}

		if((bug > 4) || (bug < 0)) {
			System.err.println("Debug value must be integer in range 0-4. Exiting.");
			System.exit(1);
		}

		MyLogger.setDebugValue(bug);
		
		SecurityFactors context = new SecurityFactors();

		Results results = new Results();

		try {
		context.insertInfo(args[0], results);
		}
		catch(Exception e) {
			System.err.println(e.toString());
			e.printStackTrace();
			System.exit(1);
		}

		results.writeToFile(args[1]);

	}

}
