package com.agilefaqs.chatapp;

import android.os.Bundle;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class MainActivityUnitTest {

    @Test
    public void testFailureResponseFromServer() throws Exception {
        DownloadMessagesAsyncTask downloadMessagesAsyncTask = Mockito.mock(DownloadMessagesAsyncTask.class);
        Mockito.when(downloadMessagesAsyncTask.doInBackground()).thenReturn(null);
        MainActivity mainActivity = Mockito.mock(MainActivity.class);
        Bundle bundle = Mockito.mock(Bundle.class);
        mainActivity.onCreate(bundle);
        Mockito.when(mainActivity.processDownloadedMessages(null)).thenCallRealMethod();
        mainActivity.setDownloadMessagesAsyncTask(downloadMessagesAsyncTask);
        Assert.assertTrue(mainActivity.getMessages()!=null);
        mainActivity.processDownloadedMessages(null);
        Assert.assertTrue(mainActivity.getMessages()!=null);

    }

}
