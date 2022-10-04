package controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import util.LoadFxml;

import java.io.IOException;

public class DashBoardController {
    public AnchorPane context;

    public void newRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        LoadFxml.loadChildFxml("../view/NewRegistrationForm.fxml", actionEvent, context);
    }

    public void programmesOnAction(ActionEvent actionEvent) throws IOException {
        LoadFxml.loadChildFxml("../view/NewProgrammeForm.fxml", actionEvent, context);

    }

    public void registrationsOnAction(ActionEvent actionEvent) throws IOException {
        LoadFxml.loadChildFxml("../view/RegistrationsForm.fxml", actionEvent, context);
    }
}
