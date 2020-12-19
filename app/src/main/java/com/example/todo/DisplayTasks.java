package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DisplayTasks extends AppCompatActivity {
    private float scale;
//    public ArrayList<ArrayList<CheckBox>> tasks = new ArrayList<>();
    private int checkBoxMargin[] = new int[4];
    public LinearLayout.LayoutParams checkBoxLayoutParams;
    TextView listTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_tasks);

        scale = getResources().getDisplayMetrics().density;
        LinearLayout tasksLayout = (LinearLayout) findViewById(R.id.lLayoutTasks);
        Intent intent = getIntent();
        listTitle = (TextView) findViewById(R.id.viewListName);
        listTitle.setText(MainActivity.ln);

        checkBoxMargin[3] = (int) (32 * scale);
        checkBoxLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        checkBoxLayoutParams.setMargins(checkBoxMargin[0], checkBoxMargin[1], checkBoxMargin[2], checkBoxMargin[3]);

        for (int i = 0; i < DisplayAddTask.taskNames.get(MainActivity.selectedIndex).size(); i++) {
            CheckBox cBox = new CheckBox(this);
            cBox.setText(DisplayAddTask.taskNames.get(MainActivity.selectedIndex).get(i));
            cBox.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
            cBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toArchive(view);
                }
            });
            cBox.setLayoutParams(checkBoxLayoutParams);
            tasksLayout.addView(cBox);
        }
    }
    public void toArchive(View view) {
        Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show();
    }
    public void addTask(View view) {
        Intent intent = new Intent(this, DisplayAddTask.class);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return super.onSupportNavigateUp();
    }
}