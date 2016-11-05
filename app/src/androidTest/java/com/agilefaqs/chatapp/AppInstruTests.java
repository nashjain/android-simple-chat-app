package com.agilefaqs.chatapp;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.confengine.chatapp.R;

import static android.R.attr.value;
import static android.support.v7.appcompat.R.id.text;

/**
 * Created by gaurav.raval
 */

public class AppInstruTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public AppInstruTests() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @SmallTest
    public void testHintText(){

        EditText et = (EditText) getActivity().findViewById(R.id.messageInput);
        assert (et.getHint().toString().equals("Enter message here"));

    }
    @SmallTest
    public void testNullText(){
        EditText et = (EditText) getActivity().findViewById(R.id.messageInput);
        assertEquals(et.getText().toString(),"");
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }




}
