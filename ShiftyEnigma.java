/***************************************************************
* File:  ShiftyEnigma.java
* Larry Tafoya  
* tafoya87513@gmail.com
* Inheritance, Polymorphism, Interfaces, Packages, and Enigma classes
****************************************************************/

/*Shifty encoding scheme: Each character in the message (after 
 * it has been key-shifted) is converted to its ASCII value. The 
 * value is subtracted from 1000, resulting in a triplet of numbers. 
 * Each digit of the triplet is then converted to the symbolic value 
 * on the keyboard above the numbers 1 – 0. The string of symbols is 
 * the encoded message. For example, if the character’s value is 37, 
 *it is subtracted from 1000, resulting in a triplet of 963. 
 *The corresponding keyboard characters are (^#.*/  

package EnigmaMachine;

public class ShiftyEnigma extends EnigmaClass {
    
    private String codedMessage;
    private int localKey;
    private final String[] charShifts;
    private final String numShifts;
    
    
    public ShiftyEnigma() {
        
        //super() used to refer to parent object
        super();
        this.codedMessage = "";
        this.localKey = 0;
        charShifts = new String[10];
        
        //use charShifts[], numShifts for code and decode
        charShifts[0] = ")";
        charShifts[1] = "!";
        charShifts[2] = "@";
        charShifts[3] = "#";
        charShifts[4] = "$";
        charShifts[5] = "%";
        charShifts[6] = "^";
        charShifts[7] = "&";
        charShifts[8] = "*";
        charShifts[9] = "(";
        
        numShifts = ")!@#$%^&*(";
    }//end constructor
    
    public void shiftyEncode() {      
        
        //create parallel arrays to code nums/chars triplets
        String[] shiftyNums = new String[this.codedMessage.length()];
        String[] shiftyChars = new String[this.codedMessage.length()];
        
        //use stringBuilder to create triplets
        StringBuilder shiftyCodeBuilder = new StringBuilder("aaa");
        
        for(int i = 0; i < this.codedMessage.length(); ++i) {   
            
            //get shifty value of char, 1000 - asciiValue
            int shiftyValue = 1000 - (int)this.codedMessage.charAt(i);
            
            //store shifty triplet value into array, ie 963
            shiftyNums[i] = Integer.toString(shiftyValue);
            
            //loop for 3 to index through shiftyNums[], get
            //corresponding shifty chars
            for(int k = 0; k < 3; ++k) {
                
                //get int value then convert to shifty char
                int getNum = Character.getNumericValue(shiftyNums[i].charAt(k));
                
                //get corresponding char from charShifts[]
                char charFromShifts = charShifts[getNum].charAt(0);
                
                //use shiftyDecodeBuilder to build shifty triplet ie (^#
                shiftyCodeBuilder.setCharAt(k, charFromShifts);
            }
            //put char triplet int shiftyChars[]
            shiftyChars[i] = shiftyCodeBuilder.toString();
        }//end for loop
        
        //use newCodedMessage to build coded message by combining
        //all char triplets
        StringBuilder newCodedMessage = new StringBuilder();
        
        for(int i = 0; i < this.codedMessage.length(); ++i) {
            
            newCodedMessage.append(shiftyChars[i]);
        }
        
        //put new shifty code into codedMessage
        this.codedMessage = newCodedMessage.toString();
    }//end shiftyEncode
    
    public void shiftyDecode() {
        
        //create a string builder to build decoded shifty message
        StringBuilder shiftyDecodeBuilder = new StringBuilder("aaa");
        
        
        //create parallel arrays to decode nums/chars triplets
        String[] shiftyNums = new String[this.codedMessage.length()/3];
        String[] shiftyChars = new String[this.codedMessage.length()/3];
        
        //ints for logic used to break coded message into triplets
        int arrayCounter = 0;
        int builderCounter = 0;
        
        //break coded message into segments of 3, store in array
        for(int i = 0; i < this.codedMessage.length(); ++i) {
            
            //use string builder to put char triplets into shiftyChars
            shiftyDecodeBuilder.setCharAt(builderCounter, this.codedMessage.charAt(i));
            ++builderCounter;
            
            //use buildCounter % 3 to segment codedMessage by 3 at a time to store
            //in shiftyChars
            if (builderCounter % 3 == 0) {
                
                shiftyChars[arrayCounter] = shiftyDecodeBuilder.toString();
                ++arrayCounter;
                builderCounter = 0;
            }
        }
        
        //convert char triplets to int triplets
        //for loop to traverse array
        for(int i = 0; i < this.codedMessage.length()/3; ++i) {
            
            //for loop to traverse chars in array
            for(int k = 0; k < 3; ++k) {
                
                //get int corresponding to char from numShifts string ie 2==@
                String tempNum = Integer.toString(numShifts.indexOf(shiftyChars[i].charAt(k)));
                //set shiftyInt in builder ie "243"
                shiftyDecodeBuilder.setCharAt(k, tempNum.charAt(0));
            }
            //add builder to shiftyNums array
            shiftyNums[i] = shiftyDecodeBuilder.toString();
        }
        
        //decode int triplet into corresponing ascii char
        StringBuilder decodedMessage = new StringBuilder();
        for(int i = 0; i < this.codedMessage.length()/3; ++i) {
            //get original ascii value
            int asciiValue = 1000 - Integer.parseInt(shiftyNums[i]);
            decodedMessage.append((char)asciiValue);
        }
        
        //set decoded string into this.codedMessage
        this.codedMessage = decodedMessage.toString();                       
    }//end shiftyDecode
    
     //override toString for the writeFile
    @Override
     public String toString() {
         
        String results;            
        results = this.codedMessage + System.getProperty("line.separator") 
                    + this.localKey + System.getProperty("line.separator") + 2;
            
        return results;
    }//end toString()
     
    //override setMessage w/random key
    @Override
    public void setMessage(String m) {
        
        super.setMessage(m);
        this.codedMessage = super.getCodedMessage();
        this.localKey = super.getKey();
        shiftyEncode();        
    }
    
    //override setMessage w/user chosen key
    @Override
    public void setMessage(String m, int k) {
        
        super.setMessage(m, k);
        this.codedMessage = super.getCodedMessage();
        this.localKey = super.getKey();
        shiftyEncode();
    }
            
    //override setCodedMessage for decode
    @Override
    public void setCodedMessage(String cm, int k) {
        
        this.codedMessage = cm;
        this.localKey = k;
        shiftyDecode();
        super.setCodedMessage(this.codedMessage, this.localKey);
    }
            
    //override for getters
    @Override
    public String getCodedMessage(){return this.codedMessage;}
    @Override
    public int getKey(){return this.localKey;}
}//end ShiftyEnigma.java