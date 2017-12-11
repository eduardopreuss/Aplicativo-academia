package com.example.eduardo.academia;


import android.os.AsyncTask;
import android.util.Log;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetFromServer extends AsyncTask<Void, Void,  Exercicio[]> {

    public static final String PESSOAS_URL= "http://10.0.2.2:8080/ServicoREST/rest/Exercicios";


    @Override
    protected Exercicio[] doInBackground(Void... strings) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(PESSOAS_URL)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            Log.d("pessoahttp", "JSON = "+json);
            Gson gson = new Gson();
            return gson.fromJson(json, Exercicio[].class);
        } catch (Exception e){
            Log.d("pessoahttp", "DEU RUIM6");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Exercicio[] exercicios) {
        super.onPostExecute(exercicios);
    }

}
