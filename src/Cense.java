// An open-source personal finance assistance software.
// This version uses the "JavaFX" library.

package src;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.math.BigDecimal;

public class Cense extends Application {
    private final TextField tfGrossIncomeAmount = new TextField();
    private final TextField tfNetIncomeAmount = new TextField();
    private final TextField tfTitheAmount = new TextField();
    private final TextField tfSavingsAmount = new TextField();
    private final TextField tfCheckingAmount = new TextField();
    private final TextField tfIRASavings = new TextField();
    private final TextField tfCarSavings = new TextField();
    private final TextField tfEmergencySavings = new TextField();
    private final TextField tfGraduateSchoolSavings = new TextField();
    private final TextField tfTravelSavings = new TextField();
    private final TextField tfNewTechSavings = new TextField();
    private final TextField tfMusicEquipmentSavings = new TextField();
    private final TextField tfGivingAmount = new TextField();
    private final TextField tfGasAmount = new TextField();
    private final TextField tfFoodAmount = new TextField();
    private final TextField tfUnplannedAmount = new TextField();
    private final TextField tfEntertainmentAmount = new TextField();
    private final Button btCalculate = new Button("Calculate");

    // This guarantees the application will launch upon execution in a GUI.
    public static void main(String[] args) {
        launch(args);
    }

    @Override // This overrides the start method in the JavaFX Application class.
    public void start(Stage primaryStage) {
        // This creates the UI.
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Gross Income Amount:"), 0, 0);
        gridPane.add(tfGrossIncomeAmount, 1, 0);
        gridPane.add(new Label("Net Income Amount:"), 0, 1);
        gridPane.add(tfNetIncomeAmount, 1, 1);
        gridPane.add(new Label("Tithe Amount:"), 0, 2);
        gridPane.add(tfTitheAmount, 1, 2);
        gridPane.add(new Label("Savings Amount:"), 0, 3);
        gridPane.add(tfSavingsAmount, 1, 3);
        gridPane.add(new Label("Checking Amount:"), 0, 4);
        gridPane.add(tfCheckingAmount, 1, 4);
        gridPane.add(new Label("IRA Savings:"), 0, 5);
        gridPane.add(tfIRASavings, 1, 5);
        gridPane.add(new Label("Car Savings:"), 0, 6);
        gridPane.add(tfCarSavings, 1, 6);
        gridPane.add(new Label("Emergency Savings:"), 0, 7);
        gridPane.add(tfEmergencySavings, 1, 7);
        gridPane.add(new Label("Graduate School Savings:"), 0, 8);
        gridPane.add(tfGraduateSchoolSavings, 1, 8);
        gridPane.add(new Label("Travel Savings:"), 0, 9);
        gridPane.add(tfTravelSavings, 1, 9);
        gridPane.add(new Label("New Tech Savings:"), 0, 10);
        gridPane.add(tfNewTechSavings, 1, 10);
        gridPane.add(new Label("Music Equipment Savings:"), 0, 11);
        gridPane.add(tfMusicEquipmentSavings, 1, 11);
        gridPane.add(new Label("Giving Amount:"), 0, 12);
        gridPane.add(tfGivingAmount, 1, 12);
        gridPane.add(new Label("Gas Amount:"), 0, 13);
        gridPane.add(tfGasAmount, 1, 13);
        gridPane.add(new Label("Food Amount:"), 0, 14);
        gridPane.add(tfFoodAmount, 1, 14);
        gridPane.add(new Label("Unplanned Amount:"), 0, 15);
        gridPane.add(tfUnplannedAmount, 1, 15);
        gridPane.add(new Label("Entertainment Amount:"), 0, 16);
        gridPane.add(tfEntertainmentAmount, 1, 16);
        gridPane.add(btCalculate, 0, 17);

        // This sets the properties for the program's UI.
        gridPane.setAlignment(Pos.CENTER);
        tfGrossIncomeAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfNetIncomeAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfTitheAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfSavingsAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfCheckingAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfIRASavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfCarSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfEmergencySavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfGraduateSchoolSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfTravelSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfNewTechSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfMusicEquipmentSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfGivingAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfFoodAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfUnplannedAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfEntertainmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfTitheAmount.setEditable(false);
        tfSavingsAmount.setEditable(false);
        tfCheckingAmount.setEditable(false);
        tfIRASavings.setEditable(false);
        tfCarSavings.setEditable(false);
        tfEmergencySavings.setEditable(false);
        tfGraduateSchoolSavings.setEditable(false);
        tfTravelSavings.setEditable(false);
        tfNewTechSavings.setEditable(false);
        tfMusicEquipmentSavings.setEditable(false);
        tfGivingAmount.setEditable(false);
        tfGasAmount.setEditable(false);
        tfFoodAmount.setEditable(false);
        tfUnplannedAmount.setEditable(false);
        tfEntertainmentAmount.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        // This sets dummy values for the gross and net income fields.
        tfGrossIncomeAmount.setText("$0.00");
        tfNetIncomeAmount.setText("$0.00");

        // This processes the programs events.
        btCalculate.setOnAction(e -> calculatePaycheckAmounts());

        // This creates a scene and places it in the stage.
        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setTitle("Cense: A Calculator for Sensical Personal Finance"); // This sets the stage's title.
        primaryStage.setScene(scene); // This places the scene in the stage.
        primaryStage.show(); // This actually displays the stage.
    }

