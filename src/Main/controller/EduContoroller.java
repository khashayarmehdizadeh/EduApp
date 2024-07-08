package Main.controller;

import Main.model.entity.enums.Gender;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class EduContoroller implements Initializable {
    @FXML
    private TextField idTxt, nameTxt, familyTxt, cityTxt, mailTxt, phoneNumberTxt, addressTxt;
    @FXML
    private DatePicker birthDate;
    @FXML
    private ComboBox genderCmb;
    @FXML
    private Button saveBtn, editBtn, removeBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Gender value:Gender.values()){
            genderCmb.getItems().add(value.name());
        }
        genderCmb.getSelectionModel().select(0);
        saveBtn.setOnAction(event -> {
            ;
            System.out.println("ID:" + idTxt.getText());
            System.out.println("NAME:" + nameTxt.getText());
            System.out.println("FAMILY:" + familyTxt.getText());
            System.out.println("CITY:" + cityTxt.getText());
            System.out.println("MAIL:" + mailTxt.getText());
            System.out.println("PHONENUMBER:" + phoneNumberTxt.getText());
            System.out.println("ADDRESS:" + addressTxt.getText());
            System.out.println("BirthDate:" + birthDate.getValue());
            System.out.println(genderCmb.getSelectionModel().getSelectedItem());


        });
    }

}

