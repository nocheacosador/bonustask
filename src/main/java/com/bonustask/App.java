package com.bonustask;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String string = scanner.nextLine();
                char[] chars = string.toCharArray();
                
                boolean digitBefore = false;
                int integer = 0;
                
                for (char c : chars) {
                    if ((Character.isDigit(c))) {
                        if (digitBefore) {
                            integer = integer * 10 + Character.getNumericValue(c);
                            if (integer >= 10) {
                                System.out.println(string);
                                break;
                            }
                        }
                        else {
                            integer = Character.getNumericValue(c);
                        }
                        digitBefore = true;
                    }
                    else {
                        digitBefore = false;
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
