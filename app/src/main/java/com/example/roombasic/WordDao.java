package com.example.roombasic;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    public void insert(Word... words);

    @Query("select * from word")
    public List<Word> findAll();

    @Update
    public int updateWord(Word... words);

    @Delete
    public int deleteWord(Word... words);

    @Query("delete from word")
    public int deleteAll();
}
