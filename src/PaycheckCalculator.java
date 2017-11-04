// Paycheck Calculation Software
// Made by and designed personally for Alex Morehead

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

public class PaycheckCalculator extends Application {
    private TextField tfGrossIncomeAmount = new TextField();
    private TextField tfNetIncomeAmount = new TextField();
    private TextField tfTitheAmount = new TextField();
    private TextField tfSavingsAmount = new TextField();
    private TextField tfCheckingAmount = new TextField();
    private TextField tfAmountForIRA = new TextField();
    private TextField tfCarAmount = new TextField();
    private TextField tfEmergencyAmount = new TextField();
    private TextField tfTravelAmount = new TextField();
    private TextField tfNewTechAmount = new TextField();
    private TextField tfSubscriptionAmount = new TextField();
    private TextField tfMusicAmount = new TextField();
    private TextField tfGivingAmount = new TextField();
    private TextField tfGasAmount = new TextField();
    private TextField tfFoodAmount = new TextField();
    private TextField tfUnplannedAmount = new TextField();
    private TextField tfEntertainmentAmount = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override // This overrides the start method in the JavaFX Application class
    public void start(Stage primaryStage) {
        // This creates the UI
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
        gridPane.add(new Label("IRA Amount:"), 0, 5);
        gridPane.add(tfAmountForIRA, 1, 5);
        gridPane.add(new Label("Car Amount:"), 0, 6);
        gridPane.add(tfCarAmount, 1, 6);
        gridPane.add(new Label("Emergency Amount:"), 0, 7);
        gridPane.add(tfEmergencyAmount, 1, 7);
        gridPane.add(new Label("Travel Amount:"), 0, 8);
        gridPane.add(tfTravelAmount, 1, 8);
        gridPane.add(new Label("New Tech Amount:"), 0, 9);
        gridPane.add(tfNewTechAmount, 1, 9);
        gridPane.add(new Label("Subscription Amount:"), 0, 10);
        gridPane.add(tfSubscriptionAmount, 1, 10);
        gridPane.add(new Label("Music Amount:"), 0, 11);
        gridPane.add(tfMusicAmount, 1, 11);
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

        // This sets the properties for the program's UI
        gridPane.setAlignment(Pos.CENTER);
        tfGrossIncomeAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfNetIncomeAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfTitheAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfSavingsAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfCheckingAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfAmountForIRA.setAlignment(Pos.BOTTOM_RIGHT);
        tfCarAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfEmergencyAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfTravelAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfNewTechAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfSubscriptionAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMusicAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfGivingAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfFoodAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfUnplannedAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfEntertainmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfTitheAmount.setEditable(false);
        tfSavingsAmount.setEditable(false);
        tfCheckingAmount.setEditable(false);
        tfAmountForIRA.setEditable(false);
        tfCarAmount.setEditable(false);
        tfEmergencyAmount.setEditable(false);
        tfTravelAmount.setEditable(false);
        tfNewTechAmount.setEditable(false);
        tfSubscriptionAmount.setEditable(false);
        tfMusicAmount.setEditable(false);
        tfGivingAmount.setEditable(false);
        tfGasAmount.setEditable(false);
        tfFoodAmount.setEditable(false);
        tfUnplannedAmount.setEditable(false);
        tfEntertainmentAmount.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        // Sets dummy values for the gross and net income fields
        tfGrossIncomeAmount.setText("$0.00");
        tfNetIncomeAmount.setText("$0.00");

        // This processes the programs events
        btCalculate.setOnAction(e -> calculatePaycheckAmounts());

        // This creates a scene and places it in the stage
        Scene scene = new Scene(gridPane, 800, 600);
        primaryStage.setTitle("Paycheck Calculator"); // This sets the stage's title
        primaryStage.setScene(scene); // This places the scene in the stage
        primaryStage.show(); // This actually displays the stage
    }

