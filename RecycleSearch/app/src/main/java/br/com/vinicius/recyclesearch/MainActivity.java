package br.com.vinicius.recyclesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private List<String> listExample;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ExampleAdapter exampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        createExampleList();
        buildRecyclerView();

    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        exampleAdapter = new ExampleAdapter(listExample);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(exampleAdapter);


    }

    private void filter(String text) {
        ArrayList<String> filteredList = new ArrayList<>();
        for(String string: listExample){
            if(string.toLowerCase().contains(text.toLowerCase())){
                filteredList.add(string);
            }
        }

        exampleAdapter.filterList(filteredList);

    }

    private void createExampleList() {
        listExample = new ArrayList<>();
        listExample.add("One");
        listExample.add("Two");
        listExample.add("Three");
        listExample.add("Four");
        listExample.add("Five");
        listExample.add("Six");
        listExample.add("Seven");
        listExample.add("Eight");
        listExample.add("Nine");
        listExample.add("Ten");

    }
}
