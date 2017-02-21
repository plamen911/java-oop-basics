package org.lynxlake._02Methods._03LastDigitName;

class Number {
    private int num;

    public Number(int num) {
        this.num = num;
    }

    public Number() {
        this(0);
    }

    public String getLastDigitAsText(int number)
    {
        // Get last digit
        this.num = number % 10;

        String englishName = "";
        switch (this.num) {
            case 0:
                englishName += "zero";
                break;
            case 1:
                englishName += "one";
                break;
            case 2:
                englishName += "two";
                break;
            case 3:
                englishName += "three";
                break;
            case 4:
                englishName += "four";
                break;
            case 5:
                englishName += "five";
                break;
            case 6:
                englishName += "six";
                break;
            case 7:
                englishName += "seven";
                break;
            case 8:
                englishName += "eight";
                break;
            case 9:
                englishName += "nine";
                break;
        }

        return englishName;
    }
}

