package com.agilefaqs.chatapp;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.confengine.chatapp.R;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import org.junit.Rule;
import org.junit.Test;

import static com.confengine.chatapp.R.id.messageInput;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

/**
 * Created by graval
 */

public class AppCompoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public AppCompoTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9090);

    @Test
    public void mockValidateResponse(){
        stubFor(get(urlEqualTo("/message=testBrowser4"))
            .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        ));

        stubFor(get(urlEqualTo("/fetchAllMessages"))
            .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"TestMesage\"}")
                ));

        System.out.println("Mock Server started...");
        EditText et = (EditText) getActivity().findViewById(R.id.messageInput);
        assert (et.getHint().toString().equals("Enter message here"));
        et.performClick();
        sendKeys("testBrowser4");
        getActivity().findViewById(R.id.sendButton).performClick();
        //TODO: Fix for socket & assert on send text and receive text
        //assert (get message & validate)

    }
}