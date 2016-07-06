package com.agilefaqs.chatapp;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.confengine.chatapp.R;

/**
 * Created by anubhavgupta on 06/07/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    private View messageInput;

    private View sendButton;

    private View messageList;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        messageInput = activity.findViewById(R.id.messageInput);
        sendButton = activity.findViewById(R.id.sendButton);
        messageList = activity.findViewById(R.id.messagesList);
    }

    public void testActivityExists() {
        assertNotNull(activity);
    }

    public void testViewsInflated() {
        assertNotNull(messageInput);
        assertNotNull(sendButton);
        assertNotNull(messageList);
    }
}
