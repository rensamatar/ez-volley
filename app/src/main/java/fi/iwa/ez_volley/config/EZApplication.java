package fi.iwa.ez_volley.config;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class EZApplication extends Application {

    private static final String TAG = EZApplication.class.getSimpleName();

    private static Application mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Log.d(TAG, "on application created");
    }

    public static synchronized Application getInstance() {
        return mInstance;
    }

    public static Context getAppContext() {
        return mInstance.getApplicationContext();
    }
}
