/***************************************************************
* File:  TexasEnigma.java
* Larry Tafoya  
* tafoya87513@gmail.com
* Inheritance, Polymorphism, Interfaces, Packages, and Enigma classes
****************************************************************/

/*Texas encoding scheme: In this encoding scheme, make two more passes 
 *to add shifts with different values on each of the letters in the message 
 *(after it has been Enigma key-shifted). The first pass starts at the 
 *beginning of the codedMessage and goes to the end.  At position 0, the shift 
 *is +1, at position 1, the shift is -2. The shift value alternates positive 
 *and negative values and the numbers added increase by 1 for each position in 
 *the string.  If the resulting value > 126, wrap around to 32.  If the value is 
 *less than 32, wrap around to 126. The second pass adds numbers running from  
 *codedMessage.length() to the end starting from the end of the codedMessage 1. 
 *ie +3 +2 +1 for "aaa". Continue to wrap using the same rules.*/

package EnigmaMachine;

public class TexasEnigma extends EnigmaClass {
    
    private String codedMessage;
    private int localKey;
    
    
    public TexasEnigma() {
        
        //super() used to refer to parent object
        super();
        this.codedMessage = "";
        this.localKey = 0;
    }//end constructor
    
    public void texasEnigmaEncode() {
        
        //create a string builder w/message put in constructor
        StringBuilder texasCodeBuilder = new StringBuilder(this.codedMessage);
        
        //create int for logic
        int passCounter = 1;
        
        
        //for loop for first pass
        for(int i = 0; i < this.codedMessage.length(); ++i) {
        
            //get asciiValue from corresponding char
            int asciiValue =  (int)texasCodeBuilder.charAt(i);
            
            //use % 2 to shift char with corresponing - or + value
            if(i % 2 == 0) {                          
                
                //shift asciiValue up by passCounter
                asciiValue += passCounter;
                
                //use wrap() to ensure asciiValue is valid 32-126
                asciiValue = wrap(asciiValue);
                
                //put shifted value into builder
                texasCodeBuilder.setCharAt(i, (char)asciiValue);
                
                ++passCounter;
            }
            else {
            
                //shift asciiValue up by passCounter
                asciiValue -= passCounter;
                
                //use wrap() to ensure asciiValue is valid 32-126
                asciiValue = wrap(asciiValue);
                
                //put shifted value into builder
                texasCodeBuilder.setCharAt(i, (char)asciiValue);
                ++passCounter;
            }
        }//end for loop
        
        //create int for logic
        int secondPassShift = this.codedMessage.length();
        
        //for loop for second pass
        for(int i = 0; i < this.codedMessage.length(); ++i) {
            
            //get asciiValue from char
            int asciiValue =  (int)texasCodeBuilder.charAt(i);
            
            //shift asciiValue by secondPassShift
            asciiValue += secondPassShift;
            
            //use wrap() to ensure asciiValue is valid 32-126
            asciiValue = wrap(asciiValue);
            
            //put shifted value into builder
            texasCodeBuilder.setCharAt(i, (char)asciiValue);
            
            //decrement for next char's shift
            --secondPassShift;
        }//end for loop
        
        //convert string builder to string and put in codedMessage
        this.codedMessage = texasCodeBuilder.toString();
    }//end texasEnigmaEncode
    
    public void texasEnigmaDecode() {
    
        //create a string builder w/message put message in constructor
        StringBuilder texasDecodeBuilder = new StringBuilder(this.codedMessage);
        
        //create int for logic
        int secondPass = this.codedMessage.length();
        
        //for loop for secondPass decode
        for(int i = 0; i < this.codedMessage.length(); ++i) {
            
            //get asciiValue from char
            int asciiValue =  (int)texasDecodeBuilder.charAt(i);
            
            //shift asciiValue by secondPassShift
            asciiValue -= secondPass;
            
            //use wrap() to ensure asciiValue is valid 32-126
            asciiValue = wrap(asciiValue);
            
            //put shifted value into builder
            texasDecodeBuilder.setCharAt(i, (char)asciiValue);
            
            //decrement for next char's shift
            --secondPass;
        }//end for loop
        
        //create int for logic
        int passCounter = 1;
        
        //for loop for first pass decode
        for(int i = 0; i < this.codedMessage.length(); ++i) {
            
            //get asciiValue from corresponding char
            int asciiValue =  (int)texasDecodeBuilder.charAt(i);
        
            //use % 2 to code char with corresponing - or + value
            if(i % 2 == 0) {
            
                //shift asciiValue up by passCounter
                asciiValue -= passCounter;
                
                //use wrap() to ensure asciiValue is valid 32-126
                asciiValue = wrap(asciiValue);
                
                //put shifted value into builder
                texasDecodeBuilder.setCharAt(i, (char)asciiValue);
                
                //increment passCounter
                ++passCounter;
            }
            else {
            
                //shift asciiValue up by passCounter
                asciiValue += passCounter;
                
                //use wrap() to ensure asciiValue is valid 32-126
                asciiValue = wrap(asciiValue);
                
                //put shifted value into builder
                texasDecodeBuilder.setCharAt(i, (char)asciiValue);
                
                //increment passCounter
                ++passCounter;
            }
        }//end for loop
        
        //convert string builder to string and put in codedMessage
        this.codedMessage = texasDecodeBuilder.toString();
    }//end texasEnigmaDecode
    
    //override toString for the writeFile
    @Override
     public String toString() {
         
        String results;           
        results = this.codedMessage + System.getProperty("line.separator") 
                    + this.localKey + System.getProperty("line.separator") + 0;
            
        return results;
    }//end toString()
        
    //override setMessage w/random key
    @Override
    public void setMessage(String m) {
        
        super.setMessage(m);
        this.codedMessage = super.getCodedMessage();
        this.localKey = super.getKey();
        texasEnigmaEncode();
    }
                
    //override setMessage w/user chosen key
    @Override
    public void setMessage(String m, int k) {
        
        super.setMessage(m, k);
        this.codedMessage = super.getCodedMessage();
        this.localKey = super.getKey();
        texasEnigmaEncode();
    }
            
    //override setCodedMessage for decode
    @Override
    public void setCodedMessage(String cm, int k) {
        
        this.codedMessage = cm;
        this.localKey = k;
        texasEnigmaDecode();
        super.setCodedMessage(this.codedMessage, this.localKey);
    }
          
    //override for getters
    @Override
    public String getCodedMessage(){return this.codedMessage;} 
    @Override
    public int getKey(){return this.localKey;}
}//end TexasEnigma.java