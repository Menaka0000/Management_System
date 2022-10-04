package controller;

import bo.BoFactory;
import bo.custom.NewRegistrationBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.NewRegistrationDTO;
import entity.Name;
import entity.Programme;
import entity.Registration;
import entity.Student;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import util.LoadFxml;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NewRegistrationFormController {

    private final NewRegistrationBO newRegistrationBO = (NewRegistrationBO) BoFactory.getBoFactory().getBO(BoFactory.BoTypes.NEW_REGISTRATION);

    public AnchorPane context1;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtAddress;
    public JFXTextField txtAge;
    public JFXTextField txtDate;
    public JFXTextField txtTime;
    public JFXComboBox cmbProgramme;
    public JFXComboBox cmbGender;
    public JFXTextField txtId;
    public JFXTextField txtReId;

    public void initialize() {
        List<String> programmes = newRegistrationBO.getProgrammes();
        cmbProgramme.getItems().addAll(programmes);

        String[] name = {"Male", "Female"};
        cmbGender.getItems().addAll(new ArrayList(Arrays.asList(name)));
        setDateNTime();

        txtId.textProperty().addListener((observable, oldValue, newValue) -> {
            /* System.out.println("textField changed from " + oldValue + " to " + newValue);*/
            loadData(newValue);
        });

    }

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        LoadFxml.loadChildFxml("../view/DashBoard.fxml", actionEvent, context1);

    }

    public void saveOnAction(ActionEvent actionEvent) {

        if (cmbGender.getValue() == null || cmbProgramme.getValue() == null) {
            new Alert(Alert.AlertType.WARNING, "Some fields are empty").show();
            return;
        }

        List<Programme> registeredPro = newRegistrationBO.getRegisteredPro(txtId.getText());

        if (registeredPro.size() == 0) {
            if (newRegistrationBO.newRegistration(new NewRegistrationDTO(new Registration(new Student(txtId.getText(), new Name(txtFirstName.getText(), txtLastName.getText()), txtAddress.getText(), Integer.parseInt(txtAge.getText()), (String) cmbGender.getValue(),
                    txtDate.getText(), txtTime.getText(), null), newRegistrationBO.getProgramme((String) cmbProgramme.getValue()), txtDate.getText(), txtTime.getText())))) {
                new Alert(Alert.AlertType.CONFIRMATION, txtId.getText() + " student has been registered successfully...").show();
                return;
            }
        }
        for (Programme pro : registeredPro
        ) {
            List proList = new ArrayList();
            for (Programme programme : registeredPro
            ) {
                proList.add(programme.getName());
            }
            if (pro.getName().equals(cmbProgramme.getValue())) {
                new Alert(Alert.AlertType.WARNING, "This student has already registered to this programme \n" +
                        " Please select a program instead of below programmes \n" + proList).show();
                return;
            }
        }

        if (newRegistrationBO.newReForExistingStu(new NewRegistrationDTO(new Registration(new Student(txtId.getText(), new Name(txtFirstName.getText(), txtLastName.getText()), txtAddress.getText(), Integer.parseInt(txtAge.getText()), (String) cmbGender.getValue(),
                txtDate.getText(), txtTime.getText(), null), newRegistrationBO.getProgramme((String) cmbProgramme.getValue()), txtDate.getText(), txtTime.getText())))) {
            new Alert(Alert.AlertType.CONFIRMATION, txtId.getText() + " student has been registered to an another programme successfully...").show();
        }


    }

    private void setDateNTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("a");
        String timeNow = sdf.format(new Date());
        txtDate.setText(f.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            txtTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond() + "  " + timeNow
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    private void loadData(String id) {
        try {
            Student studentDetail = newRegistrationBO.getStudentDetail(id);
            txtFirstName.setText(studentDetail.getName().getFirstName());
            txtLastName.setText(studentDetail.getName().getLastName());
            txtAge.setText(String.valueOf(studentDetail.getAge()));
            txtAddress.setText(studentDetail.getAddress());
        } catch (NullPointerException e) {
            System.out.println("Invalid ID");
        }
    }
}
