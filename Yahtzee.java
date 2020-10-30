public class Yahtzee
{

	private Die[] dice;
	private int [] counts;

	public Yahtzee ()
	{
		dice = new Die[ 5 ];
		for ( int i = 0 ; i < 5 ; i++)
		{
			dice[i] = new Die();
		}
		counts = new int [6];
		
		rollAllDice();
	}

	public void rollADie (int dieNumber)
	{
		int value = getADie(dieNumber);
		if(value == 0){
			 dice[dieNumber-1].roll();
			 value = getADie(dieNumber);
			counts[value-1]++;
		}else{
			counts[value-1]--;
			dice[dieNumber-1].roll();
			value = getADie(dieNumber);
			counts[value-1]++;
		}
		
	}

	public void rollAllDice ()
	{
		for ( int i = 0 ; i < 5 ; i++)
		{
			counts[i] = 0 ;
		}		

		for ( int i = 1 ; i <= 5 ; i++)
		{
			 rollADie(i);
		}
		updateCounts ();
	}

	public int getADie ( int dieNumber)
	{
		return  dice[dieNumber-1].getValue();
	}

	public String showDice ()
	{

		String dislplayDies = "+------+---+---+---+---+---+\n";
		
		String numStrring ="";
		for ( int i = 1 ; i <= 5 ; i++)
		{
			 numStrring += " " + i + " |"; 
		}
		dislplayDies        +=	"| Dice |" + numStrring +   "\n";
		dislplayDies        +=  "+------+---+---+---+---+---+\n";
		String diesValueStr ="";
		for ( int i = 1 ; i <= 5 ; i++)
		{
			 diesValueStr += " " + getADie(i) + " |"; 
		}
		dislplayDies        +=	"| Face |" + diesValueStr + "\n";
		dislplayDies        +=	"+------+---+---+---+---+---+\n";
		return dislplayDies;
	}



	private int countUp ( int value)
	{
		return counts[value-1];
	}


	private void updateCounts ()
	{
		for ( int i = 0 ; i < 6 ; i++)
		{
		counts[i] = countUp(i + 1 );
//		System.out.println( "Number of " + (i + 1 ) + "s rolled: " +counts[i]);
		}
	}



	public int getScoreOnes ()
	{
		return counts[0]*1;
	}

	public int getScoreTwos ()
	{
		return counts[1]*2;
	}

	public int getScoreThrees ()
	{
		return counts[2]*3;
	}

	public int getScoreFours ()
	{
		return counts[3]*4;
	}

	public int getScoreFives ()
	{
		return counts[4]*5;
	}

	public int getScoreSixes ()
	{
		return counts[5]*6;
	}




	public int getScoreThreeOfAKind ()
	{
		int value=0;
		for(int i = 0 ; i < 6 ; i++)
		{
			if(counts[i]==3)
			{
				value =  getScoreOnes() + getScoreTwos () +getScoreThrees () +  getScoreFours () + getScoreFives () + getScoreSixes ();  
			}
		}
		return value;

	}

	public int getScoreFourOfAKind ()
	{
		int value=0;
		for(int i = 0 ; i < 6 ; i++)
		{
			if(counts[i]==4){
				value =  getScoreOnes() + getScoreTwos () +getScoreThrees () +  getScoreFours () + getScoreFives () + getScoreSixes ();
				}
		}
		return value;

	}

	public int getScoreFullHouse ()
	{
		int value=0;
		for(int i = 0 ; i < 6 ; i++)
		{
			if(counts[i]==3)
			{
				for(int j = 0 ; j < 6 ; j++)
				{
						if(counts[j]==2)
						{
							value =  25;
						}
				}
				 
			}
		}
		return value;
	}

	public int getScoreSmallStraight ()
	{
		
		int value=0;
		for(int i = 0 ; i < 6 ; i++)
		{
			if(counts[i] == 2)
			{
				 for(int j = i+1  ; j < 6 ; j++)
					{
						if(counts[j] >= 2)
							return value;
					}
			}
			
			if(counts[i] > 2)
			{
				 return value ;
			}
		}
		
		if(counts[2] !=0 && counts[3] != 0   )
		{
				value=30;
				 return value ;
		}
		

		return value;
	}

	public int getScoreLargeStraight ()
	{
		int value=0;
		for(int i = 0 ; i < 6 ; i++)
		{
			if(counts[i] >= 2)
			{
				 return value ;
			}
		}
		
		if(counts[1] ==1 && counts[2] ==1 && counts[3] ==1 && counts[4] ==1 )
		{
				value=40;
				 return value ;
		}
		

		return value;
	}

	public int getScoreChance ()
	{
		int value =  getScoreOnes() + getScoreTwos () +getScoreThrees () +  getScoreFours () + getScoreFives () + getScoreSixes (); 
		return value;

	}

	public int getScoreYahtzee ()
	{
		int value=0;
		for(int i = 0 ; i < 6 ; i++)
		{
			if(counts[i]==5){
				value =  50;
				}
		}
		return value;
	}


	public String getScoreCard ()
	{
		String scoreCard = showDice()  + "\n\n";
		scoreCard += "           Ones: " +  getScoreOnes() + "\n";
		scoreCard += "           Twos: " +  getScoreTwos() + "\n";
		scoreCard += "         Threes: " +  getScoreThrees() + "\n";
		scoreCard += "          Fours: " +  getScoreFours() + "\n";
		scoreCard += "          Fives: " +  getScoreFives() + "\n";
		scoreCard += "          Sixes: " +  getScoreSixes() + "\n\n";

		scoreCard +=" Three of a Kind: " + getScoreThreeOfAKind() + "\n";
		scoreCard +="  Four of a Kind: " +  getScoreFourOfAKind() + "\n";
		scoreCard +="      Full House: " + getScoreFullHouse() + "\n";
		scoreCard +="  Small Straight: " + getScoreSmallStraight() + "\n";
		scoreCard +="  Large Straight: " + getScoreLargeStraight() + "\n";
		scoreCard +="          Chance: " +  getScoreChance() + "\n";
		scoreCard +="         Yahtzee: " + getScoreYahtzee() + "\n";

		return scoreCard;
	}

}