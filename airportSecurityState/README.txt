-----Daniel McNeill README for assign 3 -----


MUST BE IN daniel_mcneill_assign_3/airportSecurityState directory for these commands:



## to clean:
	ant -buildfile src/build.xml clean
## to compile:
	ant -buildfile src/build.xml all
## to run:
	ant -buildfile src/build.xml run -Darg0=(input file) -Darg1=(output file) -Darg2=(debug level)



"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating I will have to sign an official form that I have cheated and that this form will be stored in my official university record. I also understand that I will recieve a grade of 0 for the involved assignment for my first offense and that I will receive a grade of F for the course for any additional offense.
Date: 10/19/17 "


OUTPUT EXPLANATION:
	My program outputs a line of operations after each line of input is processed. So, after the first line of input is processed by the state and the days and items are updated accordingly, tightenOrLoosenSecurity() is called. After this is called and the state is updated, the new current state's operations are outputted.

DATA STRUCTURES:
	This program did not require any data structures. It really just relies on the different state classes and the logic that is asssociated with each state.
