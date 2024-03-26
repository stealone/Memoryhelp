package com.lifesoft.memoryhelp.application;

import com.lifesoft.memoryhelp.controls.MainController;
import com.lifesoft.memoryhelp.gui.components.MHDialogBox;
import com.lifesoft.memoryhelp.gui.strategies.ConfirmedMessage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class MemoryHelp extends Application {
    private ResourceBundle resources;
    public static Locale local = Locale.getDefault();
    private ResourceBundle applicationResources;
    private Stage mainStage;

    private Scene mainScene;

    private static MemoryHelp instance;

    private static MainController mainControllerInstance;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent rootNode = loadFXML("MainView");
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        this.mainStage = primaryStage;
        mainStage.setX(screenSize.getMinX());
        mainStage.setY(screenSize.getMinY());
        mainStage.setWidth(screenSize.getWidth());
        mainStage.setHeight(screenSize.getHeight());
        mainStage.setTitle("Memory Help");

        mainScene = new Scene(rootNode);
        mainStage.setScene(mainScene);
        mainStage.sizeToScene();
        mainStage.getIcons().add(new Image(MemoryHelp.class.getResourceAsStream("/com/lifesoft/memoryhelp/imgs/memory help icon.png")));
        mainStage.setOnCloseRequest(event -> {
            event.consume();
            doCloseMemoryHelp();
        });
        mainStage.show();
    }

    public static void main(String[] args) {
        Thread starterThread = new Thread(() -> {
            launch(args);
        });
        starterThread.start();
    }

    private Parent loadFXML(String xmlFileName) throws IOException {
        //Tell the FXMLLoader where the FXML file is
        URL fxmlLocation = MemoryHelp.class.getResource("/com/lifesoft/memoryhelp/fxml/" + xmlFileName + ".fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxmlLocation);
        fxmlLoader.setResources(resources);
        Parent root = fxmlLoader.load();
        mainControllerInstance = fxmlLoader.getController();
        mainControllerInstance.run();
        return root;
    }

    public void init() throws NoSuchMethodException {
        applicationResources = ResourceBundle.getBundle("com.lifesoft.memoryhelp.i18n.Application");
        setLocale(applicationResources.getString("applicationLanguage"));
        resources = ResourceBundle.getBundle("com.lifesoft.memoryhelp.i18n.Memoryhelp", local);

//        try {
//            service.initDbConnection();
//            dataModel.setService(service);
//        } catch (DriverException ex) {
//            MHDialogBox.getInstance().setMessageType(new WarnningMessage()).showMessage(resources.getString("driverNotFoundMsgTextKey"));
//        } catch (WrongConnectionUserException ex) {
//            MHDialogBox.getInstance().setMessageType(new WarnningMessage()).showMessage(resources.getString("wrongUserNameMsgTextKey"));
//        }
        instance = this;
    }

    public static void setLocale(String localString) {
        local = localString.equals("en") ? Locale.ENGLISH : Locale.FRANCE;
    }

    public static MemoryHelp getInstance() {
//        if (instance == null) {
//            synchronized (MemoryHelp.class) {
//                instance = new MemoryHelp();
//            }
//        }
        return instance;
    }

    public static Locale getLocale() {
        return local;
    }

    public Stage getMainStage() {
        return this.mainStage;
    }

    public Scene getMainScence() {
        return this.mainScene;
    }

    public void doCloseMemoryHelp() {
        Optional<ButtonType> option = (Optional<ButtonType>) MHDialogBox.getInstance().setMessageType(new ConfirmedMessage()).showMessage(resources.getString("closingConfirmationMsgTextKey"));
        if (option.get() == ButtonType.YES) {
            mainControllerInstance.shotDown();
            //déconnexion
            //service.closeDbConnection();

            //libération des ressources
            //service = null;
            //dataModel = null;

            //fermeture de la fenêtre
            mainStage.hide();
            Platform.exit();
        }
    }
}