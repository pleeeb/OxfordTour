package com.example.a18049192.oxfordtour;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


@Dao
public interface TGDao {

    @Insert
    void insert(TG tg);

    @Update
    void update(TG tg);

    @Query("SELECT * FROM TGDB ")
    LiveData<List<TG>> TGInfo();
}

