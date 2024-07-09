package Main.controller;

import Main.model.da.StudentDa;
import Main.model.entity.Student;
import Main.model.entity.enums.City;
import Main.model.entity.enums.Gender;
import Main.model.tools.Validator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class EduContoroller implements Initializable {
    @FXML
    private TextField idTxt, nameTxt, familyTxt, mailTxt, phoneNumberTxt, addressTxt;
    @FXML
    private DatePicker birthDate;
    @FXML
    private ComboBox genderCmb;
    @FXML
     private ComboBox cityCmb;
    @FXML
    private Button saveBtn, editBtn, removeBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Gender value : Gender.values()) {
            genderCmb.getItems().add(value.name());
        }
        genderCmb.getSelectionModel().select(0);
        for (City value:City.values()){
            cityCmb.getItems().add(value.name());
        }
        cityCmb.getSelectionModel().select(0);
        saveBtn.setOnAction(event -> {
            try(StudentDa studentDa=new StudentDa()){


                Student student = Student.builder()
                        .id(Integer.parseInt(idTxt.getText()))
                        .name(Validator.nameValidator(nameTxt.getText(), "Invalid Name"))
                        .family(Validator.nameValidator(familyTxt.getText(), "Invalid Family"))
                        .city(String.valueOf(City.valueOf((String) cityCmb.getSelectionModel().getSelectedItem())))
                        .email(mailTxt.getText())
                        .phoneNumber(phoneNumberTxt.getText())
                        .address(addressTxt.getText())
                        .gender(Gender.valueOf((String) genderCmb.getSelectionModel().getSelectedItem()))
                        .birthDate(birthDate.getValue())
                        .build();
                studentDa.save(student);

                Alert alert=new Alert(Alert.AlertType.INFORMATION,"save\n"+student.toString());
                alert.show();


            } catch (Exception e) {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Student Error\n"+e.getMessage());
                alert.show();


            }
        });
    }

    public void save(Student student) {

    }

}

