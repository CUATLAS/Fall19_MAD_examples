package com.example.halloween_c;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private TextView booText;
    private ImageView ghost;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
        booText = findViewById(R.id.message);
        ghost = findViewById(R.id.imageView);

        // check for recovering the instance state
        if (savedInstanceState !=null){
            message = savedInstanceState.getString("msg");
            int image_id = savedInstanceState.getInt("imageid");

            booText.setText(message);
            ghost.setImageResource(image_id);
        }
    }

    public void sayBoo(View view) {
        //edittext

        String nameValue = name.getText().toString();

        //textview
        message = "Happy Halloween " + nameValue + "!";
        booText.setText(message);

        //imageview
        ghost.setImageResource(R.drawable.ghost);

    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("msg", message);
        outState.putInt("imageid", R.drawable.ghost);
    }
}
