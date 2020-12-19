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
    public static ArrayList<String> listNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_add_list);
    }
    public void createList(View view) {
        EditText editText = (EditText) findViewById(R.id.eViewListName);
        listNames.add(editText.getText().toString());
        DisplayAddTask.taskNames.add(new ArrayList<String>());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}