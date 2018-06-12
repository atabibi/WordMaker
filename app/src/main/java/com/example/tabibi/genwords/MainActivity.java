package com.example.tabibi.genwords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.SeekBar;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String TAG = "LOG";
    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems= new ArrayList<>();

    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButtonsClickEvents();

        final EditText txtWord = findViewById(R.id.txtword);
        final ListView lstWords = findViewById(R.id.lstWords);
        final TextView txtWordsCount = findViewById(R.id.txtWordCounts);


        InitEditWord();


        adapter= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                listItems);

        lstWords.setAdapter(adapter);

    }

    private void addButtonsClickEvents() {
        Button btn2 = findViewById(R.id.btnRun2);
        Button btn3 = findViewById(R.id.btnRun3);
        Button btn4 = findViewById(R.id.btnRun4);
        Button btn5 = findViewById(R.id.btnRun5);
        Button btn6 = findViewById(R.id.btnRun6);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRun(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRun(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRun(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRun(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRun(6);
            }
        });
    }

    private void InitEditWord() {
        final EditText edtWord = findViewById(R.id.txtword);
        edtWord.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    int val = edtWord.getText().toString().trim().length();
                    enableBtns(val);
                }
            }
        });

        edtWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int val = s.toString().trim().length();
                enableBtns(val);
            }
        });
    }

    private void enableBtns(int val) {
        Button btn2 = findViewById(R.id.btnRun2);
        Button btn3 = findViewById(R.id.btnRun3);
        Button btn4 = findViewById(R.id.btnRun4);
        Button btn5 = findViewById(R.id.btnRun5);
        Button btn6 = findViewById(R.id.btnRun6);

        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);

        if (val > 5)
        {
            btn6.setEnabled(true);
        }

        if (val > 4)
        {
            btn5.setEnabled(true);
        }

        if (val > 3)
        {
            btn4.setEnabled(true);
        }

        if (val > 2)
        {
            btn3.setEnabled(true);
        }

        if (val > 1)
        {
            btn2.setEnabled(true);
        }
    }


    private void doRun(int n) {
        final EditText txtWord = findViewById(R.id.txtword);
        final TextView txtWordsCount = findViewById(R.id.txtWordCounts);

        listItems.clear();

        String strWord = txtWord.getText().toString().trim();
        Log.d(TAG, "onClick: " + strWord);

        ArrayList<String> words = WordMaker.getWords(strWord,n);

        listItems.addAll(words);

        txtWordsCount.setText(getString(R.string.strCount) + words.size());

        adapter.notifyDataSetChanged();
    }
}
