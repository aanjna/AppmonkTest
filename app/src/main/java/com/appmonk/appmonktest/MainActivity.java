package com.appmonk.appmonktest;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends ListActivity {

    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    AutoCompleteTextView editskill, editrating, editexp;
    Button add, submit;
    String skill_name[] = {"PHP","JAVA","HTML5","ANDROID","SQL"};
    String rating[] = {"1","2","3","4","5"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* spinner1 = (Spinner) findViewById(R.id.skill_name);
        spinner2 = (Spinner) findViewById(R.id.rating);
        spinner3 = (Spinner) findViewById(R.id.experiance);*/
        add = (Button) findViewById(R.id.btnAdd);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                editskill = (AutoCompleteTextView) findViewById(R.id.skill_name);
                editrating = (AutoCompleteTextView) findViewById(R.id.rating);
                editexp = (AutoCompleteTextView) findViewById(R.id.experiance);

                list.add(editskill.getText().toString());
                editskill.setText("");
                list.add(editrating.getText().toString());
                editrating.setText("");
                list.add(editexp.getText().toString());
                editexp.setText("");

                adapter.notifyDataSetChanged();
            }
        };

        add.setOnClickListener(listener);
        setListAdapter(adapter);
    }
}
