package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @FXML
    private TextField tfGrossIncomeTotal;
    @FXML
    private TextField tfNetIncomeTotal;
    @FXML
    private TextField tfTitheTotal;
    @FXML
    private TextField tfSavingsTotal;
    @FXML
    private TextField tfCheckingTotal;
    @FXML
    private TextField tfRetirementSavings;
    @FXML
    private TextField tfCarReplacementSavings;
    @FXML
    private TextField tfCarMaintenanceAndRepairSavings;
    @FXML
    private TextField tfEmergencySavings;
    @FXML
    private TextField tfRealEstateSavings;
    @FXML
    private TextField tfFutureTravelSavings;
    @FXML
    private TextField tfNewTechnologySavings;
    @FXML
    private TextField tfCharityFunds;
    @FXML
    private TextField tfTransportationFunds;
    @FXML
    private TextField tfFoodFunds;
    @FXML
    private TextField tfEntertainmentFunds;
    @FXML
    private TextField tfUnplannedExpenseFunds;
    @FXML
    private Label errorLabel;

    private Stage stage;
    private FileChooser fileChooser = new FileChooser();
    private File spreadsheet;
    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;
    private XSSFWorkbook workBook;
    private XSSFSheet sheet1;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initialize(URL location, ResourceBundle resources) {
        // The following displays to users an initial pop-up window for selecting an Excel spreadsheet file.
        fileChooser.setTitle("Open Excel Spreadsheet");
        spreadsheet = fileChooser.showOpenDialog(this.stage);

        // The following try-catch blocks are for spreadsheet I/O to an Excel spreadsheet.
        try {
            fileInputStream = new FileInputStream(spreadsheet);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            workBook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // This retrieves the user's selected Excel spreadsheet.
        sheet1 = workBook.getSheetAt(0);
    }

    public void handleDistributeFundsClick() {
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
        double carReplacementSavingsRatio = Double.parseDouble(sheet1.getRow(5).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward vehicle replacement.
        BigDecimal carReplacementSavings = savingsTotal.multiply(BigDecimal.valueOf(carReplacementSavingsRatio));

        // This defines the ratio for this particular field.
        double carMaintenanceAndRepairSavingsRatio = Double.parseDouble(sheet1.getRow(7).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward vehicle maintenance and repair.
        BigDecimal carMaintenanceAndRepairSavings = savingsTotal.multiply(BigDecimal.valueOf(carMaintenanceAndRepairSavingsRatio));

        // This defines the ratio for this particular field.
        double emergencySavingsRatio = Double.parseDouble(sheet1.getRow(9).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward the emergency fund.
        BigDecimal emergencySavings = savingsTotal.multiply(BigDecimal.valueOf(emergencySavingsRatio));

        // This defines the ratio for this particular field.
        double realEstateSavingsRatio = Double.parseDouble(sheet1.getRow(11).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward real estate planning and funding.
        BigDecimal realEstateSavings = savingsTotal.multiply(BigDecimal.valueOf((realEstateSavingsRatio)));

        // This defines the ratio for this particular field.
        double futureTravelSavingsRatio = Double.parseDouble(sheet1.getRow(13).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward future trip expenses.
        BigDecimal futureTravelSavings = savingsTotal.multiply(BigDecimal.valueOf(futureTravelSavingsRatio));

        // This defines the ratio for this particular field.
        double newTechnologySavingsRatio = Double.parseDouble(sheet1.getRow(15).getCell(0)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from savings toward new devices.
        BigDecimal newTechnologySavings = savingsTotal.multiply(BigDecimal.valueOf(newTechnologySavingsRatio));


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
        double entertainmentFundsRatio = Double.parseDouble(sheet1.getRow(13).getCell(2)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from checking toward an entertainment fund.
        BigDecimal entertainmentFunds = checkingTotal.multiply(BigDecimal.valueOf(entertainmentFundsRatio));

        // This defines the ratio for this particular field.
        double unplannedExpenseFundsRatio = Double.parseDouble(sheet1.getRow(15).getCell(2)
                .getStringCellValue().split("\\(")[1].replaceAll("%", "").replaceAll("\\)", "")) / 100;

        // This calculates the amount to be allotted from checking toward unplanned expense funds.
        BigDecimal unplannedExpenseFunds = checkingTotal.multiply(BigDecimal.valueOf(unplannedExpenseFundsRatio));


        // This adds back the tithe to the checking account.
        checkingTotal = checkingTotal.add(titheTotal);


        // The following checks to ensure that the user's spreadsheet ratios add up to 100%.
        if ((retirementSavingsRatio + carReplacementSavingsRatio + carMaintenanceAndRepairSavingsRatio
                + emergencySavingsRatio + realEstateSavingsRatio + futureTravelSavingsRatio + newTechnologySavingsRatio != 1.0)
                || (charityFundsRatio + transportationFundsRatio + foodFundsRatio + entertainmentFundsRatio + unplannedExpenseFundsRatio != 1.0)) {
            errorLabel.setText("Error: Account ratios do not balance to 100%.");
            errorLabel.setTextFill(Color.ORANGERED);
        } else {
            // The following resets the error label's text.
            errorLabel.setText("");
            errorLabel.setTextFill(Color.BLACK);

            // The following adds the previously-calculated values to a copy of the totals in the user's provided spreadsheet.
            retirementSavings = retirementSavings.add(BigDecimal.valueOf(sheet1.getRow(4).getCell(0).getNumericCellValue()));
            carReplacementSavings = carReplacementSavings.add(BigDecimal.valueOf(sheet1.getRow(6).getCell(0).getNumericCellValue()));
            carMaintenanceAndRepairSavings = carMaintenanceAndRepairSavings.add(BigDecimal.valueOf(sheet1.getRow(8).getCell(0).getNumericCellValue()));
            emergencySavings = emergencySavings.add(BigDecimal.valueOf(sheet1.getRow(10).getCell(0).getNumericCellValue()));
            realEstateSavings = realEstateSavings.add(BigDecimal.valueOf(sheet1.getRow(12).getCell(0).getNumericCellValue()));
            futureTravelSavings = futureTravelSavings.add(BigDecimal.valueOf(sheet1.getRow(14).getCell(0).getNumericCellValue()));
            newTechnologySavings = newTechnologySavings.add(BigDecimal.valueOf(sheet1.getRow(16).getCell(0).getNumericCellValue()));

            charityFunds = charityFunds.add(BigDecimal.valueOf(sheet1.getRow(8).getCell(2).getNumericCellValue()));
            transportationFunds = transportationFunds.add(BigDecimal.valueOf(sheet1.getRow(10).getCell(2).getNumericCellValue()));
            foodFunds = foodFunds.add(BigDecimal.valueOf(sheet1.getRow(12).getCell(2).getNumericCellValue()));
            entertainmentFunds = entertainmentFunds.add(BigDecimal.valueOf(sheet1.getRow(14).getCell(2).getNumericCellValue()));
            unplannedExpenseFunds = unplannedExpenseFunds.add(BigDecimal.valueOf(sheet1.getRow(16).getCell(2).getNumericCellValue()));


            // The following updates the appropriate cells in the user's provided spreadsheet.
            sheet1.getRow(4).getCell(0).setCellValue(retirementSavings.doubleValue());
            sheet1.getRow(6).getCell(0).setCellValue(carReplacementSavings.doubleValue());
            sheet1.getRow(8).getCell(0).setCellValue(carMaintenanceAndRepairSavings.doubleValue());
            sheet1.getRow(10).getCell(0).setCellValue(emergencySavings.doubleValue());
            sheet1.getRow(12).getCell(0).setCellValue(realEstateSavings.doubleValue());
            sheet1.getRow(14).getCell(0).setCellValue(futureTravelSavings.doubleValue());
            sheet1.getRow(16).getCell(0).setCellValue(newTechnologySavings.doubleValue());

            sheet1.getRow(8).getCell(2).setCellValue(charityFunds.doubleValue());
            sheet1.getRow(10).getCell(2).setCellValue(transportationFunds.doubleValue());
            sheet1.getRow(12).getCell(2).setCellValue(foodFunds.doubleValue());
            sheet1.getRow(14).getCell(2).setCellValue(entertainmentFunds.doubleValue());
            sheet1.getRow(16).getCell(2).setCellValue(unplannedExpenseFunds.doubleValue());

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
            tfCarReplacementSavings.setText(String.format("$%,4.2f", carReplacementSavings));
            tfCarMaintenanceAndRepairSavings.setText(String.format("$%,4.2f", carMaintenanceAndRepairSavings));
            tfEmergencySavings.setText(String.format("$%,4.2f", emergencySavings));
            tfRealEstateSavings.setText(String.format("$%,4.2f", realEstateSavings));
            tfFutureTravelSavings.setText(String.format("$%,4.2f", futureTravelSavings));
            tfNewTechnologySavings.setText(String.format("$%,4.2f", newTechnologySavings));
            tfCharityFunds.setText(String.format("$%,4.2f", charityFunds));
            tfTransportationFunds.setText(String.format("$%,4.2f", transportationFunds));
            tfFoodFunds.setText(String.format("$%,4.2f", foodFunds));
            tfEntertainmentFunds.setText(String.format("$%,4.2f", entertainmentFunds));
            tfUnplannedExpenseFunds.setText(String.format("$%,4.2f", unplannedExpenseFunds));
        }
    }
}
