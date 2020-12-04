package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.*;

public class MainActivity extends AppCompatActivity {
    public static boolean deleteListFlg;
    public static HashMap<Button, ArrayList> lists = new HashMap<>();
    public static String ln;
    public LinearLayout listsLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        deleteListFlg = false;
        findViewById(R.id.buttonDeleteList).setBackgroundColor(0xFFCCCCCC);
        listsLayout = (LinearLayout) findViewById(R.id.lLayoutLists);
        listsLayout.removeAllViews();

        for (Button btn : lists.keySet()) {
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                    if (MainActivity.deleteListFlg) {
                        lists.remove(view);
                        listsLayout.removeView(view);
                    } else {
                        Intent intent = new Intent(getApplicationContext(), DisplayTasks.class);
                        Button b = (Button) view;
                        ln = b.getText().toString();
                        startActivity(intent);
                    }
                }
            });
            listsLayout.addView(btn);
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