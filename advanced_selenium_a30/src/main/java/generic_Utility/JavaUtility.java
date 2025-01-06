package generic_Utility;

import java.util.Random;

public class JavaUtility
{

	public static int generateRandomNumer() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
}
