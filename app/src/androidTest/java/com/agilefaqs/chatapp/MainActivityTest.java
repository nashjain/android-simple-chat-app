package com.agilefaqs.chatapp;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;

import com.confengine.chatapp.R;

/**
 * Created by dheereshsingh on 05/07/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    EditText mMessageText;
    Button mSendButton;
    MainActivity mActivity;

    public MainActivityTest(String name) {
        super(MainActivity.class);
        setName(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mMessageText = (EditText) mActivity.findViewById(R.id.messageInput);
        mSendButton = (Button) mActivity
                .findViewById(R.id.sendButton);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @SmallTest
    public void testViewsCreated() {
        assertNotNull(getActivity());
        assertNotNull(mMessageText);
        assertNotNull(mSendButton);
    }

    @SmallTest
    public void testViewsVisible() {
        ViewAsserts.assertOnScreen(mMessageText.getRootView(), mSendButton);
        ViewAsserts.assertOnScreen(mSendButton.getRootView(), mMessageText);
    }

    @SmallTest
    public void testStartingEmpty() {
        assertTrue("Message filed is empty", "".equals(mMessageText.getText().toString()));
        assertTrue("Send button is enable", !mSendButton.isEnabled() && !mSendButton.isClickable());
    }

    @SmallTest
    public void testSendButtonDisableForEmptyMsg() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mMessageText.setText("");
            }
        });

        assertTrue("Send button is enable", !mSendButton.isEnabled() && !mSendButton.isClickable());
    }

    @SmallTest
    public void testSendButtonEnableForNonEmptyMsg() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mMessageText.setText("Hi");
            }
        });
        assertTrue("Send button is enable", mSendButton.isEnabled() && mSendButton.isClickable());
    }

}