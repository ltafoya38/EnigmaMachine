/***************************************************************
* File:  EnigmaInterface.java
* Larry Tafoya  
* tafoya87513@gmail.com
* Inheritance, Polymorphism, Interfaces, Packages, and Enigma classes
****************************************************************/

package EnigmaMachine;

public interface EnigmaInterface {
    void setMessage(String m);
    void setMessage(String m, int k);
    void setCodedMessage(String m, int k);
    String getCodedMessage();
    String getDecodedMessage();
    int getKey();
}
