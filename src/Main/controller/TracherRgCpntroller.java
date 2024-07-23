package Main.controller;

import Main.model.entity.Teacher;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TracherRgCpntroller implements Initializable {
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

    }
}
