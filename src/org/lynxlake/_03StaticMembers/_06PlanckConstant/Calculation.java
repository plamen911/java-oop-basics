package org.lynxlake._03StaticMembers._06PlanckConstant;

class Calculation {
    static final double planckConstant = 6.62606896e-34;
    static final double pi = 3.14159;

    static double calculate() {
        return planckConstant / (2.0 * pi);
    }
}
