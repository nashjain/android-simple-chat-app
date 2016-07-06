package com.agilefaqs.chatapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

import com.confengine.chatapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by asthasharma on 05/07/16.
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity>{

    public MainActivityTest() {
        super(MainActivity.class);
    }

    MainActivity activity = null;

    @Before
    protected void setup () throws Exception {
        super.setUp();
        activity = startActivity(new Intent(getInstrumentation().getTargetContext(), MainActivity.class), null, null);

    }

    @Test
    public void testMessagesNullTest () {
        Context context = getInstrumentation().getTargetContext();
        context.setTheme(R.style.Theme_AppCompat);
        activity = launchActivity(context.getPackageName(),
                MainActivity.class, null);
        getInstrumentation().waitForIdleSync();
        Button sendButton = (Button) activity.findViewById(R.id.sendButton);
//        activity = startActivity(new Intent(getInstrumentation().getTargetContext(), MainActivity.class), null, null);
        activity.downloadMessages();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotNull(sendButton);
    }

    @After
    public void teardown() throws Exception {
        super.tearDown();
    }
}
