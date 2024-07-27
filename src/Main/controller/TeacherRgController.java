package Main.controller;


import Main.model.bl.StudentBl;
import Main.model.bl.TeacherBl;
import Main.model.entity.Student;
import Main.model.entity.Teacher;
import Main.model.entity.enums.City;
import Main.model.entity.enums.Course;
import Main.model.entity.enums.Gender;
import Main.model.tools.Validator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.log4j.Log4j;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;
@Log4j
public class TeacherRgController implements Initializable {
    @FXML
    private TextField idtTxt, nametTxt, familytTxt, citytTxt, phonenumbertTxt, mailtxt, addresstTxt, skilltTxt;
    @FXML
    private DatePicker birthdatetTxt;
    @FXML
    private ComboBox<String> gendertTxt;
    @FXML
    private ComboBox<String> citytCmb;
    @FXML
    private ComboBox<String> courseteCmb;
    @FXML
    private Button savetBtn, edittBtn, removetBtn;
    @FXML
    private TableView<Teacher> teacherTable;
    @FXML
    private TableColumn<Teacher, Integer> idtCol;
    @FXML
    private TableColumn<Teacher, String> nametCol, familytCol, coursetCol, skilltCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("App started");
        for (Course value : Course.values()) {
            courseteCmb.getItems().add(value.name());
        }
        for (Gender value : Gender.values()) {
            gendertTxt.getItems().add(value.name());
        }
        citytCmb.getSelectionModel().select(0);
        for (City value : City.values()) citytCmb.getItems().add(value.name());
        try {
            resetForm();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Load Error\n" + e.getMessage());
            alert.show();

        }
        savetBtn.setOnAction(event -> {
            try {
                Teacher teacher = Teacher
                        .builder()
                        .name(Validator.nameValidator(nametTxt.getText(), "Invalid Name"))
                        .family(Validator.nameValidator(familytTxt.getText(), "Invalid Family"))
                        .city(String.valueOf(City.valueOf(citytCmb.getSelectionModel().getSelectedItem())))
                        .email(mailtxt.getText())
                        .skills(skilltTxt.getText())
                        .phoneNumber(phonenumbertTxt.getText())
                        .address(addresstTxt.getText())
                        .gender(Gender.valueOf(gendertTxt.getSelectionModel().getSelectedItem()))
                        .course(Course.valueOf(courseteCmb.getSelectionModel().getSelectedItem()))
                        .birthDate(birthdatetTxt.getValue())
                        .build();
                TeacherBl.getTeacherBl().save(teacher);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "save\n" + teacher);
                alert.show();
                resetForm();
                log.info("teacher saved" + teacher);


            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "teacher Error\n" + e.getMessage());
                alert.show();
                log.error("save error:" + e.getMessage());


            }
        });
        edittBtn.setOnAction(event -> {
            try {
                Teacher teacher = Teacher.builder()
                        .id(Integer.parseInt(idtTxt.getText()))
                        .name(Validator.nameValidator(nametTxt.getText(), "Invalid Name"))
                        .family(Validator.nameValidator(familytTxt.getText(), "Invalid Family"))
                        .skills(skilltTxt.getText())
                        .city(City.valueOf( citytCmb.getSelectionModel().getSelectedItem()))
                        .email(mailtxt.getText())
                        .phoneNumber(phonenumbertTxt.getText())
                        .address(addresstTxt.getText())
                        .gender(Gender.valueOf( gendertTxt.getSelectionModel().getSelectedItem()))
                        .course(Course.valueOf( courseteCmb.getSelectionModel().getSelectedItem()))
                        .birthDate(birthdatetTxt.getValue())
                        .build();
                TeacherBl.getTeacherBl().edit(teacher);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "teacher edited\n" + teacher);
                alert.show();
                resetForm();
                log.info("Teacher Edited"+teacher);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Teacher eit error\n" + e.getMessage());
                alert.show();
                log.error("Edit Error"+e.getMessage());


            }

        });

        teacherTable.setOnMouseClicked((event) -> {
            Teacher teacher = teacherTable.getSelectionModel().getSelectedItem();
            idtTxt.setText(String.valueOf(teacher.getId()));
            nametTxt.setText(teacher.getName());
            familytTxt.setText(teacher.getFamily());
            birthdatetTxt.setValue(teacher.getBirthDate());
            gendertTxt.getSelectionModel().select(teacher.getGender().ordinal());
            citytCmb.getSelectionModel().select(teacher.getCity().ordinal());
            phonenumbertTxt.setText(teacher.getPhoneNumber());
            addresstTxt.setText(teacher.getAddress());
            mailtxt.setText(teacher.getEmail());
            courseteCmb.getSelectionModel().select(teacher.getCourse().ordinal());

        });

    }
    private void showDataOnTable(List< Student > teacherList) {
        ObservableList<Student> observableList = FXCollections.observableList(teacherList);

        idtCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nametCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        familytCol.setCellValueFactory(new PropertyValueFactory<>("family"));
        coursetCol.setCellValueFactory(new PropertyValueFactory<>("course"));
        skilltCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        TableColumn.setItem(observableList);

    }
    private void resetForm() throws Exception {
        idtTxt.clear();
        nametTxt.clear();
        familytTxt.clear();
        birthdatetTxt.setValue(null);
        citytCmb.getSelectionModel().select(0);
        courseteCmb.getSelectionModel().select(0);
        mailtxt.clear();
        addresstTxt.clear();
        skilltTxt.clear();
        phonenumbertTxt.clear();

        showDataOnTable(TeacherBl.getTeacherBl().findAll());


    }
}
