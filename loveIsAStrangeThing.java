
public class loveIsAStrangeThing {
	public static void wait(int ms)
	{
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	
	public static void main(String[] args) {
		int count = 0;
		int count2= 0;
		while (count<20)
		{
			wait(100);
			System.out.println("I love you at least this much " + count);
			count++;
		}
		while (count<40)
		{
			wait(100);
			System.out.println("uhh wait why is it growing "+count);
			count++;
		}
		while (count<75)
		{
			wait(70);
			System.out.println("Is it getting faster now? "+count);
			count++;
		}
		while (count<120)
		{
			wait(50);
			System.out.println("It is definitely faster "+count);
			count++;
		}
		while (count<180)
		{
			wait(30);
			System.out.println("Oh n o uh how do i slow this down "+count);
			count++;
		}
		while (count<99999)
		{
			wait(30);
			System.out.println("MELTDOWN IMMINENT EVACUATE EVACUATE "+count);
			count+=999;
		}
		while(count2<=100)
		{
			wait(30);
			System.out.println("Love singularity achieved my love for you = ∞");
			count2++;
		}
		System.out.println("SYSTEM ERROR CANNONT COMPUTE RESTARTING");
		wait(5000);
		System.out.println("REBOOTING");
		wait(5000);
		System.out.println("My love for you isnt something quantifiable you are not something that can be calculated");
		wait(5000);
		final String message = " Gillian ";
		final int n = 10;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= 4 * n; j++) {
				double d1 = Math.sqrt(Math.pow(i - n, 2)
									+ Math.pow(j - n, 2));

				double d2 = Math.sqrt(Math.pow(i - n, 2) 
									+ Math.pow(j - 3 * n, 2));

				if (d1 < n + 0.5 || d2 < n + 0.5) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.print(System.lineSeparator());
		}

		for (int i = 1; i < 2 * n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(' ');
			}

			for (int j = 0; j < 4 * n + 1 - 2 * i; j++) {
				if (i >= 2 && i <= 4) {
					int idx = j - (4 * n - 2 * i - message.length()) / 2;
					if (idx < message.length() && idx >= 0) {
						if (i == 3) {
							System.out.print(message.charAt(idx));
						} else {
							System.out.print(' ');
						}
					} else {
						System.out.print('*');
					}
				} else {
					System.out.print('*');
				}
			}
			System.out.print(System.lineSeparator());
			
		}
		System.out.println("I love you sunshine");
	}

}
