package com.company.Testprojekt;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tullduvan on 2017-07-07.
 */
public class InAndOutputPrinting {

    public static void main(String[] args)throws InterruptedException {
        Terminal terminal = new SwingTerminal(100, 50);
        terminal.enterPrivateMode();
        int startx=1, starty=1, xmax = 99;
        List<Integer> tempx = new ArrayList<>();
        Key key = null;
        String stringInput = "";
        String welcometext = "Hello! this is my successfull IO-console, press ESC to quit";
        toPrint printing = new toPrint(startx, starty,tempx, terminal);
        printing.WriterTerminal(startx, welcometext);
        while(true){
            key = waitPressKey(key, terminal);
            if( key.getKind() == Key.Kind.Escape)
                break;
            printing.Print(startx, xmax, key, stringInput);
        }
        //System.out.println(stringInput);
        System.exit(0);
    }

    public static Key waitPressKey (Key key, Terminal terminal)throws InterruptedException{
        do {
            Thread.sleep(5);
            key = terminal.readInput();
        }
        while (key == null);

        return key;
    }
}
