package util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class LoadFxml {
    public static void chooseFxml(String address, ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(FXMLLoader.load(LoadFxml.class.getResource(address))));
        stage1.initStyle(StageStyle.UNDECORATED);
        stage1.show();

    }

    public static void chooseFxml1(String address, ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(LoadFxml.class.getResource(address))));
        stage.show();
    }

    public static void loadChildFxml(String address, ActionEvent actionEvent, Pane context1) throws IOException {
        URL resource = LoadFxml.class.getResource(address);
        Parent load = FXMLLoader.load(resource);
        context1.getChildren().clear();
        context1.getChildren().add(load);
    }

}
