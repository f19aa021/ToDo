package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.*;

public class DisplayAddList extends AppCompatActivity {
    int cntALL = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_add_list);
    }
    public void createList(View view) {
        EditText editText = (EditText) findViewById(R.id.eViewListName);
        Button btn = new Button(this);
        btn.setId(cntALL++);
        btn.setText(editText.getText().toString());
        ArrayList<CheckBox> arr = new ArrayList<>();
        MainActivity.lists.put(btn, arr);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}