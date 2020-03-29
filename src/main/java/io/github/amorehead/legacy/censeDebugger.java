// An open-source personal finance assistance software.
// This version is for debugging in a console-like interface.
// Warning: deprecated.

package io.github.amorehead.legacy;

import java.util.Scanner;
import java.math.BigDecimal;

class censeDebugger {

    public static void main(String[] args) {

        // This creates a Scanner object.
        Scanner input = new Scanner(System.in);

        // This prompts the user to enter a gross income amount.
        System.out.print("Please enter your paycheck's gross income (the amount before taxes and deductions): ");

        // This stores the user's gross income amount in "grossIncome".
        BigDecimal grossIncome = new BigDecimal(input.next());

        // This prompts the user to enter a net income amount.
        System.out.print("Please enter your paycheck's net income (the amount after taxes and deductions): ");

        // This stores the user's net income amount in "netIncome".
        BigDecimal netIncome = new BigDecimal(input.next());

        // This calls the method "calculateBudget" to display the user's desired budget.
        calculateBudget(grossIncome, netIncome);
    }

    // This creates a method that calculates and displays the user's budget.
    private static void calculateBudget(BigDecimal income1, BigDecimal income2) {


        // Pre-Calculation Stage //


        // This calculates amount for tithe (10% of the gross income amount).
        BigDecimal titheAmount = income1.multiply(BigDecimal.valueOf(0.1));

        // This sets aside the tithe amount from the current netIncome.
        BigDecimal adjustmentAmount = income2.subtract(titheAmount);

        // This calculates the amount to be allotted to a savings account.
        BigDecimal savingsAmount = adjustmentAmount.multiply(BigDecimal.valueOf(0.8));

        // This calculates the amount to be allotted to a checking account.
        BigDecimal checkingAmount = adjustmentAmount.multiply(BigDecimal.valueOf(0.2));


        // Savings Account Percentages //


        // This calculates the amount to be allotted to the yearly Roth IRA contribution.
        BigDecimal IRASavings = savingsAmount.multiply(BigDecimal.valueOf(0.60));

        // This calculates the amount to be allotted from savings toward a car maintenance and/or replacement.
        BigDecimal carSavings = savingsAmount.multiply(BigDecimal.valueOf(0.08));

        // This calculates the amount to be allotted from savings toward the emergency fund.
        BigDecimal emergencySavings = savingsAmount.multiply(BigDecimal.valueOf(0.08));

        // This calculates the amount to be allotted from savings toward graduate school education.
        BigDecimal graduateSchoolSavings = savingsAmount.multiply(BigDecimal.valueOf((0.04)));

        // This calculates the amount to be allotted from savings toward the future trips.
        BigDecimal travelSavings = savingsAmount.multiply(BigDecimal.valueOf(0.14));

        // This calculates the amount to be allotted from savings toward a new computer or phone.
        BigDecimal newTechSavings = savingsAmount.multiply(BigDecimal.valueOf(0.02));

        // This calculates the amount to be allotted from savings toward music equipment and instruments.
        BigDecimal musicEquipmentSavings = savingsAmount.multiply(BigDecimal.valueOf(0.04));


        // Checking Account Percentages //


        // This calculates the amount to be allotted from checking toward the giving fund.
        BigDecimal amountForGiving = checkingAmount.multiply(BigDecimal.valueOf(0.27));

        // This calculates the amount to be allotted from checking toward the gas fund.
        BigDecimal amountForGas = checkingAmount.multiply(BigDecimal.valueOf(0.30));

        // This calculates the amount to be allotted from checking toward the food fund.
        BigDecimal amountForFood = checkingAmount.multiply(BigDecimal.valueOf(0.17));

        // This calculates the amount to be allotted from checking toward the unplanned expenses fund.
        BigDecimal amountForUnplanned = checkingAmount.multiply(BigDecimal.valueOf(0.06));

        // This calculates the amount to be allotted from checking toward the entertainment fund.
        BigDecimal amountForEntertainment = checkingAmount.multiply(BigDecimal.valueOf(0.20));


        // This adds back the tithe to the checking account.
        checkingAmount = checkingAmount.add(titheAmount);


        // This displays the corresponding amounts for the user to budget.
        System.out.printf("\n                   - General Summary - \n"
                        + "1. The amount going to your savings account is $%,4.2f. \n"
                        + "2. The amount (with tithe) going to your checking account is $%,4.2f. \n\n"

                        + "Please enter the following amounts in the designated spreadsheet (Savings Account): \n"

                        + "1. The amount of savings going toward your yearly Roth IRA contribution is $%,4.2f. \n"
                        + "2. The amount of savings going toward car maintenance/replacement is $%,4.2f. \n"
                        + "3. The amount of savings going toward your emergency fund is $%,4.2f. \n"
                        + "4. The amount of savings going toward your graduate school education is $%,4.2f. \n"
                        + "5. The amount of savings going toward future trips is $%,4.2f. \n"
                        + "6. The amount of savings going toward a new technology is $%,4.2f. \n"
                        + "7. The amount of savings going toward music equipment and/or instruments is $%,4.2f. \n\n"

                        + "Please enter the following amounts in the designated spreadsheet (Checking Account): \n"

                        + "1. The amount of tithe for this paycheck (10%% of your gross income) is $%,4.2f. \n"
                        + "2. The amount of spending money going toward the giving fund is $%,4.2f. \n"
                        + "3. The amount of spending money going toward the gas fund is $%,4.2f. \n"
                        + "4. The amount of spending money going toward the food fund is $%,4.2f. \n"
                        + "5. The amount of spending money going toward the fund for unplanned expenses is $%,4.2f. \n"
                        + "6. The amount of spending money going toward the entertainment fund is $%,4.2f. \n",
                savingsAmount, checkingAmount, IRASavings, carSavings, emergencySavings, graduateSchoolSavings,
                travelSavings, newTechSavings, musicEquipmentSavings, titheAmount, amountForGiving, amountForGas,
                amountForFood, amountForUnplanned, amountForEntertainment);

    }
}
