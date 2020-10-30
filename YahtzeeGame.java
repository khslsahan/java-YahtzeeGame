import java.util.Scanner;


public class YahtzeeGame
{
	public static void main (String[] args)
	{
		Scanner scanner = new Scanner(System.in);   
		Yahtzee yahtzee ;
		String userKeep ="";
		 yahtzee = new Yahtzee();
		do{
		 
			
			System.out.println(yahtzee.getScoreCard());
			System.out.print("Enter die number(s) to keep (separated by a space):");
	    		 userKeep = scanner.nextLine();  // Read user input

				 if(userKeep.trim().equals("")){
					  yahtzee = new Yahtzee();
				 }

				 for(int i = 1; i < 6 ;i++ ){
					 	if(!userKeep.contains(""+i))
						 {
							yahtzee.rollADie(i);
						 }
				 }
		}
		while(!userKeep.trim().equals("end") );
		

  		
		 
		
 
		 
	}
}