package com.example.roombasic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "en_word")
    private String enWord;
    @ColumnInfo(name = "zh-meaning")
    private String zhMeaning;

    public Word(String enWord, String zhMeaning) {
        this.enWord = enWord;
        this.zhMeaning = zhMeaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnWord() {
        return enWord;
    }

    public void setEnWord(String enWord) {
        this.enWord = enWord;
    }

    public String getZhMeaning() {
        return zhMeaning;
    }

    public void setZhMeaning(String zhMeaning) {
        this.zhMeaning = zhMeaning;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", enWord='" + enWord + '\'' +
                ", zhMeaning='" + zhMeaning + '\'' +
                '}';
    }
}
