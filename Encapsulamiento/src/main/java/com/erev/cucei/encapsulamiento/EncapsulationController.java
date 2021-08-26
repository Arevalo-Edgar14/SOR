package com.erev.cucei.encapsulamiento;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EncapsulationController {
    MyDate myDate = new MyDate();
    @FXML
    private Label dateLabel = new Label();
    @FXML
    private TextField dayTextField = new TextField();
    @FXML
    private TextField monthTextField = new TextField();
    @FXML
    private TextField yearTextField = new TextField();

    public void initialize() {
        // set date from MyDate constructor
        setDateLabel();

        // set default values to the TextFields from MyDate constructor
        dayTextField.setText( String.valueOf( myDate.getDay() ) );
        monthTextField.setText( String.valueOf( myDate.getMonth() ) );
        yearTextField.setText( String.valueOf( myDate.getYear() ) );

        // attach a listener to the TextFields when the focus property change (in/out)
        dayTextField.focusedProperty().addListener( createListener( dayTextField ) );
        monthTextField.focusedProperty().addListener( createListener( monthTextField ) );
        yearTextField.focusedProperty().addListener( createListener( yearTextField ) );
    }

    // method to check if the new value from a TextField change when get focus out and set the new value if valid
    private ChangeListener<Boolean> createListener(TextField textField) {
        return (observableValue, oldPropertyValue, newPropertyValue) -> {
            int newVal = Integer.parseInt( textField.getText() );
            // out focus and value change
            if (!newPropertyValue && !(newVal == compareWith( textField.getId() ))) {
                //  set the new date on the date label if is valid
                if (setDate( textField.getId(), newVal )) setDateLabel();
            }
        };
    }

    //  set the date on the label that shows the current date that MyDate object had
    private void setDateLabel() {
        dateLabel.setText( "Fecha " + myDate.toString() );
    }

    //  compare actual value from a TextField with the correspondent actual value
    private boolean setDate(String field, int newVal) {
        if (field.equals( "dayTextField" )) return myDate.setDay( newVal );
        if (field.equals( "monthTextField" )) return myDate.setMonth( newVal );
        return myDate.setYear( newVal );
    }

    //  compare actual value from a TextField with the correspondent actual value
    private int compareWith(String field) {
        if (field.equals( "dayTextField" )) return myDate.getDay();
        if (field.equals( "monthTextField" )) return myDate.getMonth();
        return myDate.getYear();
    }
}