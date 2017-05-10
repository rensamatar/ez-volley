package fi.iwa.ez_volley.network;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import fi.iwa.ez_volley.config.EZApplication;

public class VolleySingleton {

    private static final String TAG = VolleySingleton.class.getSimpleName();

    private static VolleySingleton sInstance = null;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;

    private VolleySingleton() {
        mRequestQueue = Volley.newRequestQueue(EZApplication.getAppContext());
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {

            private LruCache<String, Bitmap> cache = new LruCache<>((int) (Runtime.getRuntime().maxMemory() / 1024) / 8);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    public static VolleySingleton getInstance() {
        if (sInstance == null) {
            sInstance = new VolleySingleton();
        }
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(EZApplication.getAppContext());
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // Set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }
}
