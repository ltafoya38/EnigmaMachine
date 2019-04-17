/***************************************************************
* File:  EnigmaClass.java
* Larry Tafoya  
* tafoya87513@gmail.com
* Inheritance, Polymorphism, Interfaces, Packages, and Enigma classes
****************************************************************/

/*Enigma encoding scheme: Each char in a message is converted to it's 
corresponding ascii value. Then that value is added to the key. After, the
resulting sum is converted to it's corresponding char.*/

package EnigmaMachine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EnigmaClass implements EnigmaInterface{
    
        //class variables
    	private String message;
	private String codedMessage;
	private int key;

	public EnigmaClass() {
            
		key = 1;
                message = "";
                codedMessage ="";
	}//end constructor
        
        //used to keep char shifts in valid range 32-126
        public int wrap(int w) {
            
            int asciiValue = w;
            
            //if asciiValue is > 126 wrap around so vaule is 32 - 126
            if(asciiValue > 126) {
                
                asciiValue -= 126;
                asciiValue += 31;
                return asciiValue;
            }
            
            //if asciiValue is < 32 wrap around so value is 32 - 126
            if(asciiValue < 32) {
                
                asciiValue = 32 - asciiValue;
                asciiValue = 127 - asciiValue;
                return asciiValue;
            }
            
            return asciiValue;
        }//end wrap()
        
        //intial key shift happens here
	private void encode() {
            
            //create a string builder w/message put message in constructor
            StringBuilder codedMessageBuilder = new StringBuilder(message);
            
            //for loop to traverse the message
            for(int i = 0; i < message.length(); ++i) {
                
                // get asciiValue to be enigma shifted
                int asciiValue =  (int)codedMessageBuilder.charAt(i);
                
                //shift the asciiVale by adding the key value
                asciiValue += key;
                
                //wrap the asciiValue so that value is 32-126
                asciiValue = wrap(asciiValue);
                
                //set shifted char into builder
                codedMessageBuilder.setCharAt(i, (char)asciiValue);
            }//end for loop
		
            //convert string builder to string, set into codedMessage
            codedMessage = codedMessageBuilder.toString();
	}//end encode()

	private void decode() {
           
            //create string builder object with coded message
            StringBuilder decodedMessageBuilder = new StringBuilder(codedMessage);
            
            //for loop to traverse message
            for(int i = 0; i < codedMessage.length(); ++i) {
                
                 //get asciiValue to be enigma shifted
                int asciiValue = (int)decodedMessageBuilder.charAt(i);
                
                //shift asciiValue by key
                asciiValue -= key;
                
                //use wrap() to ensure asciiValue is valid 32-126
                asciiValue = wrap(asciiValue);
            
                //set shift char into builder
                decodedMessageBuilder.setCharAt(i, (char)asciiValue);
            }//end for loop
            
            //convert string builder to string set into message
            message = decodedMessageBuilder.toString();
	}
        
        //setMeassage w/ random key
        @Override
	public void setMessage(String m) {
            
            //determine a randon # for key 1 - 50
            key = (int)(50.0 * Math.random() + 1);                
            message = m;
            encode();
	}

        //setMessage w/ user key
        @Override
	public void setMessage(String m, int k){
                        
            message = m;
            key = k;	
            encode();
	}

        //setCodedMessage for decode process
        @Override
	public void setCodedMessage(String cm, int k){
		codedMessage = cm;
		key = k;
		decode();
	}
        
        //getters
        @Override
        public String getCodedMessage() {return codedMessage;}
        @Override
        public String getDecodedMessage() {return message;} 
        @Override
        public int getKey() {return key;}
        
       /* //create string for the writeFile
        @Override
        public String toString(){
            String results = "";
            
            results = codedMessage + System.getProperty("line.separator") + key;
            
            return results;
        }*/
        
        //writeFile method try with resources
        public void writeFile(File file) throws IOException {
        FileWriter fstream = new FileWriter(file);
            try (BufferedWriter out = new BufferedWriter(fstream)) {
                out.write(this.toString());
            }
        }

}
