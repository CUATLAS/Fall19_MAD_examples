package com.example.aileen.sport;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView sportSelection;
    private ToggleButton toggle;
    private Spinner exercise;
    private RadioGroup cost;
    private CheckBox winterCheckBox;
    private CheckBox springCheckBox;
    private CheckBox summerCheckBox;
    private CheckBox fallCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get views
        sportSelection = findViewById(R.id.sportTextView);
        toggle = findViewById(R.id.toggleButton);
        exercise = findViewById(R.id.spinner);
        cost = findViewById(R.id.radioGroup);
        winterCheckBox = findViewById(R.id.checkBox1);
        springCheckBox = findViewById(R.id.checkBox2);
        summerCheckBox = findViewById(R.id.checkBox3);
        fallCheckBox = findViewById(R.id.checkBox4);
    }

    public void findSport(View view) {
        //toggle button
        boolean location = toggle.isChecked();

        //spinner
        String exerciseType = String.valueOf(exercise.getSelectedItem());

        //radio buttons
        int cost_id = cost.getCheckedRadioButtonId();

        //check boxes
        Boolean winter = winterCheckBox.isChecked();
        Boolean spring = springCheckBox.isChecked();
        Boolean summer = summerCheckBox.isChecked();
        Boolean fall = fallCheckBox.isChecked();

        //pick sport
        String perfectSport;

        //check radio buttons
        if (cost_id == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please select a cost level";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (location) { //inside
                if (cost_id == R.id.radioButton1) { //cheapest option
                    perfectSport = "A home workout";
                } else {
                    switch (exerciseType) {
                        case "cardio":
                            perfectSport = "Spin class";
                            break;
                        case "strength":
                            perfectSport = "Weight training";
                            break;
                        case "flexibility":
                            perfectSport = "Yoga";
                            break;
                        default:
                            perfectSport = "Yoga";
                    }
                }
            } else { //outside
                if (cost_id == R.id.radioButton3) {
                    if (winter) {
                        perfectSport = "Skiing";
                    } else {
                        perfectSport = "Sky Diving";
                    }
                } else {
                    switch (exerciseType) {
                        case "cardio":
                            perfectSport = "Running";
                            break;
                        case "strength":
                            perfectSport = "Climbing";
                            break;
                        case "flexibility":
                            perfectSport = "Yoga";
                            break;
                        default:
                            perfectSport = "Yoga";
                    }
                }
            }

            //text view
            sportSelection.setText(perfectSport + " is the sport for you");
        }
    }
}
