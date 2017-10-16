package com.jbeauvoir.firemaps;
import android.preference.PreferenceActivity;
import android.util.Log;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.loopj.android.http.*;

import org.json.*;

import cz.msebera.android.httpclient.Header;


/**
 * Created by roote on 10/13/2017.
 * Class to implement calls to asynchronous client, handles success and failures
 */

class MapsRestClientUser {


    /**
     *  Formats the query section of the url and passes to Client static function
     *  Throw exception for trying to read JSON
     * */
    public void getMapLayer(LatLngBounds latLngBounds) throws JSONException{
        MapsRestClient.get(String.format("query?geometryType=esriGeometryEnvelope&geometry={xmin:%s,ymin:%s,xmax:%s,ymax:%s}&f=json",
                latLngBounds.southwest.latitude, latLngBounds.southwest.longitude,
                latLngBounds.northeast.latitude, latLngBounds.northeast.longitude), null, new JsonHttpResponseHandler(){

            /**
             * Gets called on success when a JSON Object is received
             * @param statusCode
             * @param headers
             * @param response
             */
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response){
                //If the response is JSONObjecct instead of expected JSONArray
                //DEBUG: for testing
                Log.d("OBJECT", response.toString());
            }

            /**
             * Gets called on success when a JSONArray is received
             * @param statusCode
             * @param headers
             * @param jsonArray
             */
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray){
                try {
                    JSONObject firstEl = (JSONObject) jsonArray.get(0);
                    //DEBUG: for testing
                    Log.d("ARRAY",firstEl.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            /**
             * Logs callback failure
             * @param statusCode
             * @param headers
             * @param res
             * @param t
             */
            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t){
                //DEBUG: for testing
                Log.d("Failure", "Here is the error code:" + statusCode);
            }
        });
    }

}
