// https://judge.softuni.bg/Contests/Practice/Index/474#0
package org.lynxlake._01DefiningClassesLab._03BankAccountTestClient;

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
                    execCreate(cmdArgs, accounts);
                    break;
                case "Deposit":
                    execDeposit(cmdArgs, accounts);
                    break;
                case "Withdraw":
                    execWithdraw(cmdArgs, accounts);
                    break;
                case "Print":
                    execPrint(cmdArgs, accounts);
                    break;
            }
        }
    }

    private static void execPrint(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            System.out.println(accounts.get(id));
        }
    }

    private static void execWithdraw(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        double amount = Double.parseDouble(cmdArgs[2]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            try {
                BankAccount account = accounts.get(id);
                account.withdraw(amount);
                accounts.put(id, account);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void execDeposit(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        double amount = Double.parseDouble(cmdArgs[2]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            BankAccount account = accounts.get(id);
            account.deposit(amount);
            accounts.put(id, account);
        }
    }

    private static void execCreate(String[] cmdArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(cmdArgs[1]);
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}
