package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.util.Log;
import android.util.Pair;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class JokeTest extends AndroidTestCase {

    String TAG = getClass().getSimpleName();

    @Test
    public void Test(){
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(),"test");
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(TAG, "result not empty"+ result);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertNotNull("result not null",result);
    }
}
