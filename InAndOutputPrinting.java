package com.company.Testprojekt;

import com.company.Exercises15.Bank;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

/**
 * Created by Tullduvan on 2017-07-07.
 */
public class InAndOutputPrinting {

    public static void main(String[] args)throws InterruptedException {
        Terminal terminal = new SwingTerminal(100, 50);
        terminal.enterPrivateMode();
        int startx=1, starty=1;
        int [] tempx = new int[1000];
        terminal.moveCursor(startx, starty);
        Key key = null;
        String stringInput = "";
        String welcometext = "Hello! this is my successfull IO-console";
        toPrint printing = new toPrint(startx, starty, tempx, terminal);
        printing.WriterTerminal(startx, welcometext);
        while(true){
            key = waitPressKey(key, terminal);
            if( key.getKind() == Key.Kind.Escape)
                break;
            printing.Print(key, stringInput);
        }
        //System.out.println(stringInput);
        System.exit(0);
    }

   /* public static String Print (int x, int y, Key key, String stringInput, Terminal terminal){
        char input;
        input = key.getCharacter();
        if(key.getKind() == Key.Kind.Backspace){
            x--;
            input = ' ';
        }
        else
            x++;
        if(key.getKind() == Key.Kind.Enter)
            y++;

        terminal.moveCursor(x, y);
        terminal.putCharacter(input);
        stringInput = Character.toString(input);
        return stringInput;
    }*/

    public static Key waitPressKey (Key key, Terminal terminal)throws InterruptedException{
        do {
            Thread.sleep(5);
            key = terminal.readInput();
        }
        while (key == null);

        return key;
    }
}
