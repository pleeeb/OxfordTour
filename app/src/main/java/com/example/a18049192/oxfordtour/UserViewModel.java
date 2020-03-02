package com.example.a18049192.oxfordtour;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    public static UserDao userDao;
    private Database userDB;
    public static LiveData<List<User>> currentUser;
    public static boolean update = false;

    public UserViewModel(Application application){
        super(application);

        userDB = Database.getDatabase(application);
        userDao = userDB.userDao();
        currentUser = userDao.userInfo();
    }

    public void insert(User user){
        new InsertAsyncTask(userDao).execute(user);
    }

    public void update(User user){new InsertAsyncTask(userDao).execute(user);}

    LiveData<List<User>> userInfo(){
        return currentUser;
    }


    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<User,Void,Void>{

        UserDao mUserDao;

        public InsertAsyncTask(UserDao mUserDao){
            this.mUserDao = mUserDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            if (!update) {
                mUserDao.insert(users[0]);
                return null;
            }
            else{
                mUserDao.update(users[0]);
                update=false;
            }
            return null;
        }
    }


}
