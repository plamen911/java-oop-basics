package org.lynxlake.methods.pizzaTime;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Pizza {
    public String name;
    public int group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Integer, LinkedList<String>> parseInput(String input) {
        String[] params = input.split("\\s+");

        HashMap<Integer, LinkedList<String>> pizzaList = new HashMap<>();

        String pattern = "^(\\d+)(.*)$";
        Pattern r = Pattern.compile(pattern);

        for (int i = 0; i < params.length; i++) {
            Matcher m = r.matcher(params[i]);
            if (m.find()) {
                int group = Integer.parseInt(m.group(1));
                String name = m.group(2);

                if (!pizzaList.containsKey(group)) {
                    pizzaList.put(group, new LinkedList<>());
                }

                pizzaList.get(group).add(name);

            } else {
                // System.out.println("NO MATCH");
            }
        }

        return pizzaList;
    }
}
