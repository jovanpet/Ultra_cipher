//Project 2, CSCI 1913, Daniel Kluver
//Jovan Petrovic, 5584954



public class CaesarCipher extends BaseCipher {
//Subclass of Baseclass that encrypts a message to with Caesar Cipher
//Changes letters by moving them *key* amount of places
	
	private int key; //key used to change letters of the message
	
	public CaesarCipher(int key) //constructor
	{
		super("EvenOddCipher");
		this.key=key;
	}
	
	public boolean isValid()  {
		//checks if key used in the cipher is valid
		return key>0 && key<26;
	}
	
	private static char rotate(char letter, int key) {
		//extra function that is used to determine what will be be new char(letter of the message) after encrypting it with key
		
		key=(key+26) % 26;
		
		int letterNum= (int) (letter-'a');
		letterNum=((letterNum+key) %26) + 'a';
		
		char newLetter= (char) letterNum;
		return newLetter;
	}
	
	public String encrypt(String message) {
		//Function that encrypts the whole message
		message=message.toLowerCase();
		
		String encryptedMessage="";
		
		for(int i=0; i<message.length(); i++) {
			if(Character.isLetter(message.charAt(i))) {
				encryptedMessage+=rotate(message.charAt(i),key); //this si where the letters are being encrypted and added to the secret message
			}
			else {
				encryptedMessage+=message.charAt(i);
			}
		}
		return encryptedMessage;
	}
	
	public String decrypt(String message) {
		//Function that decrypts the secret message
		int newKey=-key;
		String encryptedMessage="";
		
		for(int i=0; i<message.length(); i++) {
			if(Character.isLetter(message.charAt(i))) {
				encryptedMessage+=rotate(message.charAt(i),newKey);
			}
			else {
				encryptedMessage+=message.charAt(i);
			}
		}
		return encryptedMessage;
	}
	
	public String toString()
	//Prints the name of cipher and its key
	{
		return "Caesar(" + key + ")";
	}
	
	public boolean equals(Object other)
	{
		//Checks if two ciphers are equal
		if(this == other)
		{
			return true;
		} else if (other== null) {
			return false;
		} else if(other instanceof CaesarCipher) {
			CaesarCipher cipher= (CaesarCipher) other;
			return cipher.key==this.key;
		} else {
			return false;
		}
	}
	
	
}
