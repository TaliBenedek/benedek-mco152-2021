package benedek.scrabble;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.List;

public class ScrabbleController
{
    @FXML
    List<Label> answerLabels;
    @FXML
    List<Label> letterLabels;
    @FXML
    Label pointsLabel;

    LetterBag letterBag = new LetterBag();
    Dictionary dictionary;
    int totalPoints = 0;
    public ScrabbleController() throws FileNotFoundException
    {
        try
        {
            dictionary = new Dictionary();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize()
    {
        for (Label label : letterLabels)
        {
            label.setText(letterBag.nextLetter());
        }
    }

    public void onLetterClicked(MouseEvent event)
    {
        Label letterLabel = (Label) event.getSource();
        String letter = letterLabel.getText();
        for (Label answerLabel : answerLabels)
        {
            if ("".equals(answerLabel.getText()))
            {
                answerLabel.setText(letter);
                letterLabel.setText("");
                break;
            }
        }
    }

    public void onAnswerClicked(MouseEvent event)
    {
        Label label = (Label) event.getSource();
        String letter = label.getText();
        label.setText("");
        for (Label letterLabel : letterLabels)
        {
            if ("".equals(letterLabel.getText()))
            {
                letterLabel.setText(letter);
                break;
            }
        }
    }

    public void onSubmit(ActionEvent event)
    {
        StringBuilder word = new StringBuilder();
        for (Label answerLabel : answerLabels)
        {
            word.append(answerLabel.getText());
        }
        if (dictionary.findWord(word.toString()))
        {
            calculatePoints(word.toString());
            for (int index = 0; index < answerLabels.size(); index++)
            {
                answerLabels.get(index).setText("");
                if ("".equals(letterLabels.get(index).getText()) && !letterBag.isEmpty())
                {
                    letterLabels.get(index).setText(letterBag.nextLetter());
                }
            }
        }
        else
        {
            onClear(null);
        }
    }

    public void onClear(ActionEvent event)
    {
        String[] clearedLetters = new String[7];
        for (int labelIndex = 0, lettersIndex = 0; labelIndex < clearedLetters.length; labelIndex++)
        {
            clearedLetters[labelIndex] = answerLabels.get(labelIndex).getText();
            answerLabels.get(labelIndex).setText("");
            if ("".equals(letterLabels.get(labelIndex).getText()))
            {
                letterLabels.get(labelIndex).setText(clearedLetters[lettersIndex]);
                lettersIndex++;
            }
        }
    }

    private void calculatePoints(String word)
    {
        int numOfLetters = word.length();
        int points = 0;
        switch (numOfLetters)
        {
            case 2:
                points = 1;
                break;
            case 3:
                points = 3;
                break;
            case 4:
                points = 5;
                break;
            case 5:
                points = 7;
                break;
            case 6:
                points = 11;
                break;
            case 7:
                points = 13;
                break;
            default:
        }
        totalPoints += points;
        pointsLabel.setText(String.valueOf(totalPoints));
    }
}
