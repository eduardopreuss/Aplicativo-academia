package com.example.eduardo.academia;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

/**
 * Created by User on 2/28/2017.
 */

public class TabFragment extends Fragment {

    private ListView lv;

    public static final String listaX = "lista1";
    public static final String treinoX = "treino1";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment, container, false);

        setLista(view);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle bundle = getArguments();
                int t = bundle.getInt(treinoX);
                String nomeExercicio = lv.getItemAtPosition(i).toString();
                Intent intencao = new Intent(view.getContext(), ExercicioActivity.class);
                    intencao.putExtra("idExercicio", i);
                    intencao.putExtra("idTreino", t);
                    intencao.putExtra("nomeExercicio", nomeExercicio);
                    startActivity(intencao);


            }
        });


        return view;
    }

    public static TabFragment newInstance(String[] lista, int treino) {
        TabFragment myFragment = new TabFragment();

        Bundle args = new Bundle();
        args.putStringArray(listaX, lista);
        args.putInt(treinoX, treino);
        myFragment.setArguments(args);

        return myFragment;
    }

    private void setLista(View v) {//pretendo fazer a minha lista com item e subitem futuramente. O subitem terá as repetições, séries e carga/peso de cada exercicio

        Bundle bundle = getArguments();
        if (bundle != null) {
            lv = (ListView) v.findViewById(R.id.list_exercicios);
            ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, bundle.getStringArray(listaX));
            lv.setAdapter(adapter);


        }
    }




}