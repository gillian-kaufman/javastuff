public class decoder
{
	public static void main(String[] args)
	{
		/*Declare variables*/
		char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
						   'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
						   'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		char key[] = {'O', 'J', 'B', 'A', 'S', 'L', 'D', 'M', 'H',
					  'P', 'N', 'K', 'X', 'W', 'Y', 'Q', 'F', 'I',
					  'T', 'R', 'E', 'U', 'G', 'V', 'Z', 'C'};
		
		String ciphertext = "ZYEMOUSOUSIZWYIXOKSOTZQSOBSYLSWDKHTMOWARMSKSRRSILISFESWBHSTOISQISRRZWSOIRYRMSOUSIODSTLYISWDKHTMOWAWYEWBYXXYWSWDKHTMGYIATOISQISTSWRRMSYRMSIRSVRTGHKKWYRJSTYSOTZOWAXOZJSMOIARYAYJISONHWDRMHTBHQMSIJZMOWATMYEKAWYRJSAHLLHBEKRRYAYMYGSUSIRMHTSVSIBHTSOTNTZYERYGIHRSOQIYDIOXRMORORROBNTBHQMSITOERYXORHBOKKZOWAJISONTRMSXGHRMYEROETSIMOUHWDRYPEXQHWOWAXONSOBMOWDSOTHXQKSJIERSLYIBSOQQIYOBMHTWYRWSBSTTOIHKZRMSWHBSTRGOZRYAYWSRMHTRMSRIHBNRYAYHWDRMHTGHKKJSRYASRSBRGMSWRMSTEJTRHRERHYWHTWYRIHDMROWARYLHWAOJSRRSIYWSETHWDRMSLISFESWBHSTRYDEHASZYEDYYAKEBN";
		char message[] = new char[ciphertext.length()];
		
		/*Decode ciphertext and place into char array*/
		for (int i = 0; i < ciphertext.length(); ++i)
		{
			for (int j = 0; j < 26; ++j)
			{
				if (key[j] == ciphertext.charAt(i))
				{
					message[i] = alphabet[j];
					break;
				}
			}
		}
		/*Print out message*/
		for (int i = 0; i < message.length; ++i)
		{
			System.out.print(message[i]);
		}
		/*End of main method*/
	}
	/*End of decoder program*/
}