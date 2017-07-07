package com.company.Testprojekt;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.List;

/**
 * Created by Tullduvan on 2017-07-07.
 */
public class toPrint {
    public int x;
    public int y;
    public List<Integer> tempx;
    Terminal terminal;

    public toPrint(int x, int y, List<Integer> tempx,  Terminal terminal) {
        this.x = x;
        this.y = y;
        this.terminal = terminal;
        this.tempx = tempx;
    }

    public void Print (int startx, int xmax, Key key, String stringInput){
        char input;
        switch(key.getKind()){
            case Backspace:
                input = ' ';
                if(x == 1 && y == 2){
                    break;
                }
                if(x == 1 && y > 2){
                    y--;
                    x = tempx.get(y-2);
                    terminal.putCharacter(input);
                    terminal.moveCursor(x, y);
                    tempx.remove(y-2);
                    break;
                }
                if(x > 1) {
                    x--;
                    terminal.moveCursor(x, y);
                    terminal.putCharacter(input);
                    terminal.moveCursor(x, y);
                    break;
                }
            case Enter:
                tempx.add(x);
                x = startx;
                y++;
                terminal.moveCursor(x, y);
                break;
            default:
                input = key.getCharacter();
                x++;
                terminal.putCharacter(input);
                terminal.moveCursor(x, y);
        }
        //return stringInput;
    }
    public void WriterTerminal (int startx, String input){
        for(int i=0;i<input.length();i++){
            terminal.moveCursor(startx, y);
            terminal.putCharacter(input.charAt(i));
            startx++;
        }
        y++;
        terminal.moveCursor(x, y);

    }
}
