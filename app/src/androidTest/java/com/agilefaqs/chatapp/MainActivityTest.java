package com.agilefaqs.chatapp;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;

import com.confengine.chatapp.R;

/**
 * Created by sidharth on 06/07/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;
    private EditText mView;
    private Button sendBtn;
    private String resourceString;

    public MainActivityTest() {
        super("com.agilefaqs.chatapp.MainActivity", MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        mView = (EditText) mActivity.findViewById(com.confengine.chatapp.R.id.messageInput);
        sendBtn = (Button) mActivity.findViewById(R.id.sendButton);
        resourceString = "Enter message here";
    }

    public void testPreconditions() {
        assertNotNull(mView);
    }

    public void testText() {
        assertEquals(resourceString, mView.getHint().toString());
    }

    @UiThreadTest
    public void testSendButtonDisabledIfMessageInputIsEmpty() {
        mView.setText("");
        assertEquals(false, sendBtn.isEnabled());
    }

    @UiThreadTest
    public void testSendButtonEnabledIfMessageInputIsNotEmpty() {
        mView.setText("abc");
        assertEquals(true, sendBtn.isEnabled());
    }
}