    private void calculatePaycheckAmounts() {
        // This gets the gross and net income values from the text fields
        BigDecimal GrossIncomeAmount = new BigDecimal(tfGrossIncomeAmount.getText().replace("$", ""));
        BigDecimal NetIncomeAmount = new BigDecimal(tfNetIncomeAmount.getText().replace("$", ""));

        // Calculates amount for tithe (10% of the gross income amount)
        BigDecimal amountForTithe = GrossIncomeAmount.multiply(BigDecimal.valueOf(0.10));

        // Sets aside the tithe amount from the current netIncome
        BigDecimal adjustmentAmount = NetIncomeAmount.subtract(amountForTithe);

        // Calculates the amount to be allotted to a savings account
        BigDecimal amountForSavings = adjustmentAmount.multiply(BigDecimal.valueOf(0.80));

        // Calculates the amount to be allotted to a checking account
        BigDecimal amountForChecking = adjustmentAmount.multiply(BigDecimal.valueOf(0.20));


        // Savings Account Percentages


        // Calculates the amount to be allotted to the yearly Roth IRA contribution
        BigDecimal amountForIRA = amountForSavings.multiply(BigDecimal.valueOf(0.60));

        // Calculates the amount to be allotted from savings toward a car maintenance and/or replacement
        BigDecimal amountForCar = amountForSavings.multiply(BigDecimal.valueOf(0.07));

        // Calculates the amount to be allotted from savings toward the emergency fund
        BigDecimal amountForEmergency = amountForSavings.multiply(BigDecimal.valueOf(0.08));

        // Calculates the amount to be allotted from savings toward the future trips
        BigDecimal amountForTravel = amountForSavings.multiply(BigDecimal.valueOf(0.13));

        // Calculates the amount to be allotted from savings toward a new computer or phone
        BigDecimal amountForNewTech = amountForSavings.multiply(BigDecimal.valueOf(0.03));

        // Calculates the amount to be allotted from savings toward yearly subscriptions
        BigDecimal amountForSubscriptions = amountForSavings.multiply(BigDecimal.valueOf(0.03));

        // Calculates the amount to be allotted from savings toward music equipment and instruments
        BigDecimal amountForMusic = amountForSavings.multiply(BigDecimal.valueOf(0.06));


        // Checking Account Percentages


        // Calculates the amount to be allotted from checking toward the giving fund
        BigDecimal amountForGiving = amountForChecking.multiply(BigDecimal.valueOf(0.27));

        // Calculates the amount to be allotted from checking toward the gas fund
        BigDecimal amountForGas = amountForChecking.multiply(BigDecimal.valueOf(0.28));

        // Calculates the amount to be allotted from checking toward the food fund
        BigDecimal amountForFood = amountForChecking.multiply(BigDecimal.valueOf(0.19));

        // Calculates the amount to be allotted from checking toward the unplanned expenses fund
        BigDecimal amountForUnplanned = amountForChecking.multiply(BigDecimal.valueOf(0.06));

        // Calculates the amount to be allotted from checking toward the entertainment fund
        BigDecimal amountForEntertainment = amountForChecking.multiply(BigDecimal.valueOf(0.20));


        // Adds back the tithe to the checking account
        amountForChecking = amountForChecking.add(amountForTithe);


        // This displays the paycheck amounts
        tfGrossIncomeAmount.setText((String.format("$%,4.2f", GrossIncomeAmount)));
        tfNetIncomeAmount.setText((String.format("$%,4.2f", NetIncomeAmount)));
        tfTitheAmount.setText(String.format("$%,4.2f", amountForTithe));
        tfSavingsAmount.setText(String.format("$%,4.2f", amountForSavings));
        tfCheckingAmount.setText(String.format("$%,4.2f", amountForChecking));
        tfAmountForIRA.setText(String.format("$%,4.2f", amountForIRA));
        tfCarAmount.setText(String.format("$%,4.2f", amountForCar));
        tfEmergencyAmount.setText(String.format("$%,4.2f", amountForEmergency));
        tfTravelAmount.setText(String.format("$%,4.2f", amountForTravel));
        tfNewTechAmount.setText(String.format("$%,4.2f", amountForNewTech));
        tfSubscriptionAmount.setText(String.format("$%,4.2f", amountForSubscriptions));
        tfMusicAmount.setText(String.format("$%,4.2f", amountForMusic));
        tfGivingAmount.setText(String.format("$%,4.2f", amountForGiving));
        tfGasAmount.setText(String.format("$%,4.2f", amountForGas));
        tfFoodAmount.setText(String.format("$%,4.2f", amountForFood));
        tfUnplannedAmount.setText(String.format("$%,4.2f", amountForUnplanned));
        tfEntertainmentAmount.setText(String.format("$%,4.2f", amountForEntertainment));
    }
}
