package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.memoseed.jokesbackend.myApi.MyApi;
import com.memoseed.jokeslibandroid.JokeActivity;

import java.io.IOException;


public class EndpointsAsyncTask extends AsyncTask<Void , Void, String> {
    private MyApi myApiService = null;
    Context context;
    String workArea;

    String TAG = getClass().getSimpleName();

    public EndpointsAsyncTask(Context context,String workArea){
        this.context = context;
        this.workArea = workArea;
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
            Log.d(TAG,"build");
        }else {
            Log.d(TAG,"null");
        }

        try {
            Log.d(TAG,"getData");
            return myApiService.sayHi("joke").execute().getData();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG,"result"+result);
        if(!workArea.matches("test")) context.startActivity(new Intent(context, JokeActivity.class).putExtra("joke",result));
    }
}
