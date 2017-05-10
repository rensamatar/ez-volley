package fi.iwa.ez_volley.network;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import fi.iwa.ez_volley.listener.VolleyResponseListener;


public class VolleyRequest {

    private static final String TAG = VolleyRequest.class.getSimpleName();

    /**
     * GET json array.
     *
     * @param url      URL for request
     * @param listener Callback listener
     */
    public static void getArrayRequest(String url, final VolleyResponseListener listener) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray object) {
                listener.onResponse(object);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) {
                    listener.onError(volleyError);
                }
            }
        }) {
            @Override
            protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                try {
                    String json = new String(response.data, "UTF-8");
                    return Response.success(new JSONArray(json), HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listener.onNetworkResponse(response);
                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Cache-Control", "no-cache");
                params.put("Authorization", "");
                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.HIGH;
            }
        };

        // Check for repeat call api when slow internet or no connection.
        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance().getRequestQueue().add(jsonArrayRequest);
    }

    /**
     * GET json object.
     *
     * @param url      URL for request
     * @param body     Request JSONObject as params (null).
     * @param listener Callback listener
     */
    public static void getObjectRequest(String url, JSONObject body, final VolleyResponseListener listener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject object) {
                listener.onResponse(object);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) {
                    listener.onError(volleyError);
                }
            }
        }) {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    String json = new String(response.data, "UTF-8");
                    return Response.success(new JSONObject(json), HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listener.onNetworkResponse(response);
                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Cache-Control", "no-cache");
                params.put("Authorization", "");
                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.HIGH;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance().getRequestQueue().add(jsonObjectRequest);
    }

    /**
     * POST json object.
     *
     * @param url      URL for request
     * @param body     Request JSONObject as params.
     * @param listener Callback listener
     */
    public static void postObjectRequest(String url, JSONObject body, final VolleyResponseListener listener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject object) {
                listener.onResponse(object);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) {
                    listener.onError(volleyError);
                }
            }
        }) {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    String json = new String(response.data, "UTF-8");
                    return Response.success(new JSONObject(json), HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listener.onNetworkResponse(response);
                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Cache-Control", "no-cache");
                params.put("Authorization", "");
                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance().getRequestQueue().add(jsonObjectRequest);
    }

    /**
     * PUT json object.
     *
     * @param url      URL for request
     * @param body     Request JSONObject as params.
     * @param listener Callback listener
     */
    public static void putObjectRequest(String url, JSONObject body, final VolleyResponseListener listener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject object) {
                listener.onResponse(object);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) {
                    listener.onError(volleyError);
                }
            }
        }) {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    String json = new String(response.data, "UTF-8");
                    return Response.success(new JSONObject(json), HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listener.onNetworkResponse(response);
                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Cache-Control", "no-cache");
                params.put("Authorization", "");
                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance().getRequestQueue().add(jsonObjectRequest);
    }

    /**
     * DELETE string request.
     *
     * @param url      URL for post API request
     * @param listener Listener
     */
    public static void deleteRequest(String url, final VolleyResponseListener listener) {
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) {
                    listener.onError(volleyError);
                }
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                listener.onNetworkResponse(response);
                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Cache-Control", "no-cache");
                params.put("Authorization", "");
                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance().getRequestQueue().add(stringRequest);
    }

    /**
     * PUT string request
     *
     * @param url      URL for post API request
     * @param listener Listener
     */
    public static void putStringRequest(String url, final VolleyResponseListener listener) {
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onResponse(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError != null) {
                    listener.onError(volleyError);
                }
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                listener.onNetworkResponse(response);
                return super.parseNetworkResponse(response);
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Cache-Control", "no-cache");
                params.put("Authorization", "");
                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, -1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance().getRequestQueue().add(stringRequest);
    }

}
