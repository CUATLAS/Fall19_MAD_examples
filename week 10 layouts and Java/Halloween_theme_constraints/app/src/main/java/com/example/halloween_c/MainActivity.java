package com.example.halloween_c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editText);
    }

    public void sayBoo(View view) {
        //edittext

        String nameValue = name.getText().toString();

        //textview
        TextView booText = findViewById(R.id.message);
        booText.setText("Happy Halloween " + nameValue + "!");

        //imageview
        ImageView ghost = findViewById(R.id.imageView);
        ghost.setImageResource(R.drawable.ghost);

    }
}
