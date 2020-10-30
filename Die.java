import java.util.Random;


public class Die
{
	private Random generator ;
	private int value = 0 ;	

	public Die ()
	{
		 generator = new Random();
	}

	public void roll ()
	{
		value = generator.nextInt(6) +1;
	}	

	public int getValue ()
	{
		return value;
	}

}