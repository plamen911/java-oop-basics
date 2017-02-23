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
                    executeCreateCommand(accounts);
                    break;

                case "Deposit":
                    executeDepositCommand(accounts, cmdArgs);
                    break;

                case "SetInterest":
                    executeSetInterestCommand(cmdArgs[1]);
                    break;

                case "GetInterest":
                    executeGetIntrestCommand(accounts, cmdArgs);
                    break;
            }
        }
    }

    private static void executeSetInterestCommand(String cmdArg) {
        BankAccount.setInterest(Double.valueOf(cmdArg));
    }

    private static void executeCreateCommand(HashMap<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.println("Account " + account + " created");
    }

    private static void executeGetIntrestCommand(HashMap<Integer, BankAccount> accounts, String[] cmdArgs) {
        try {
            Integer id = Integer.valueOf(cmdArgs[1]);
            BankAccount acct = accounts.get(id);
            Integer years = Integer.valueOf(cmdArgs[2]);
            double interest = acct.getInterest(years);
            System.out.printf("%.2f%n", interest);
        } catch (Exception e) {
            System.out.println("Account does not exist");
        }
    }

    private static void executeDepositCommand(HashMap<Integer, BankAccount> accounts, String[] cmdArgs) {
        try {
            int amount = Integer.valueOf(cmdArgs[2]);
            Integer id = Integer.valueOf(cmdArgs[1]);
            BankAccount acct = accounts.get(id);
            acct.deposit(amount);
            System.out.println("Deposited " + amount + " to " + acct);
        } catch (Exception e) {
            System.out.println("Account does not exist");
        }
    }
}
