package com.example.eduardo.academia;

import android.app.LoaderManager;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ExerciciosActivity extends AppCompatActivity {


    private SectionsPageAdapter mSectionsPageAdapter;
    ListView lv;
    private ViewPager mViewPager;
    static int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);


        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        try {
            setupViewPager(mViewPager);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager) throws IOException, ExecutionException, InterruptedException {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        GetFromServer gfs = new GetFromServer();
        Exercicio[] exercicios = gfs.execute().get();

        //parte dessa logica sumira quando eu buscar no banco de dados mysql apenas treinos atrelados ao usuario logado
        String[][] treinos = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                treinos[i][j] = exercicios[k].getNome();
                k++;
            }
            adapter.addFragment(new TabFragment().newInstance(treinos[i],i), "Treino "+(i + 1));
        }



        viewPager.setAdapter(adapter);



    }


}
