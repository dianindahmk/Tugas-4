package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private List<String> dataList;
    private EditText editTextNim, editTextName;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        editTextNim = findViewById(R.id.editTextNim);
        editTextName = findViewById(R.id.editTextName);
        buttonSave = findViewById(R.id.buttonSave);

        dataList = new ArrayList<>();
        adapter = new DataAdapter(dataList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = editTextNim.getText().toString();
                String name = editTextName.getText().toString();

                if (!nim.isEmpty() && !name.isEmpty()) {
                    dataList.add(nim + " - " + name);
                    adapter.notifyDataSetChanged();

                    editTextNim.setText("");
                    editTextName.setText("");
                }
            }
        });
    }
}