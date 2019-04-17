/***************************************************************
* File:  MainP5B.java
* Larry Tafoya  
* tafoya87513@gmail.com
* Inheritance, Polymorphism, Interfaces, Packages, and Enigma classes
****************************************************************/

package EnigmaMachine;

import javax.swing.JFrame;


public class Main {

    //create frame object
    private final MainFrame frame;

    public static void main(String[] args) {
        
        Main app = new Main();
    }
    
    public Main(){
        frame = new MainFrame();
        frame.setTitle("Larry Tafoya's Enigma Machine");
	frame.setSize(500, 500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
