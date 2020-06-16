
public class SuperCipher extends BaseCipher {
//This makes a super cipher where diffrent ciphers were put into one super cipher
	
	private BaseCipher[] cipherArray;
	
	public SuperCipher(BaseCipher[] cipherArray) { //constructor
		super("SuperCipher");
		this.cipherArray=cipherArray;
	}
	
	public boolean isValid() { //checks if all the ciphers in the array are valid
		for(int i=0; i<cipherArray.length; i++) {
			if(cipherArray[i] instanceof CaesarCipher && !cipherArray[i].isValid()) {
				return false;
			}
		}
		return true;
	}
	
	public String encrypt(String message){ // ecnrtypts the message with all the ciphers 
		
		for(int i=0; i<cipherArray.length; i++) {
			message=cipherArray[i].encrypt(message);
			}
		return message;
		}
	
	public String decrypt(String message){ // decrtypts the message with all the ciphers
		for(int i=cipherArray.length - 1; i>=0; i--) {
			message=cipherArray[i].decrypt(message);
			}
		return message;
		}
	
	public String toString() //prints out the ciphers with SuperCipher is made out of
	{
		String message="SuperCipher(";
		
		for(int i=0; i<cipherArray.length; i++) {
			message+=cipherArray[i].toString();
			if(i!=cipherArray.length-1)
			{
				message+=" | ";
			}
		}
		
		return message+ ")";
	}
	
	
	public boolean equals(Object other) {//chcekcs if two super ciphera are equal
        if (other == this) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other instanceof SuperCipher) {
        	SuperCipher cipher = (SuperCipher) other;
        	if(cipherArray.length!=cipher.cipherArray.length)
        	{
        		return false;
        	}
            for(int i=0; i<cipherArray.length; i++) {
    			if(!cipher.cipherArray[i].toString().equals(this.cipherArray[i].toString()))
    			{
    				return false;
    			}
    		}
            return true;
        } else {
            return false;
        }
    }
	
}
