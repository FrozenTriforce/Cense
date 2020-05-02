package io.github.amorehead;

import io.github.amorehead.views.HomeView;
import io.github.amorehead.views.PaycheckCalculatorView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Cense extends MobileApplication {

    public static final String MAIN_VIEW = HOME_VIEW;
    public static final String WELCOME_VIEW = "Welcome View";
    
    @Override
    public void init() {
        addViewFactory(MAIN_VIEW, () -> new HomeView().getView());
        addViewFactory(WELCOME_VIEW, () -> new PaycheckCalculatorView().getView());

        DrawerManager.buildDrawer(this);
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

        scene.getStylesheets().add(Cense.class.getResource("style.css").toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Cense.class.getResourceAsStream("/icon.png")));
    }
}
