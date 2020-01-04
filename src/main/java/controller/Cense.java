// An open-source personal finance assistance software.
// This version uses the "JavaFX" library.

package main.java.controller;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Cense extends Application {
    private final TextField tfGrossIncomeTotal = new TextField();
    private final TextField tfNetIncomeTotal = new TextField();
    private final TextField tfTitheTotal = new TextField();
    private final TextField tfSavingsTotal = new TextField();
    private final TextField tfCheckingTotal = new TextField();
    private final TextField tfRetirementSavings = new TextField();
    private final TextField tfCarSavings = new TextField();
    private final TextField tfEmergencySavings = new TextField();
    private final TextField tfHigherEducationSavings = new TextField();
    private final TextField tfFutureTravelSavings = new TextField();
    private final TextField tfNewTechnologySavings = new TextField();
    private final TextField tfMusicEquipmentSavings = new TextField();
    private final TextField tfCharityFunds = new TextField();
    private final TextField tfTransportationFunds = new TextField();
    private final TextField tfFoodFunds = new TextField();
    private final TextField tfUnplannedExpenseFunds = new TextField();
    private final TextField tfEntertainmentFunds = new TextField();
    private final Button btCalculate = new Button("Calculate");
    private final TextField tfExtraTextField = new TextField("Click the calculate button to distribute funds:");
    private File spreadsheet;
    private final FileChooser fileChooser = new FileChooser();
    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;
    private XSSFWorkbook workBook;
    private XSSFSheet sheet1;

    // This guarantees the application will launch upon execution in a graphical user interface.
    public static void main(String[] args) {
        launch(args);
    }

    @Override // This overrides the start method in the JavaFX Application class.
    public void start(Stage primaryStage) {
        // The following displays to users an initial pop-up window for selecting an Excel spreadsheet file.
        fileChooser.setTitle("Open Excel Spreadsheet");
        spreadsheet = fileChooser.showOpenDialog(primaryStage);


        // The following try-catch blocks are for spreadsheet I/O to an Excel spreadsheet.
        {
            try {
                fileInputStream = new FileInputStream(spreadsheet);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        {
            try {
                workBook = new XSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // This retrieves the user's selected Excel spreadsheet.
        sheet1 = workBook.getSheetAt(0);


        // This creates the user interface.
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Enter Gross Income for Current Paycheck:"), 0, 0);
        gridPane.add(tfGrossIncomeTotal, 1, 0);
        gridPane.add(new Label("Enter Net Income for Current Paycheck:"), 0, 1);
        gridPane.add(tfNetIncomeTotal, 1, 1);
        gridPane.add(new Label("Tithe Total for Current Paycheck:"), 0, 8);
        gridPane.add(tfTitheTotal, 1, 8);
        gridPane.add(new Label("Total Amount from Current Paycheck for Savings Account:"), 0, 9);
        gridPane.add(tfSavingsTotal, 1, 9);
        gridPane.add(new Label("Total Amount from Current Paycheck for Checking Account:"), 0, 10);
        gridPane.add(tfCheckingTotal, 1, 10);
        gridPane.add(new Label("New 2019 Retirement Contribution Savings Total:"), 0, 11);
        gridPane.add(tfRetirementSavings, 1, 11);
        gridPane.add(new Label("New Car Maintenance/Replacement Savings Total:"), 0, 12);
        gridPane.add(tfCarSavings, 1, 12);
        gridPane.add(new Label("New Emergency Savings Total:"), 0, 13);
        gridPane.add(tfEmergencySavings, 1, 13);
        gridPane.add(new Label("New Higher Education Savings Total:"), 0, 14);
        gridPane.add(tfHigherEducationSavings, 1, 14);
        gridPane.add(new Label("New Future Travel Savings Total:"), 0, 15);
        gridPane.add(tfFutureTravelSavings, 1, 15);
        gridPane.add(new Label("New Technology Savings Total:"), 0, 16);
        gridPane.add(tfNewTechnologySavings, 1, 16);
        gridPane.add(new Label("New Music Equipment Savings Total:"), 0, 17);
        gridPane.add(tfMusicEquipmentSavings, 1, 17);
        gridPane.add(new Label("New Charity Total in Checking Account:"), 0, 18);
        gridPane.add(tfCharityFunds, 1, 18);
        gridPane.add(new Label("New Transportation Total in Checking Account:"), 0, 19);
        gridPane.add(tfTransportationFunds, 1, 19);
        gridPane.add(new Label("New Food & Groceries Total in Checking Account:"), 0, 20);
        gridPane.add(tfFoodFunds, 1, 20);
        gridPane.add(new Label("New Unplanned Expenses Total in Checking Account:"), 0, 21);
        gridPane.add(tfUnplannedExpenseFunds, 1, 21);
        gridPane.add(new Label("New Entertainment Total in Checking Account:"), 0, 22);
        gridPane.add(tfEntertainmentFunds, 1, 22);
        gridPane.add(btCalculate, 1, 25);
        gridPane.add(tfExtraTextField, 0, 25);


        // This sets the properties for the program's UI.
        gridPane.setAlignment(Pos.CENTER);
        tfGrossIncomeTotal.setAlignment(Pos.BOTTOM_RIGHT);
        tfNetIncomeTotal.setAlignment(Pos.BOTTOM_RIGHT);
        tfTitheTotal.setAlignment(Pos.BOTTOM_RIGHT);
        tfSavingsTotal.setAlignment(Pos.BOTTOM_RIGHT);
        tfCheckingTotal.setAlignment(Pos.BOTTOM_RIGHT);
        tfRetirementSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfCarSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfEmergencySavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfHigherEducationSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfFutureTravelSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfNewTechnologySavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfMusicEquipmentSavings.setAlignment(Pos.BOTTOM_RIGHT);
        tfCharityFunds.setAlignment(Pos.BOTTOM_RIGHT);
        tfTransportationFunds.setAlignment(Pos.BOTTOM_RIGHT);
        tfFoodFunds.setAlignment(Pos.BOTTOM_RIGHT);
        tfUnplannedExpenseFunds.setAlignment(Pos.BOTTOM_RIGHT);
        tfEntertainmentFunds.setAlignment(Pos.BOTTOM_RIGHT);
        tfTitheTotal.setEditable(false);
        tfSavingsTotal.setEditable(false);
        tfCheckingTotal.setEditable(false);
        tfRetirementSavings.setEditable(false);
        tfCarSavings.setEditable(false);
        tfEmergencySavings.setEditable(false);
        tfHigherEducationSavings.setEditable(false);
        tfFutureTravelSavings.setEditable(false);
        tfNewTechnologySavings.setEditable(false);
        tfMusicEquipmentSavings.setEditable(false);
        tfCharityFunds.setEditable(false);
        tfTransportationFunds.setEditable(false);
        tfFoodFunds.setEditable(false);
        tfUnplannedExpenseFunds.setEditable(false);
        tfEntertainmentFunds.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        tfExtraTextField.setEditable(false);


        // This sets and consequently displays initial values for the text fields.
        tfGrossIncomeTotal.setText("$0.00");
        tfNetIncomeTotal.setText("$0.00");


        // This processes the programs events.
        btCalculate.setOnAction(e -> calculatePaycheckAmounts());


        // This creates a scene and places it in the stage.
        Scene scene = new Scene(gridPane, 800, 700);
        primaryStage.setTitle("Cense: A Calculator for Sensical Personal Finance"); // This sets the stage's title.
        primaryStage.setScene(scene); // This places the scene in the stage.
        primaryStage.show(); // This actually displays the stage.
    }

    private void calculatePaycheckAmounts() {

        // This gets the gross and net income values from the text fields.
        BigDecimal grossIncomeTotal = new BigDecimal(tfGrossIncomeTotal.getText().replace("$", ""));
        BigDecimal netIncomeTotal = new BigDecimal(tfNetIncomeTotal.getText().replace("$", ""));


        // Calculation Setup Stage //


        // This calculates amount for tithe (10% of the gross income amount).
        BigDecimal titheTotal = grossIncomeTotal.multiply(BigDecimal.valueOf(0.10));

        // This sets aside the tithe amount from the current netIncomeTotal.
        BigDecimal adjustmentAmount = netIncomeTotal.subtract(titheTotal);

        // This calculates the amount to be allotted to a savings account.
        BigDecimal savingsTotal = adjustmentAmount.multiply(BigDecimal.valueOf(0.80));

        // This calculates the amount to be allotted to a checking account.
        BigDecimal checkingTotal = adjustmentAmount.multiply(BigDecimal.valueOf(0.20));


        // Savings Account Percentages //


        // This defines the ratio for this particular field.
        double retirementSavingsRatio = Double.parseDouble(sheet1.getRow(3).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted to an annual retirement account contribution.
        BigDecimal retirementSavings = savingsTotal.multiply(BigDecimal.valueOf(retirementSavingsRatio));

        // This defines the ratio for this particular field.
        double carSavingsRatio = Double.parseDouble(sheet1.getRow(5).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward vehicle maintenance/replacement.
        BigDecimal carSavings = savingsTotal.multiply(BigDecimal.valueOf(carSavingsRatio));

        // This defines the ratio for this particular field.
        double emergencySavingsRatio = Double.parseDouble(sheet1.getRow(7).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward the emergency fund.
        BigDecimal emergencySavings = savingsTotal.multiply(BigDecimal.valueOf(emergencySavingsRatio));

        // This defines the ratio for this particular field.
        double higherEducationSavingsRatio = Double.parseDouble(sheet1.getRow(9).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward higher education funding.
        BigDecimal higherEducationSavings = savingsTotal.multiply(BigDecimal.valueOf((higherEducationSavingsRatio)));

        // This defines the ratio for this particular field.
        double futureTravelSavingsRatio = Double.parseDouble(sheet1.getRow(11).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward future trip expenses.
        BigDecimal futureTravelSavings = savingsTotal.multiply(BigDecimal.valueOf(futureTravelSavingsRatio));

        // This defines the ratio for this particular field.
        double newTechnologySavingsRatio = Double.parseDouble(sheet1.getRow(13).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward new devices.
        BigDecimal newTechnologySavings = savingsTotal.multiply(BigDecimal.valueOf(newTechnologySavingsRatio));

        // This defines the ratio for this particular field.
        double musicEquipmentSavingsRatio = Double.parseDouble(sheet1.getRow(15).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward new music equipment and instruments.
        BigDecimal musicEquipmentSavings = savingsTotal.multiply(BigDecimal.valueOf(musicEquipmentSavingsRatio));


        // Checking Account Percentages //


        // This defines the ratio for this particular field.
        double charityFundsRatio = Double.parseDouble(sheet1.getRow(7).getCell(2)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from checking toward a charitable giving fund.
        BigDecimal charityFunds = checkingTotal.multiply(BigDecimal.valueOf(charityFundsRatio));

        // This defines the ratio for this particular field.
        double transportationFundsRatio = Double.parseDouble(sheet1.getRow(9).getCell(2)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from checking toward a transportation fund.
        BigDecimal transportationFunds = checkingTotal.multiply(BigDecimal.valueOf(transportationFundsRatio));

        // This defines the ratio for this particular field.
        double foodFundsRatio = Double.parseDouble(sheet1.getRow(11).getCell(2)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from checking toward a food and grocery fund.
        BigDecimal foodFunds = checkingTotal.multiply(BigDecimal.valueOf(foodFundsRatio));

        // This defines the ratio for this particular field.
        double unplannedExpenseFundsRatio = Double.parseDouble(sheet1.getRow(13).getCell(2)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from checking toward unplanned expense funds.
        BigDecimal unplannedExpenseFunds = checkingTotal.multiply(BigDecimal.valueOf(unplannedExpenseFundsRatio));

        // This defines the ratio for this particular field.
        double entertainmentFundsRatio = Double.parseDouble(sheet1.getRow(15).getCell(2)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from checking toward an entertainment fund.
        BigDecimal entertainmentFunds = checkingTotal.multiply(BigDecimal.valueOf(entertainmentFundsRatio));


        // This adds back the tithe to the checking account.
        checkingTotal = checkingTotal.add(titheTotal);


        // The following checks to ensure that the user's spreadsheet ratios add up to 100%.
        if ((retirementSavingsRatio + carSavingsRatio + emergencySavingsRatio + higherEducationSavingsRatio + futureTravelSavingsRatio
                + newTechnologySavingsRatio + musicEquipmentSavingsRatio != 1.0)
                || (charityFundsRatio + transportationFundsRatio + foodFundsRatio + unplannedExpenseFundsRatio + entertainmentFundsRatio != 1.0)) {
            tfExtraTextField.setText("Error: Account ratios do not balance to 100%.");
        } else {
            // The following adds the previously-calculated values to a copy of the totals in the user's provided spreadsheet.
            retirementSavings = retirementSavings.add(BigDecimal.valueOf(sheet1.getRow(4).getCell(0).getNumericCellValue()));
            carSavings = carSavings.add(BigDecimal.valueOf(sheet1.getRow(6).getCell(0).getNumericCellValue()));
            emergencySavings = emergencySavings.add(BigDecimal.valueOf(sheet1.getRow(8).getCell(0).getNumericCellValue()));
            higherEducationSavings = higherEducationSavings.add(BigDecimal.valueOf(sheet1.getRow(10).getCell(0).getNumericCellValue()));
            futureTravelSavings = futureTravelSavings.add(BigDecimal.valueOf(sheet1.getRow(12).getCell(0).getNumericCellValue()));
            newTechnologySavings = newTechnologySavings.add(BigDecimal.valueOf(sheet1.getRow(14).getCell(0).getNumericCellValue()));
            musicEquipmentSavings = musicEquipmentSavings.add(BigDecimal.valueOf(sheet1.getRow(16).getCell(0).getNumericCellValue()));

            charityFunds = charityFunds.add(BigDecimal.valueOf(sheet1.getRow(8).getCell(2).getNumericCellValue()));
            transportationFunds = transportationFunds.add(BigDecimal.valueOf(sheet1.getRow(10).getCell(2).getNumericCellValue()));
            foodFunds = foodFunds.add(BigDecimal.valueOf(sheet1.getRow(12).getCell(2).getNumericCellValue()));
            unplannedExpenseFunds = unplannedExpenseFunds.add(BigDecimal.valueOf(sheet1.getRow(14).getCell(2).getNumericCellValue()));
            entertainmentFunds = entertainmentFunds.add(BigDecimal.valueOf(sheet1.getRow(16).getCell(2).getNumericCellValue()));


            // The following updates the appropriate cells in the user's provided spreadsheet.
            sheet1.getRow(4).getCell(0).setCellValue(retirementSavings.doubleValue());
            sheet1.getRow(6).getCell(0).setCellValue(carSavings.doubleValue());
            sheet1.getRow(8).getCell(0).setCellValue(emergencySavings.doubleValue());
            sheet1.getRow(10).getCell(0).setCellValue(higherEducationSavings.doubleValue());
            sheet1.getRow(12).getCell(0).setCellValue(futureTravelSavings.doubleValue());
            sheet1.getRow(14).getCell(0).setCellValue(newTechnologySavings.doubleValue());
            sheet1.getRow(16).getCell(0).setCellValue(musicEquipmentSavings.doubleValue());

            sheet1.getRow(8).getCell(2).setCellValue(charityFunds.doubleValue());
            sheet1.getRow(10).getCell(2).setCellValue(transportationFunds.doubleValue());
            sheet1.getRow(12).getCell(2).setCellValue(foodFunds.doubleValue());
            sheet1.getRow(14).getCell(2).setCellValue(unplannedExpenseFunds.doubleValue());
            sheet1.getRow(16).getCell(2).setCellValue(entertainmentFunds.doubleValue());

            try {
                fileOutputStream = new FileOutputStream(spreadsheet);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                workBook.write(fileOutputStream);
                fileInputStream.close();
                fileOutputStream.close();
                workBook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


            // The following displays the paycheck totals to the user.
            tfGrossIncomeTotal.setText((String.format("$%,4.2f", grossIncomeTotal)));
            tfNetIncomeTotal.setText((String.format("$%,4.2f", netIncomeTotal)));
            tfTitheTotal.setText(String.format("$%,4.2f", titheTotal));
            tfSavingsTotal.setText(String.format("$%,4.2f", savingsTotal));
            tfCheckingTotal.setText(String.format("$%,4.2f", checkingTotal));
            tfRetirementSavings.setText(String.format("$%,4.2f", retirementSavings));
            tfCarSavings.setText(String.format("$%,4.2f", carSavings));
            tfEmergencySavings.setText(String.format("$%,4.2f", emergencySavings));
            tfHigherEducationSavings.setText(String.format("$%,4.2f", higherEducationSavings));
            tfFutureTravelSavings.setText(String.format("$%,4.2f", futureTravelSavings));
            tfNewTechnologySavings.setText(String.format("$%,4.2f", newTechnologySavings));
            tfMusicEquipmentSavings.setText(String.format("$%,4.2f", musicEquipmentSavings));
            tfCharityFunds.setText(String.format("$%,4.2f", charityFunds));
            tfTransportationFunds.setText(String.format("$%,4.2f", transportationFunds));
            tfFoodFunds.setText(String.format("$%,4.2f", foodFunds));
            tfUnplannedExpenseFunds.setText(String.format("$%,4.2f", unplannedExpenseFunds));
            tfEntertainmentFunds.setText(String.format("$%,4.2f", entertainmentFunds));
        }
    }
}
