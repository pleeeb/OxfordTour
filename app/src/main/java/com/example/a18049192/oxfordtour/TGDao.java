package com.example.a18049192.oxfordtour;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;


@Dao
public interface TGDao {

    @Insert
    void insert(TG tg);

    @Query("SELECT * FROM TGDB ")
    LiveData<List<TG>> TGInfo();
}

