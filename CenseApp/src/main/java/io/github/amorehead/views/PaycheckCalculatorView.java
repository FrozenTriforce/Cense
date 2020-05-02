package io.github.amorehead.views;

import com.gluonhq.charm.glisten.mvc.View;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class PaycheckCalculatorView {

    public View getView() {
        try {
            View view = FXMLLoader.load(PaycheckCalculatorView.class.getResource("paycheck-calculator.fxml"));
            return view;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
            return new View();
        }
    }
}
