package airportSecurityState;


public class Driver {

	public static void main(String[] args) {

		if((args.size() != 3) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
			System.err.println("Must specify all three arguments: <input file> <output file> <Logger number>");
			System.exit(1);
		}

		try {
			int bug = Integer.parseInt(args[2]);
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

		context.insertTravellers(args[0]);	
		/*	

		File input = new File(inputFile);
		if(!input.isFile()) { // file does not exist
			System.out.println("Input file specified does not exist. Exiting.");
			System.exit(0);
		}
		String s;
		int tempInt = 0;
		FileProcessor fp = new FileProcessor(input);
		while((s = fp.readLine()) != null) {
			try {
				String array[] = s.split(":");
				tempInt = Integer.parseInt(array[0]);
				if(String.valueOf(tempInt).length() != 4)
					continue;
				if(array[array.length-1].length() != 1)
					continue;
				insert(tempInt, array[array.length-1]);
			}
			catch(NumberFormatException n) {
				System.err.println(s + " is not a number, so it was skipped");
				continue;
			}
		}
		fp.closeFile();	}
		*/

}
