package org.lynxlake.methods.numberInReversedOrder;

class DecimalNumber {
    String getDigitsInReverseOrder(String numAsText) {
        String reversed = "";
        for (int i = numAsText.length() - 1; i >= 0; i--) {
            reversed += numAsText.charAt(i);
        }

        return reversed;
    }
}
