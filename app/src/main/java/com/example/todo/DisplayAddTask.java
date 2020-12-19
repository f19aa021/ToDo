package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;

public class DisplayAddTask extends AppCompatActivity {
    // public static final String EXTRA_MESSAGE = "com.example.todo.MESSAGE";
    public static ArrayList<ArrayList<String>> taskNames = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_add_task);
    }
    public void createTask(View view) {
        EditText editText = (EditText) findViewById(R.id.eViewTaskName);
        taskNames.get(MainActivity.selectedIndex).add(editText.getText().toString());
        // intent.putExtra(EXTRA_MESSAGE, taskNames.get(0));
        Intent intent = new Intent(this, DisplayTasks.class);
        startActivity(intent);
    }
}