    private void calculatePaycheckAmounts() {

        // This gets the gross and net income values from the text fields.
        BigDecimal GrossIncomeAmount = new BigDecimal(tfGrossIncomeAmount.getText().replace("$", ""));
        BigDecimal NetIncomeAmount = new BigDecimal(tfNetIncomeAmount.getText().replace("$", ""));


        // Calculation Setup Stage //


        // This calculates amount for tithe (10% of the gross income amount).
        BigDecimal amountForTithe = GrossIncomeAmount.multiply(BigDecimal.valueOf(0.10));

        // This sets aside the tithe amount from the current netIncome.
        BigDecimal adjustmentAmount = NetIncomeAmount.subtract(amountForTithe);

        // This calculates the amount to be allotted to a savings account.
        BigDecimal amountForSavings = adjustmentAmount.multiply(BigDecimal.valueOf(0.80));

        // This calculates the amount to be allotted to a checking account.
        BigDecimal amountForChecking = adjustmentAmount.multiply(BigDecimal.valueOf(0.20));


        // Savings Account Percentages //


        // This calculates the amount to be allotted to the yearly Roth IRA contribution.
        BigDecimal IRASavings = amountForSavings.multiply(BigDecimal.valueOf(0.60));

        // This calculates the amount to be allotted from savings toward a car maintenance and/or replacement.
        BigDecimal carSavings = amountForSavings.multiply(BigDecimal.valueOf(0.08));

        // This calculates the amount to be allotted from savings toward the emergency fund.
        BigDecimal emergencySavings = amountForSavings.multiply(BigDecimal.valueOf(0.08));

        // This calculates the amount to be allotted from savings toward graduate school education.
        BigDecimal graduateSchoolSavings = amountForSavings.multiply(BigDecimal.valueOf((0.04)));

        // This calculates the amount to be allotted from savings toward the future trips.
        BigDecimal travelSavings = amountForSavings.multiply(BigDecimal.valueOf(0.14));

        // This calculates the amount to be allotted from savings toward a new computer or phone.
        BigDecimal newTechSavings = amountForSavings.multiply(BigDecimal.valueOf(0.02));

        // This calculates the amount to be allotted from savings toward music equipment and instruments.
        BigDecimal musicEquipmentSavings = amountForSavings.multiply(BigDecimal.valueOf(0.04));


        // Checking Account Percentages //


        // This calculates the amount to be allotted from checking toward the giving fund.
        BigDecimal amountForGiving = amountForChecking.multiply(BigDecimal.valueOf(0.27));

        // This calculates the amount to be allotted from checking toward the gas fund.
        BigDecimal amountForGas = amountForChecking.multiply(BigDecimal.valueOf(0.28));

        // This calculates the amount to be allotted from checking toward the food fund.
        BigDecimal amountForFood = amountForChecking.multiply(BigDecimal.valueOf(0.19));

        // This calculates the amount to be allotted from checking toward the unplanned expenses fund.
        BigDecimal amountForUnplanned = amountForChecking.multiply(BigDecimal.valueOf(0.06));

        // This calculates the amount to be allotted from checking toward the entertainment fund.
        BigDecimal amountForEntertainment = amountForChecking.multiply(BigDecimal.valueOf(0.20));


        // This adds back the tithe to the checking account.
        amountForChecking = amountForChecking.add(amountForTithe);


        // This displays the paycheck amounts
        tfGrossIncomeAmount.setText((String.format("$%,4.2f", GrossIncomeAmount)));
        tfNetIncomeAmount.setText((String.format("$%,4.2f", NetIncomeAmount)));
        tfTitheAmount.setText(String.format("$%,4.2f", amountForTithe));
        tfSavingsAmount.setText(String.format("$%,4.2f", amountForSavings));
        tfCheckingAmount.setText(String.format("$%,4.2f", amountForChecking));
        tfIRASavings.setText(String.format("$%,4.2f", IRASavings));
        tfCarSavings.setText(String.format("$%,4.2f", carSavings));
        tfEmergencySavings.setText(String.format("$%,4.2f", emergencySavings));
        tfGraduateSchoolSavings.setText(String.format("$%,4.2f", graduateSchoolSavings));
        tfTravelSavings.setText(String.format("$%,4.2f", travelSavings));
        tfNewTechSavings.setText(String.format("$%,4.2f", newTechSavings));
        tfMusicEquipmentSavings.setText(String.format("$%,4.2f", musicEquipmentSavings));
        tfGivingAmount.setText(String.format("$%,4.2f", amountForGiving));
        tfGasAmount.setText(String.format("$%,4.2f", amountForGas));
        tfFoodAmount.setText(String.format("$%,4.2f", amountForFood));
        tfUnplannedAmount.setText(String.format("$%,4.2f", amountForUnplanned));
        tfEntertainmentAmount.setText(String.format("$%,4.2f", amountForEntertainment));
    }
}
