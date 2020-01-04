package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    private TextField tfCarSavings;
    @FXML
    private TextField tfEmergencySavings;
    @FXML
    private TextField tfHigherEducationSavings;
    @FXML
    private TextField tfFutureTravelSavings;
    @FXML
    private TextField tfNewTechnologySavings;
    @FXML
    private TextField tfMusicEquipmentSavings;
    @FXML
    private TextField tfCharityFunds;
    @FXML
    private TextField tfTransportationFunds;
    @FXML
    private TextField tfFoodFunds;
    @FXML
    private TextField tfUnplannedExpenseFunds;
    @FXML
    private TextField tfEntertainmentFunds;
    @FXML
    private TextField tfExtraTextField = new TextField("Click the calculate button to distribute funds:");

    private FileChooser fileChooser = new FileChooser();
    private File spreadsheet;
    private FileInputStream fileInputStream = null;
    private FileOutputStream fileOutputStream = null;
    private XSSFWorkbook workBook;
    private XSSFSheet sheet1;

    public void initialize(URL location, ResourceBundle resources) {

    }
}
