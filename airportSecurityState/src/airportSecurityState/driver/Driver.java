package airportSecurityState;


public class Driver {

	public static void main(String[] args) {

		if((args.size() != 3) || args[0].equals("${arg1}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
			System.err.println("Must specify all three arguments: <input file> <output file> <Logger number>");
			System.exit(0);
		}

		MyLogger.setDebugValue(Integer.parseInt(args[2]));
		
		



	}

}
