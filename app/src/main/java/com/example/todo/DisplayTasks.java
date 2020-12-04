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
    public ArrayList<CheckBox> checkBox = new ArrayList<>();
    public ArrayList<LinearLayout.LayoutParams> checkBoxLayoutParams = new ArrayList<>();
    private int checkBoxMargin[] = new int[4];
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
        for (int i = 0; i < DisplayAddTask.taskNames.size(); i++) {
            checkBox.add(new CheckBox(this));
            checkBox.get(i).setText(DisplayAddTask.taskNames.get(i));
            checkBox.get(i).setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
            checkBox.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toArchive(view);
                }
            });
            checkBoxLayoutParams.add(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            checkBoxLayoutParams.get(i).setMargins(checkBoxMargin[0], checkBoxMargin[1], checkBoxMargin[2], checkBoxMargin[3]);
            checkBox.get(i).setLayoutParams(checkBoxLayoutParams.get(i));
            tasksLayout.addView(checkBox.get(i));
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