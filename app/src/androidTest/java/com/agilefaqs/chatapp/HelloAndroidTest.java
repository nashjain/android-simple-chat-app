package com.agilefaqs.chatapp;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.Button;
import android.widget.EditText;

import com.confengine.chatapp.R;

import java.util.List;

/**
 * Created by himanshu on 06/07/16.
 */
public class HelloAndroidTest extends
        ActivityInstrumentationTestCase2<MainActivity> {


    private MainActivity mActivity;
    private EditText mView;
    private Button sendBtn = null;
    private String resourceString = "Enter message here";
    private String sendButtonText = "Send";

    public HelloAndroidTest() {
        super("sampleTest", MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mActivity = this.getActivity();
        mView = (EditText) mActivity.findViewById
                ((R.id.messageInput));
        sendBtn = (Button) mActivity.findViewById
                ((R.id.sendButton));
    }

    public void testPreconditions() {
        assertNotNull(mView);
        assertNotNull(sendBtn);
    }

    public void testText() {
        assertEquals(resourceString, mView.getHint().toString());
    }

    public void testSendButtonText() {
        assertEquals(sendButtonText, sendBtn.getText().toString());
    }

    @UiThreadTest
    public void testsendTextFromButton()
    {
        //simulate text
        String text = "Hello";
        mView.setText(text);
        mActivity.onClick(mView);
        List<String> messages = mActivity.getAllMessages();
        assertEquals(true,messages.contains(text));
        assertEquals(text,messages.get(0));
    }

}