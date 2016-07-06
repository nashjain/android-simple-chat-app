package com.agilefaqs.chatapp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

/**
 * Created by sidharth on 06/07/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;
    private EditText mView;
    private String resourceString;

    public MainActivityTest() {
        super("com.agilefaqs.chatapp.MainActivity", MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        mView = (EditText) mActivity.findViewById(com.confengine.chatapp.R.id.messageInput);
        resourceString = "Enter message here";
    }

    public void testPreconditions() {
        assertNotNull(mView);
    }

    public void testText() {
        assertEquals(resourceString,(String) mView.getText().toString());
    }
}
