package com.example.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> tasks;
    private ArrayAdapter<String> tasksAdapter;
    private ListView listview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask(view);
            }
        });

        tasks = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listview.setAdapter(tasksAdapter);
        setUpListViewListener();
    }

    private void setUpListViewListener(){
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Task Removed", Toast.LENGTH_LONG).show();

                tasks.remove(i);
                tasksAdapter.notifyDataSetChanged();

                return true;
            }
        });
    }

    private void addTask(View view){
        EditText input = findViewById(R.id.editText);
        String taskText = input.getText().toString();

        if(!(taskText.equals(""))){
            tasksAdapter.add(taskText);
            input.setText("");
        }

        else
        {
            Toast.makeText(getApplicationContext(), "Please enter test.", Toast.LENGTH_LONG).show();
        }

    }

}