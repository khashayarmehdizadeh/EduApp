package Main.controller;

import Main.model.bl.StudentBl;

import Main.model.bl.TeacherBl;
import Main.model.da.StudentDa;
import Main.model.da.TeacherDa;
import Main.model.entity.Student;
import Main.model.entity.Teacher;
import Main.model.entity.enums.City;
import Main.model.entity.enums.Course;
import Main.model.entity.enums.Gender;
import Main.model.tools.Validator;
import Main.view.WindowsManager;
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

@Log4j

public class EduController implements Initializable {
    @FXML
    private TextField idTxt, nameTxt, familyTxt, mailTxt, phoneNumberTxt, addressTxt,searchTxt;
    @FXML
    private DatePicker birthDate;
    @FXML
    private ComboBox <String>genderCmb;
    @FXML
    private ComboBox <String>cityCmb;
    @FXML
    private ComboBox <String> courseCmb;
    @FXML
    private Button saveBtn, editBtn, removeBtn;
    @FXML
    private TableView<Student> tableStudent;
    @FXML
    private TableColumn<Student, Integer> idCol;

    @FXML
    private TableColumn<Student, String> nameCol, familyCol,courseCol;
    @FXML
    private  MenuItem closeMnu,newMnu,aboutMnu;
    //for teachercontroller
    @FXML
    private TextField idtTxt,nametTxt,familytTxt,mailetTxt,skilltTxt,phonenumbertTxt,addresstTxt,searchtTxt;
    @FXML
    private DatePicker birthdatetTxt;
    @FXML
    private ComboBox<String>gendertCmb;
    @FXML
    private ComboBox<String>citytCmb;
    @FXML
    private ComboBox<String>coursetCmb;
    @FXML
    private Button savetBtn,edittBtn,removetBtn;
    @FXML
    private TableView<Teacher>tabaleTeacher;
    @FXML
    private TableColumn<Teacher,Integer> idtCol;
    @FXML
    private TableColumn<Teacher,String> nametCol,familytCol,skilltCol,coursetCol;





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.info("App started");
        for (Course value : Course.values()) {
            courseCmb.getItems().add(value.name());
        }
        for (Gender value : Gender.values()) {
            genderCmb.getItems().add(value.name());
        }
        genderCmb.getSelectionModel().select(0);
        for (City value : City.values()) cityCmb.getItems().add(value.name());
        try {
            resetForm();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Load Error\n" + e.getMessage());
            alert.show();

        }
        for (Course value : Course.values()) {
            coursetCmb.getItems().add(value.name());
        }
        for (Gender value : Gender.values()) {
            gendertCmb.getItems().add(value.name());
        }
        citytCmb.getSelectionModel().select(0);
        for (City value : City.values()) citytCmb.getItems().add(value.name());
        try {
            resetForm();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Load Error\n" + e.getMessage());
            alert.show();

        }
        newMnu.setOnAction(event -> {
            try {
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, " Load Error\n" + e.getMessage());
                alert.show();
            }
        });

        closeMnu.setOnAction((event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?");
            if (alert.showAndWait().get().equals(ButtonType.OK)) {
                Platform.exit();
            }
        }));
        aboutMnu.setOnAction((event) -> {
            try {
                WindowsManager.showAboutForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, " Load Error\n" + e.getMessage());
                alert.show();
            }
        });
        savetBtn.setOnAction(event -> {
            try {
                Teacher teacher = Teacher
                        .builder()
                        .name(Validator.nameValidator(nametTxt.getText(), "Invalid Name"))
                        .family(Validator.nameValidator(familytTxt.getText(), "Invalid Family"))
                        .city(City.valueOf(citytCmb.getSelectionModel().getSelectedItem()))
                        .email(mailetTxt.getText())
                        .phoneNumber(phonenumbertTxt.getText())
                        .address(addresstTxt.getText())
                        .skills(skilltTxt.getText())
                        .gender(Gender.valueOf(gendertCmb.getSelectionModel().getSelectedItem()))
                        .course(Course.valueOf(coursetCmb.getSelectionModel().getSelectedItem()))
                        .birthDate(birthdatetTxt.getValue())
                        .build();
                TeacherBl.getTeacherBl().save(teacher);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "save\n" + teacher);
                alert.show();
                resetForm();
                log.info("teacher saved" + teacher);


            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Teacher Error\n" + e.getMessage());
                alert.show();
                log.error("save error:" + e.getMessage());


            }
        });
        edittBtn.setOnAction(event -> {
            try {
                Teacher teacher = Teacher
                        .builder()
                        .name(Validator.nameValidator(nametTxt.getText(), "Invalid Name"))
                        .family(Validator.nameValidator(familytTxt.getText(), "Invalid Family"))
                        .city(City.valueOf(citytCmb.getSelectionModel().getSelectedItem()))
                        .email(mailetTxt.getText())
                        .phoneNumber(phonenumbertTxt.getText())
                        .address(addresstTxt.getText())
                        .skills(skilltTxt.getText())
                        .gender(Gender.valueOf(gendertCmb.getSelectionModel().getSelectedItem()))
                        .course(Course.valueOf(coursetCmb.getSelectionModel().getSelectedItem()))
                        .birthDate(birthdatetTxt.getValue())
                        .build();
                TeacherBl.getTeacherBl().edit(teacher);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "student edited\n" + teacher);
                alert.show();
                resetForm();
                log.info("Teacher Edited" + teacher);


            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Teacher eit error\n" + e.getMessage());
                alert.show();
                log.error("Edit Error" + e.getMessage());


            }

        });
        removetBtn.setOnAction(event -> {
            try {
                TeacherBl.getTeacherBl().remove(Integer.parseInt(idTxt.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, " teacher Removed\n" + idTxt.getText());
                alert.show();
                log.info("teacher Removed " + idTxt.getText());
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, " teacher Remove Error\n" + e.getMessage());
                alert.show();

            }


        });

        saveBtn.setOnAction(event -> {
            try {
                Student student = Student
                        .builder()
                        .name(Validator.nameValidator(nameTxt.getText(), "Invalid Name"))
                        .family(Validator.nameValidator(familyTxt.getText(), "Invalid Family"))
                        .city(City.valueOf( cityCmb.getSelectionModel().getSelectedItem()))
                        .email(mailTxt.getText())
                        .phoneNumber(phoneNumberTxt.getText())
                        .address(addressTxt.getText())
                        .gender(Gender.valueOf( genderCmb.getSelectionModel().getSelectedItem()))
                        .course(Course.valueOf( courseCmb.getSelectionModel().getSelectedItem()))
                        .birthDate(birthDate.getValue())
                        .build();
                StudentBl.getStudentBl().save(student);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "save\n" + student);
                alert.show();
                resetForm();
                log.info("student saved" + student);


            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Student Error\n" + e.getMessage());
                alert.show();
                log.error("save error:" + e.getMessage());


            }
        });
        editBtn.setOnAction(event -> {
            try {
                Student student = Student.builder()
                        .id(Integer.parseInt(idTxt.getText()))
                        .name(Validator.nameValidator(nameTxt.getText(), "Invalid Name"))
                        .family(Validator.nameValidator(familyTxt.getText(), "Invalid Family"))
                        .city(City.valueOf( cityCmb.getSelectionModel().getSelectedItem()))
                        .email(mailTxt.getText())
                        .phoneNumber(phoneNumberTxt.getText())
                        .address(addressTxt.getText())
                        .gender(Gender.valueOf( genderCmb.getSelectionModel().getSelectedItem()))
                        .course(Course.valueOf( courseCmb.getSelectionModel().getSelectedItem()))
                        .birthDate(birthDate.getValue())
                        .build();
                StudentBl.getStudentBl().edit(student);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "student edited\n" + student);
                alert.show();
                resetForm();
                log.info("Student Edited"+student);


            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Student eit error\n" + e.getMessage());
                alert.show();
                log.error("Edit Error"+e.getMessage());


            }

        });
        removeBtn.setOnAction(event -> {
            try {
                StudentBl.getStudentBl().remove(Integer.parseInt(idTxt.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, " student Removed\n" + idTxt.getText());
                alert.show();
                log.info("student Removed " + idTxt.getText());
                resetForm();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, " student Remove Error\n" + e.getMessage());
                alert.show();

            }


        });
        searchTxt.setOnKeyReleased((event) -> {
            try (StudentDa studentDa = new StudentDa()) {
                showDataOnTable(studentDa.findByFamily(searchTxt.getText()));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, " student\n" + e.getMessage());
                alert.show();
            }
        });
        tableStudent.setOnMouseClicked((event) -> {
            Student student = tableStudent.getSelectionModel().getSelectedItem();
            idTxt.setText(String.valueOf(student.getId()));
            nameTxt.setText(student.getName());
            familyTxt.setText(student.getFamily());
            birthDate.setValue(student.getBirthDate());
            genderCmb.getSelectionModel().select(student.getGender().ordinal());
            cityCmb.getSelectionModel().select(student.getCity().ordinal());
            phoneNumberTxt.setText(student.getPhoneNumber());
            addressTxt.setText(student.getAddress());
            mailTxt.setText(student.getEmail());
            courseCmb.getSelectionModel().select(student.getCourse().ordinal());

        });
