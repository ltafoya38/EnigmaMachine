/***************************************************************
* File:  PrimeShiftEnigma.java
* Larry Tafoya  
* tafoya87513@gmail.com
* Inheritance, Polymorphism, Interfaces, Packages, and Enigma classes
****************************************************************/

/*Prime Shift encoding scheme: Each character in the message (after it has been 
 *key-shifted) is checked to see if it is a prime number. If it is a prime number, 
 *then check if the key is a prime.   If the key is a prime, shift to the next 
 *prime.  If the key is even, shift to the second prime up, if the key is odd 
 *and not a prime number then shift to the third prime up.  If the number is 
 *not a prime, do nothing. The number 1 is NOT prime, but 2 is. You must be sure 
 *that the shift wraps the values and keeps the character range between 32-126. 
 *If the next (or previous) prime is out of range, wrap it to the next relevant 
 *prime. The numeric values are then converted to a char and that string is the 
 *encoded message. For example, if the character’s value is 37, it is replaced 
 *with 41. If the character is 113, the next prime is 127, but that is out of 
 *range. So it is wrapped back to 37 (the first prime in our range). */

package EnigmaMachine;

public class PrimeShiftEnigma extends EnigmaClass {
    
    private String codedMessage;
    private int localKey;
    private int primes[];
        
    public PrimeShiftEnigma() {
        
        //super() used to refer to parent object
        super();
        this.codedMessage = "";
        this.localKey = 0;
        primes = new int[3];
    }//end constructor
    
    public void primeShiftEncode() {
    
        //create a string builder for new coded message
        StringBuilder primeShiftCodeBuilder = new StringBuilder(this.codedMessage);
        
        //traverse coded message for asciiValueof char's
        for(int i = 0; i < this.codedMessage.length(); ++i){
            
            //get asciiValue of char
            int asciiValue =  (int)primeShiftCodeBuilder.charAt(i);
            
            //call isItPrime to check if asciiValue is prime
            if(isItPrime(asciiValue)) {
                //if true fill array with next three primes
                int x = 0;
                while(x < 3) {
                    //increment asciiValue to find next prime
                    asciiValue += 1;
                    
                    //ensure asciiValue is not out of ascii range using wrap()
                    asciiValue = wrap(asciiValue);
                    
                    //check if newAsciiValue is prime if true store in array
                    if(isItPrime(asciiValue)) {
                        primes[x] = asciiValue;
                        ++x;
                    }
                }//end while loop used to fill array
                
                //check if key is prime
                if(isItPrime(this.localKey)) {
                    //if key is prime shift to next prime
                    primeShiftCodeBuilder.setCharAt(i, (char)primes[0]);
                }
                //now check if key is even
                else if(this.localKey % 2 == 0) {
                    //if key is even shift to 2nd prime
                    primeShiftCodeBuilder.setCharAt(i, (char)primes[1]);
                }
                //final else means key is NOT prime and NOT even
                else {
                    //shift to 3rd prime
                    primeShiftCodeBuilder.setCharAt(i, (char)primes[2]);
                }
            }                  
        }//end for loop
        
        //set codedBuilder into message
        this.codedMessage = primeShiftCodeBuilder.toString();
        
    }//end primeShiftEncode
    
    public void primeShiftDecode() {
    
        //create a string builder w/message put message in constructor
        StringBuilder primeShiftDecodeBuilder = new StringBuilder(this.codedMessage);
        
        
        //for loop to traverse coded message
        for(int i = 0; i < this.codedMessage.length(); ++i) {        
            //get ascii of char
            int asciiValue =  (int)primeShiftDecodeBuilder.charAt(i);
 
            //call isItPrime to check if asciiValue is prime
            if(isItPrime(asciiValue)) {
                
                //if true fill array with previous 3 primes                
                int x = 0;
                while(x < 3) {
                    //decrement asciiValue to find previous prime
                    asciiValue -= 1;
                    
                    //ensure asciiValue is not out of ascii range using wrap()
                    asciiValue = wrap(asciiValue);
                    
                    //check if newAsciiValue is prime if true store in array
                    if(isItPrime(asciiValue)) {
                        primes[x] = asciiValue;
                        ++x;
                    }
                }//end while() used to fill array
                               
                //check if key is prime
                if(isItPrime(this.localKey)) {
                    //if key is prime shift to previous prime
                    primeShiftDecodeBuilder.setCharAt(i, (char)primes[0]);
                }
                //now check if key is even
                else if (this.localKey % 2 == 0) {
                    //if key is even shift to 2nd previous prime
                    primeShiftDecodeBuilder.setCharAt(i, (char)primes[1]);
                }
                //final else means key is NOT prime and NOT even
                else {
                    //shift to 3rd previous prime
                    primeShiftDecodeBuilder.setCharAt(i, (char)primes[2]);
                }           
            }        
        }//end for loop
        
        //set codedBuilder into message
        this.codedMessage = primeShiftDecodeBuilder.toString();
        
    }//end primeShiftDecode
    
    
   
    public boolean isItPrime(int number)
    {
    	int remainder, ctr = 2;
    
		
	//loop from 2 to n-1 and check remainder from modulus division
	//if a number doesn't have a remainder, there is a number
	//that "divides into it", therefore not prime
		
	while(ctr < number){
			
            remainder = number % ctr;
            if(remainder == 0){
                return false;
            }
            
            ctr++;
        }
		
            /*since we divided the number by all values from 2 to n-1,
            and didn't have a 0 remainder, the number is prime.*/
	
            return true;
        }//end isItPrime

    
    //override toString for the writeFile
    @Override
     public String toString() {
         
        String results;           
        results = this.codedMessage + System.getProperty("line.separator") 
                    + this.localKey + System.getProperty("line.separator") + 1;
            
        return results;
    }//end toString()
     
     //override setMessage w/random key
    @Override
    public void setMessage(String m){
        
        super.setMessage(m);
        this.codedMessage = super.getCodedMessage();
        this.localKey = super.getKey();
        primeShiftEncode();
    }
    
    //override setMessage w/user chosen key
    @Override
    public void setMessage(String m, int k){
        
        super.setMessage(m, k);
        this.codedMessage = super.getCodedMessage();
        this.localKey = super.getKey();
        primeShiftEncode();
    }
    
    //override setCodedMessage for decode
    @Override
    public void setCodedMessage(String cm, int k){
        
        this.codedMessage = cm;
        this.localKey = k;
        primeShiftDecode();
        super.setCodedMessage(this.codedMessage, this.localKey);
    }
            
    //override for getters
    @Override
    public String getCodedMessage(){return this.codedMessage;} 
    @Override
    public int getKey(){return this.localKey;}
}//end PrimeShiftEnigma.java