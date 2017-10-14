package com.jbeauvoir.firemaps;

import android.util.Log;
import com.loopj.android.http.*;

/**
 * Created by roote on 10/13/2017.
 */

public class MapsRestClient {
    //String to serve as the base for forming queries
    private static final String BASE_URL = "https://wildfire.cr.usgs.gov/arcgis/rest/services/geomac_perims/MapServer/3/";
    private static AsyncHttpClient client = new AsyncHttpClient();
    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static String getAbsoluteUrl(String relativeUrl){
        String res = BASE_URL + relativeUrl;
        //DEBUG: for verification
        Log.d("QUERY:", res);
        return res;
    }
}
