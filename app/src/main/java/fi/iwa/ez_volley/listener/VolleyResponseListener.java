package fi.iwa.ez_volley.listener;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

public interface VolleyResponseListener {
    void onError(final VolleyError error);
    void onResponse(Object response);
    void onNetworkResponse(NetworkResponse response);
}
