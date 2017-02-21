// https://judge.softuni.bg/Contests/Practice/Index/225#3
package org.lynxlake._02Methods._03LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        reader.close();

        Number n = new Number();
        System.out.println(n.getLastDigitAsText(num));
    }
}