//        searchtTxt.setOnKeyReleased((event) -> {
//            try (TeacherDa teacherDa = new TeacherDa()) {
//                showDataOnTable(teacherDa.findByFamily(searchtTxt.getText()));
//            } catch (Exception e) {
//                Alert alert = new Alert(Alert.AlertType.ERROR, " teacher\n" + e.getMessage());
//                alert.show();
//            }
//        });
        tabaleTeacher.setOnMouseClicked((event) -> {
            Teacher teacher = tabaleTeacher.getSelectionModel().getSelectedItem();
            idtTxt.setText(String.valueOf(teacher.getId()));
            nametTxt.setText(teacher.getName());
            familytTxt.setText(teacher.getFamily());
            birthdatetTxt.setValue(teacher.getBirthDate());
            skilltTxt.setText(teacher.getSkills());
            gendertCmb.getSelectionModel().select(teacher.getGender().ordinal());
            citytCmb.getSelectionModel().select(teacher.getCity().ordinal());
            phonenumbertTxt.setText(teacher.getPhoneNumber());
            addresstTxt.setText(teacher.getAddress());
            mailetTxt.setText(teacher.getEmail());
            coursetCmb.getSelectionModel().select(teacher.getCourse().ordinal());

        });
    }
//    private void showDataOnTable(List<Teacher> teacherList) {
//        ObservableList<Teacher> observableList = FXCollections.observableList(teacherList);
//
//        idtCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//        nametCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//        familytCol.setCellValueFactory(new PropertyValueFactory<>("family"));
//        coursetCol.setCellValueFactory(new PropertyValueFactory<>("course"));
//        skilltCol.setCellValueFactory(new PropertyValueFactory<>("course"));
//
//        tabaleTeacher.setItems(observableList);
//    }


    private void resetForm() throws Exception {
        idTxt.clear();
        nameTxt.clear();
        familyTxt.clear();
        birthDate.setValue(null);
        cityCmb.getSelectionModel().select(0);
        courseCmb.getSelectionModel().select(0);
        mailTxt.clear();
        addressTxt.clear();
        phoneNumberTxt.clear();
        idtTxt.clear();
        nametTxt.clear();
        familytTxt.clear();

        showDataOnTable(StudentBl.getStudentBl().findAll());


    }

    private void showDataOnTable(List<Student> studentList) {
        ObservableList<Student> observableList = FXCollections.observableList(studentList);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        familyCol.setCellValueFactory(new PropertyValueFactory<>("family"));
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        tableStudent.setItems(observableList);
    }




}

