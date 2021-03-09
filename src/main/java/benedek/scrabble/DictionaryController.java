package benedek.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;

public class DictionaryController {
    @FXML
    TextField filePathField;
    @FXML
    TextField wordField;
    @FXML
    Label foundLabel;


    public void searchDictionary(ActionEvent actionEvent) throws FileNotFoundException {
        Dictionary dictionary = new Dictionary();
        if(dictionary.findWord(wordField.getText()))
        {
            foundLabel.setText(wordField.getText() + " is in the dictionary");
        }
        else
        {
            foundLabel.setText(wordField.getText() + " is not in the dictionary");
        }
    }
}
