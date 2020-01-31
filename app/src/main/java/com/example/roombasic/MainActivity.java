package com.example.roombasic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button buttonInsert, buttonClear, buttonDelete, buttonUpdate;
    WordDataBase wordDataBase;
    WordDao wordDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDataBase = Room.databaseBuilder(this, WordDataBase.class, "word_database")
                .allowMainThreadQueries()
                .build();
        wordDao = wordDataBase.getWordDao();
        textView = findViewById(R.id.textView);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonClear = findViewById(R.id.buttonClear);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("hello", "你好!!!");
                Word word2 = new Word("World", "世界");
                wordDao.insert(word1, word2);
                updateAllWords();
            }
        });

    }

    void updateAllWords() {
        String text = "";
        List<Word> words = wordDao.findAll();
        for (Word word : words) {
            text += word.getId() + ":" + word.getEnWord() + "-" + word.getZhMeaning() + "\n";
        }
        textView.setText(text);
    }
}
