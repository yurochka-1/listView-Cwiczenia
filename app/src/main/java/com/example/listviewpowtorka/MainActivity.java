package com.example.listviewpowtorka;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String>arrayListWarzywa = new ArrayList<>();
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        arrayListWarzywa.add("Ziemniak");
        arrayListWarzywa.add("Burak");
        arrayListWarzywa.add("Marchewka");
        arrayListWarzywa.add("Saler");
        listView = findViewById(R.id.listViewWarzywa);
        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayListWarzywa);
        listView.setAdapter(arrayAdapter);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextText3);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String warzywko = editText.getText().toString();
                        arrayListWarzywa.add(warzywko);
                        arrayAdapter.notifyDataSetChanged();
                        editText.setText("");
                    }
                }
        );
        // po krótkim kliknięciu przekreślamy i na odwrót
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        /*view.setBackgroundColor(Color.GRAY);
                        Toast.makeText(MainActivity.this, arrayListWarzywa.get(position), Toast.LENGTH_SHORT).show();*/

                        TextView textView = (TextView) view;
                       if (textView.getPaintFlags() == Paint.STRIKE_THRU_TEXT_FLAG){
                           textView.setPaintFlags(Paint.CURSOR_AFTER);
                       }else{
                           textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                       }



                    }
                }
        );
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        arrayListWarzywa.remove(position);
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );



    }
}