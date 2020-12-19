package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    public static boolean deleteListFlg;
    public ArrayList<Button> lists = new ArrayList<>();
    public static String ln;
    public static int selectedIndex;
    int cntALL = 0;
//    public static LinearLayout listsLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        deleteListFlg = false;
        findViewById(R.id.buttonDeleteList).setBackgroundColor(0xFFCCCCCC);
        LinearLayout listsLayout = (LinearLayout) findViewById(R.id.lLayoutLists);
        listsLayout.removeAllViews();

        for (int i = 0; i < DisplayAddList.listNames.size(); i++) {
            Button btn = new Button(this);
            btn.setId(cntALL++);
            btn.setText(DisplayAddList.listNames.get(i));
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                    if (MainActivity.deleteListFlg) {
                        int delIndex = lists.indexOf((Button) view);
                        DisplayAddList.listNames.remove(delIndex);
                        lists.remove(delIndex);
                        DisplayAddTask.taskNames.remove(delIndex);
                        listsLayout.removeView(view);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), DisplayTasks.class);
                        Button b = (Button) view;
                        MainActivity.ln = b.getText().toString();
                        MainActivity.selectedIndex = lists.indexOf(b);
                        startActivity(intent);
                    }
                }
            });
            lists.add(btn);
            listsLayout.addView(lists.get(i));
        }
    }
    public void addList(View view) {
        Intent intent = new Intent(this, DisplayAddList.class);
        startActivity(intent);
    }
    public void deleteList(View view) {
        deleteListFlg = !deleteListFlg;
        if(deleteListFlg){
            findViewById(R.id.buttonDeleteList).setBackgroundColor(Color.RED);
        }else{
            findViewById(R.id.buttonDeleteList).setBackgroundColor(0xFFCCCCCC);
        }
    }
}