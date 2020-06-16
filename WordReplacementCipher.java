


public class WordReplacementCipher extends BaseCipher {
	//Subclass of Baseclass that encrypts a message to with WordReplacment Cipher
	//Changes messages by changing a certain given word or slogan into another
	
	private String replace;
	private String current;
	
	public WordReplacementCipher(String current, String replace) //Constructor
	{
		super("EvenOddCipher");
		this.current=current;
		this.replace=replace;
	}
	
	public String encrypt(String message) {
		//Enctrypts by replacing all the words
		return message.replaceAll(current, replace);
	}
	
	public String decrypt(String message) {
		//Dectrypts by replacing all the words
		return message.replaceAll(replace, current);
	}
	
	public String toString() //Prints the name of cipher and its words it is replacing and the one the ciphers is replacing it with
	{
		return "WordReplacementCipher(" + this.current + ", " + this.replace + ")";
	}
	
	public boolean equals(Object other)//Checks if two ciphers are equal
	{
		if(this == other)
		{
			return true;
		} else if (other== null) {
			return false;
		} else if(other instanceof WordReplacementCipher) {
			WordReplacementCipher cipher= (WordReplacementCipher) other;
			return cipher.current==this.current && cipher.replace==this.replace;
		} else {
			return false;
		}
	}
}
