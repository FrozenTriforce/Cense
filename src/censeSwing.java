// An open-source personal finance assistance software.
// This version uses the "Swing" library.

package PersonalProjects.Cense.src;

import javax.swing.*;
import java.math.BigDecimal;

public class censeSwing {

    public static void main(String[] args) {

        // Prompts the user to enter a gross income amount
        String inputString = JOptionPane.showInputDialog(null,
                "Please enter your paycheck's gross income (the amount before taxes and deductions): ");

        // Stores the user's gross income amount in "grossIncome"
        BigDecimal grossIncome = new BigDecimal(inputString);

        // Prompts the user to enter a net income amount
        inputString = JOptionPane.showInputDialog(null,
                "Please enter your paycheck's net income (the amount after taxes and deductions): ");

        // Stores the user's net income amount in "netIncome"
        BigDecimal netIncome = new BigDecimal(inputString);

        // Calls the method "calculateBudget" to display the user's desired budget
        calculateBudget(grossIncome, netIncome);

        // Exits the program normally
        System.exit(0);
    }

    // Creates a method that calculates and displays the user's budget
    private static void calculateBudget(BigDecimal income1, BigDecimal income2) {


        // Calculates amount for tithe (10% of the gross income amount)
        BigDecimal titheAmount = income1.multiply(BigDecimal.valueOf(0.10));

        // Sets aside the tithe amount from the current netIncome
        BigDecimal adjustmentAmount = income2.subtract(titheAmount);

        // Calculates the amount to be allotted to a savings account
        BigDecimal savingsAmount = adjustmentAmount.multiply(BigDecimal.valueOf(0.80));

        // Calculates the amount to be allotted to a checking account
        BigDecimal checkingAmount = adjustmentAmount.multiply(BigDecimal.valueOf(0.20));


        // Savings Account Percentages


        // Calculates the amount to be allotted to the yearly Roth IRA contribution
        BigDecimal amountForIRA = savingsAmount.multiply(BigDecimal.valueOf(0.60));

        // Calculates the amount to be allotted from savings toward a car maintenance and/or replacement
        BigDecimal amountForCar = savingsAmount.multiply(BigDecimal.valueOf(0.07));

        // Calculates the amount to be allotted from savings toward the emergency fund
        BigDecimal amountForEmergency = savingsAmount.multiply(BigDecimal.valueOf(0.08));

        // Calculates the amount to be allotted from savings toward the future trips
        BigDecimal amountForTrips = savingsAmount.multiply(BigDecimal.valueOf(0.13));

        // Calculates the amount to be allotted from savings toward college/graduate school
        BigDecimal amountForSchool = savingsAmount.multiply(BigDecimal.valueOf(0.01));

        // Calculates the amount to be allotted from savings toward a new computer or phone
        BigDecimal amountForNewComputerOrPhone = savingsAmount.multiply(BigDecimal.valueOf(0.02));

        // Calculates the amount to be allotted from savings toward yearly subscriptions
        BigDecimal amountForSubscriptions = savingsAmount.multiply(BigDecimal.valueOf(0.03));

        // Calculates the amount to be allotted from savings toward music equipment and instruments
        BigDecimal amountForMusic = savingsAmount.multiply(BigDecimal.valueOf(0.06));


        // Checking Account Percentages


        // Calculates the amount to be allotted from checking toward the giving fund
        BigDecimal amountForGiving = checkingAmount.multiply(BigDecimal.valueOf(0.27));

        // Calculates the amount to be allotted from checking toward the gas fund
        BigDecimal amountForGas = checkingAmount.multiply(BigDecimal.valueOf(0.30));

        // Calculates the amount to be allotted from checking toward the food fund
        BigDecimal amountForFood = checkingAmount.multiply(BigDecimal.valueOf(0.17));

        // Calculates the amount to be allotted from checking toward the unplanned expenses fund
        BigDecimal amountForUnplanned = checkingAmount.multiply(BigDecimal.valueOf(0.06));

        // Calculates the amount to be allotted from checking toward the entertainment fund
        BigDecimal amountForEntertainment = checkingAmount.multiply(BigDecimal.valueOf(0.20));


        // Adds back the tithe to the checking account
        checkingAmount = checkingAmount.add(titheAmount);


        // Outputs the corresponding amounts for the user to budget
        JOptionPane.showMessageDialog(null, String.format("Here are the following amounts for you to allocate: \n\n"

                        + "                                                      - General Summary - \n"
                        + "1. The amount going to your savings account is $%,4.2f. \n"
                        + "2. The amount (with tithe) going to your checking account is $%,4.2f. \n\n"

                        + "Please enter the following amounts in the designated spreadsheet (Savings Account): \n"

                        + "1. The amount of savings going toward your yearly Roth IRA contribution is $%,4.2f. \n"
                        + "2. The amount of savings going toward car maintenance/replacement is $%,4.2f. \n"
                        + "3. The amount of savings going toward your emergency fund is $%,4.2f. \n"
                        + "4. The amount of savings going toward future trips is $%,4.2f. \n"
                        + "5. The amount of savings going toward college/graduate school is $%,4.2f. \n"
                        + "6. The amount of savings going toward a new computer or phone is $%,4.2f. \n"
                        + "7. The amount of savings going toward monthly or yearly subscriptions is $%,4.2f. \n"
                        + "8. The amount of savings going toward music equipment and/or instruments is $%,4.2f. \n\n"

                        + "Please enter the following amounts in the designated spreadsheet (Checking Account): \n"

                        + "1. The amount of tithe for this paycheck (10%% of your gross income) is $%,4.2f. \n"
                        + "1. The amount of spending money going toward the giving fund is $%,4.2f. \n"
                        + "2. The amount of spending money going toward the gas fund is $%,4.2f. \n"
                        + "3. The amount of spending money going toward the food fund is $%,4.2f. \n"
                        + "4. The amount of spending money going toward the fund for unplanned expenses is $%,4.2f. \n"
                        + "5. The amount of spending money going toward the entertainment/tech fund is $%,4.2f. \n",
                savingsAmount, checkingAmount, amountForIRA, amountForCar, amountForEmergency, amountForTrips,
                amountForSchool, amountForNewComputerOrPhone, amountForSubscriptions, amountForMusic, titheAmount,
                amountForGiving, amountForGas, amountForFood, amountForUnplanned, amountForEntertainment));

    }
}
