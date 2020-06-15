package com.example.kapde_wala;

import android.icu.util.LocaleData;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SendJsonDataToServer extends AsyncTask<String,String,String> {

    @Override
    protected String doInBackground(String... params) {
        String JsonResponse = null;
        String JsonDATA = params[0];
        String urlStr = params[1];
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(urlStr);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
            urlConnection.setRequestProperty("Accept","*/*");
            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            writer.write(JsonDATA);
            writer.close();
            int status = urlConnection.getResponseCode();
            InputStream inputStream;
            if(status >= 400) {
                System.out.println("Status: "+ status + "Returned");
                inputStream = urlConnection.getErrorStream();
            } else {
                inputStream = urlConnection.getInputStream();
            }

            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine + "\n");
            if (buffer.length() == 0) {
                // Stream was empty. No point in parsing.
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("", "Error closing stream", e);
                }
                return null;
            }
            JsonResponse = buffer.toString();
            Log.i("responseData",JsonResponse);
            try {
                reader.close();
            } catch (final IOException e) {
                Log.e("", "Error closing stream", e);
            }
            return JsonResponse;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String s) {
    }
}
