package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button buttonAdd;
    private ListView listViewTasks;
    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;

    private Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewTasks = findViewById(R.id.listViewTasks);
        buttonClear = findViewById(R.id.buttonClear);

        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editTextTask.getText().toString();
                if (!newTask.isEmpty()) {
                    taskList.add(newTask);
                    adapter.notifyDataSetChanged();
                    editTextTask.setText("");
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public  void  onClick(View v) {
                taskList.clear();
                adapter.notifyDataSetChanged();
            }
                                       }
        );

    }
}