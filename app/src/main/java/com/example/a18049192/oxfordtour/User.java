package com.example.a18049192.oxfordtour;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "UserDB")
public class User{



    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    private String firstname;

    @NonNull
    private String surname;

    @NonNull
    private String email;

    @NonNull
    private String age;

    @NonNull
    private String password;

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getFirstname() {
        return firstname;
    }

    @NonNull
    public String getSurname(){
        return surname;
    }

    @NonNull
    public String getEmail(){
        return email;
    }

    @NonNull
    public String getAge(){
        return age;
    }

    @NonNull
    public String getPassword(){
        return password;
    }

    public User(String id, String firstname, String surname, String email, String age, String password){
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.password = password;
    }


}

