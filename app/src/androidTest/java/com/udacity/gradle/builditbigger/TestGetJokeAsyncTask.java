package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TestGetJokeAsyncTask extends AndroidTestCase implements JokeListener{

    private SyncronizeTalker async = null;

    public void setUP() throws Exception{
        super.setUp();
    }

    public void tearDown() throws Exception{
        super.tearDown();
    }

    @Test
    public void testGetJokeAsync(){

        async = new SyncronizeTalker();

        GetJokeAsyncTask task = new GetJokeAsyncTask(this);
        task.execute();

        async.doWait();
    }

    @Override
    public void onJokeLoaded(String joke) {
        assertNotNull(joke);
        assertTrue(!joke.isEmpty());
        async.doNotify();
    }

    @Override
    public void readyForJoke() {

    }
}


