package com.agilefaqs.chatapp;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;

public class DownloadMessagesAsyncTask extends AsyncTask<HttpURLConnection, Object, List<String>> {

    private DownloadMessageInterface downloadMessageInterface;

    public DownloadMessagesAsyncTask(DownloadMessageInterface downloadMessageInterface) {
        this.downloadMessageInterface = downloadMessageInterface;
    }

    @Override
    protected List<String> doInBackground(HttpURLConnection... params) {

        List<String> messages = null;
        try {
            InputStream in = params[0].getInputStream();
            InputStreamReader isw = new InputStreamReader(in);
            StringBuilder buffer = new StringBuilder();
            int data;
            data = isw.read();
            while (data != -1) {
                char c = (char) data;
                buffer.append(c);
                System.out.print(c);
                data = isw.read();
            }
            Type type = new TypeToken<List<String>>() {
            }.getType();
            messages = new Gson().fromJson(buffer.toString(), type);
        } catch (Exception e) {
            Log.e("", e.getMessage(), e);
        }
        return messages;
    }

    @Override
    protected void onPostExecute(List<String> m) {
        downloadMessageInterface.processDownloadedMessages(m);
    }
}
