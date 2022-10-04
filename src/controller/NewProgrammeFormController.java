package controller;

import bo.BoFactory;
import bo.custom.NewProgrammeBO;
import com.jfoenix.controls.JFXTextField;
import dto.ProgrammeDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import util.LoadFxml;

import java.io.IOException;

public class NewProgrammeFormController {
    private final NewProgrammeBO newProgrammeBO = (NewProgrammeBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.NEW_PROGRAMME);

    public JFXTextField txtId;
    public JFXTextField txtProgrammeName;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public AnchorPane context2;

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        LoadFxml.loadChildFxml("../view/DashBoard.fxml", actionEvent, context2);
    }

    public void saveOnAction(ActionEvent actionEvent) {
        ProgrammeDTO programmeDTO = new ProgrammeDTO(txtId.getText(), txtProgrammeName.getText(), txtDuration.getText(), Double.parseDouble(txtFee.getText()), null);
        if (newProgrammeBO.saveProgramme(programmeDTO)) {
            new Alert(Alert.AlertType.CONFIRMATION, txtProgrammeName.getText() + " programme was saved successfully").show();
        }
    }
}
