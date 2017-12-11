package com.example.eduardo.academia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

public class ExercicioActivity extends AppCompatActivity {

    private TextView Textv;
    private String urlExercicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);

        Textv = (TextView)findViewById(R.id.txtNomeExercicio);
        Intent intencao = getIntent();
        Bundle b = intencao.getExtras();

        String nomeExercicio =(String) b.get("nomeExercicio");
        Textv.setText(nomeExercicio);

        WebView wv = (WebView) findViewById(R.id.gif);
        int idExercicio =(int) b.get("idExercicio");
        int idTreino =(int) b.get("idTreino");
        System.out.println("idExercicio="+idExercicio+"  idTreino="+idTreino);
        switch (idTreino){//essa logica sumira quando eu buscar esses links no banco de dados mysql
            case 0:
                if(idExercicio == 0){
                    urlExercicio = "http://muscul.az.free.fr/pt/Mp23h.gif";
                } else if(idExercicio == 1) {
                    urlExercicio = "http://muscul.az.free.fr/uk/Mc15.gif";
                } else{
                    urlExercicio = "http://muscul.az.free.fr/uk/club_mc/supset3.gif";
                }
                break;
            case 1:
                if(idExercicio == 0){
                    urlExercicio = "http://muscul.az.free.fr/pt/mc10m.gif";
                } else if(idExercicio == 1) {
                    urlExercicio = "http://muscul.az.free.fr/pt/hm03.gif";
                } else{
                    urlExercicio = "http://muscul.az.free.fr/pt/Almo09.gif";
                }
                break;
            case 2:
                if(idExercicio == 0){
                    urlExercicio = "http://muscul.az.free.fr/uk/club_mc/supset3.gif";
                } else if(idExercicio == 1) {
                    urlExercicio = "http://muscul.az.free.fr/pt/Cep09h.gif";
                } else{
                    urlExercicio = "http://muscul.az.free.fr/pt/pg05.gif";
                }
                break;
        }

        String html =
                "<body " +
                        "style='background: url(\"" + urlExercicio + "\") no-repeat fixed center;background-size: 100% 100%'>" +
                "</body>";
        //a tela que mostra o gif ainda vou fazer alguns ajustes visuais

        wv.loadData(html, "text/html", "UTF-8");//

    }
}
