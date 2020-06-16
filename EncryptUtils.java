

public class EncryptUtils {
	//This class i meant so we can encrypt and decrypt many strings at once with one cipher
	
	public static String[] encryptMany(BaseCipher cipher, String[] arrayString) {
		//Ecrypts a list of strings with given cipher
		String[] encryptedArray= new String[arrayString.length];
		for(int i=0; i<arrayString.length; i++)
		{
			encryptedArray[i]=cipher.encrypt(arrayString[i]);
		}
		return encryptedArray;
	}
	
	public static String[] decryptMany(BaseCipher cipher, String[] arrayString) {
		//Decrypts a list of strings with given cipher
		String[] decryptedArray= new String[arrayString.length];
		for(int i=arrayString.length -1; i>=0; i--)
		{
			decryptedArray[i]=cipher.decrypt(arrayString[i]);
		}
		return decryptedArray;
	}
}
