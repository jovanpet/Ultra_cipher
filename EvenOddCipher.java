
public class EvenOddCipher extends BaseCipher {
	//Subclass of Baseclass that encrypts a message to with EvenOdd Cipher
	//Changes messages by organizing letters by their parity. First even then odd.
	
	public EvenOddCipher() {
		//Contractor
		super("EvenOddCipher");
	}

	public String encrypt(String message) {
		//Function that encrypts the whole message
		String encrypted="";
		for(int i=0; i<message.length(); i=i+2) { //Puts first the letters on even location into the secret message
			encrypted+=message.charAt(i);
		}
		for(int i=1; i<message.length(); i=i+2) { //After puts the letters on odd locations into the secret message
			encrypted+=message.charAt(i);
		}
		
		return encrypted;
	}
	
	public String decrypt(String message) { //Function that decrypts the secret message
		String decrypted="";
		int len;
		
		if(message.length()%2==0) { //finds where the odd and the even are devided
			len=message.length()/2;
		}
		else {
			len=message.length()/2  + 1;
		}
		for(int i=0; i<len; i++) { //sorts the letters back by in each cycle adding one even and one odd
			
			decrypted+=message.charAt(i);
			
			if((i+len)<message.length()) {
				decrypted+=message.charAt(i+len);
			}
		}
		return decrypted;
	}
	
	public String toString() //Prints the name of cipher
	{
		return "EvenOddCipher";
	}
	
	public boolean equals(Object other) //Checks if two ciphers are equal
	{
		if(this == other)
		{
			return true;
		} else if(other instanceof EvenOddCipher) {
			return true;
		} else {
			return false;
		}
	}
}
