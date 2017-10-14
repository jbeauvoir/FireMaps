package com.example.jbeauvoir.firemaps;
import android.preference.PreferenceActivity;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.loopj.android.http.*;

import org.json.*;

import cz.msebera.android.httpclient.Header;


/**
 * Created by roote on 10/13/2017.
 */

class MapsRestClientUser {
    public void getMapLayer(LatLngBounds latLngBounds) throws JSONException{
        MapsRestClient.get(String.format("query?geometryType=esriGeometryEnvelope&geometry={xmin:%s,ymin:%s,xmax:%s,ymax:%s}&f=json",
                latLngBounds.southwest.latitude, latLngBounds.southwest.longitude,
                latLngBounds.northeast.latitude, latLngBounds.northeast.longitude), null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                //If the response is JSONObjecct instead of expected JsnArray
                Log.d("OBJECT", response.toString());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray){
                try {
                    JSONObject firstEl = (JSONObject) jsonArray.get(0);
                    Log.d("ARRAY",firstEl.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t){
                Log.d("Failure", "Here is the error code:" + statusCode);
            }
        });
    }

}
