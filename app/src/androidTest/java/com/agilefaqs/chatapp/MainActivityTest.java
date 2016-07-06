package com.agilefaqs.chatapp;

/**
 * Created by kshamasingh on 06/07/16.
 */

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import com.confengine.chatapp.R;

import dalvik.annotation.TestTarget;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mainActivity;
    private Button sendButton;
    private String buttonString;

    public MainActivityTest() {
        super("com.agilefaqs.android.first", MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = this.getActivity();
        sendButton = (Button) mainActivity.findViewById
                (R.id.sendButton);
        buttonString = "Send";
    }

    public void testCasesPrecondition() {
        assertNotNull(sendButton);
    }

    public void testTextVerification() {
        assertEquals(buttonString, (String) sendButton.getText());
    }

}
