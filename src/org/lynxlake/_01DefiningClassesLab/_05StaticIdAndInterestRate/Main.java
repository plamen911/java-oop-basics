// https://judge.softuni.bg/Contests/Practice/Index/474#1
package org.lynxlake._01DefiningClassesLab._05StaticIdAndInterestRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();
        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] cmdArgs = line.split("\\s+");
            String cmdType = cmdArgs[0];
            switch (cmdType) {
                case "Create":
                    BankAccount account = new BankAccount();
                    accounts.put(account.getId(), account);
                    System.out.println("Account " + account + " created");
                    break;

                case "Deposit":
                    try {
                        int amount = Integer.valueOf(cmdArgs[2]);
                        BankAccount acct = accounts.get(Integer.valueOf(cmdArgs[1]));
                        acct.deposit(amount);
                        System.out.println("Deposited " + amount + " to " + acct);
                    } catch (Exception e) {
                        System.out.println("Account does not exist");
                    }
                    break;

                case "SetInterest":
                    BankAccount.setInterest(Double.valueOf(cmdArgs[1]));
                    break;

                case "GetInterest":
                    try {
                        BankAccount acct = accounts.get(Integer.valueOf(cmdArgs[1]));
                        double interest = acct.getInterest(Integer.valueOf(cmdArgs[2]));
                        System.out.printf("%.2f%n", interest);
                    } catch (Exception e) {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
}
