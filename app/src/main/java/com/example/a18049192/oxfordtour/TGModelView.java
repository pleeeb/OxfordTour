package com.example.a18049192.oxfordtour;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TGModelView extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    public static TGDao tgDao;
    private Database userDB;
    public static LiveData<List<TG>> currentTGUser;
    public static boolean update = false;

    public TGModelView(Application application){
        super(application);

        userDB = Database.getDatabase(application);
        tgDao = userDB.tgDao();
        currentTGUser = tgDao.TGInfo();
    }

    public void insert(TG tg){
        new TGModelView.InsertAsyncTask(tgDao).execute(tg);
    }

    public void update(TG tg){new InsertAsyncTask(tgDao).execute(tg);}

    LiveData<List<TG>> TGInfo(){
        return currentTGUser;
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<TG,Void,Void> {

        TGDao mTGDao;

        public InsertAsyncTask(TGDao mTGDao){
            this.mTGDao = mTGDao;
        }

        @Override
        protected Void doInBackground(TG... TGs) {
            if (!update) {
                mTGDao.insert(TGs[0]);
                return null;
            }
            else{
                mTGDao.update(TGs[0]);
                update=false;
            }
            return null;
        }
    }
}
