package controller;

import bo.BoFactory;
import bo.custom.NewRegistrationBO;
import bo.custom.RegistrationsBO;
import com.jfoenix.controls.JFXComboBox;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import util.LoadFxml;
import util.tm.RegistrationTM;

import java.io.IOException;
import java.util.List;

public class RegistrationsFormController {
    private final NewRegistrationBO newRegistrationBO = (NewRegistrationBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.NEW_REGISTRATION);
    private final RegistrationsBO registrationsBO = (RegistrationsBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.REGISTRATIONS);
    public TableView<RegistrationTM> tblStudentRegis;
    public TableColumn colId;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableColumn colDate;
    public JFXComboBox cmbProgramme;
    public AnchorPane context;
    ObservableList<RegistrationTM> obList = FXCollections.observableArrayList();
    String id;

    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        List<String> programmes = newRegistrationBO.getProgrammes();
        cmbProgramme.getItems().addAll(programmes);

        cmbProgramme.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    loadToTable(newValue);
                });
        tblStudentRegis.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            id = newValue.getId();
        });
    }

    private void loadToTable(Object newValue) {
        tblStudentRegis.getItems().clear();
        List<Student> stuList = registrationsBO.getRegisteredStu(newRegistrationBO.getProgramme(newValue.toString()).getId());
        if (stuList.size() == 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "NoOne has registered to this programme...").show();
            return;
        }
        for (Student stu : stuList
        ) {
            obList.add(new RegistrationTM(stu.getId(), stu.getName().getFirstName(), stu.getName().getLastName(), stu.getAddress(), stu.getAge(), stu.getDate()));
        }
        tblStudentRegis.setItems(obList);
    }

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        LoadFxml.loadChildFxml("../view/DashBoard.fxml", actionEvent, context);
    }

    public void deleteOnAction(ActionEvent actionEvent) {

    }
}
