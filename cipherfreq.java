public class cipherfreq
{
	public static void main(String[] args)
	{
		String ciphertext = "ZYEMOUSOUSIZWYIXOKSOTZQSOBSYLSWDKHTMOWARMSKSRRSILISFESWBHSTOISQISRRZWSOIRYRMSOUSIODSTLYISWDKHTMOWAWYEWBYXXYWSWDKHTMGYIATOISQISTSWRRMSYRMSIRSVRTGHKKWYRJSTYSOTZOWAXOZJSMOIARYAYJISONHWDRMHTBHQMSIJZMOWATMYEKAWYRJSAHLLHBEKRRYAYMYGSUSIRMHTSVSIBHTSOTNTZYERYGIHRSOQIYDIOXRMORORROBNTBHQMSITOERYXORHBOKKZOWAJISONTRMSXGHRMYEROETSIMOUHWDRYPEXQHWOWAXONSOBMOWDSOTHXQKSJIERSLYIBSOQQIYOBMHTWYRWSBSTTOIHKZRMSWHBSTRGOZRYAYWSRMHTRMSRIHBNRYAYHWDRMHTGHKKJSRYASRSBRGMSWRMSTEJTRHRERHYWHTWYRIHDMROWARYLHWAOJSRRSIYWSETHWDRMSLISFESWBHSTRYDEHASZYEDYYAKEBN";
		double[] letterFreq = new double[26]; //holds frequencies of each letter in the ciphertext
		char letter = 'A';

		/* Initialize the array */
		for (int i = 0; i < 26; ++i)
		{
			letterFreq[i] = 0;
		}

		/* Count the usage of each letter and increment respective slot in array */
		for (int i = 0; i < ciphertext.length(); ++i)
		{
			int value = (int)ciphertext.charAt(i) - 65;
			letterFreq[value]++;
		}

		/* Calculate the frequency of each letter */
		for (int i = 0; i < 26; ++i)
		{
			//Get initial frequency
			letterFreq[i] /= ciphertext.length();
			letterFreq[i] *= 100;
			
			//Round to one decimal place
			letterFreq[i] = Math.round(letterFreq[i] * 10) / 10.0;
		}

		/* Output frequency of each letter */
		for (int i = 0; i < 26; ++i)
		{
			System.out.println((letter++) + ": " + letterFreq[i]);
		}
	}
}