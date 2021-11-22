package com.example.motto_dnia_aplikacja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView napis;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        napis=findViewById(R.id.motto);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Interface.adress).addConverterFactory(GsonConverterFactory.create()).build();
        Interface inter = retrofit.create(Interface.class);
        Call<List<Mott>> command = inter.getMott();

        command.enqueue(new Callback<List<Mott>>() {
            @Override
            public void onResponse(Call<List<Mott>> call, Response<List<Mott>> response) {

                List<Mott> lista_mott=response.body();
                int liczba=new Random().nextInt(lista_mott.size()+1);
                Mott wylosowany = lista_mott.get(liczba);
                napis.setText(wylosowany.getContent());


            }

            @Override
            public void onFailure (Call<List<Mott>> call, Throwable t) {
                t.printStackTrace();

            }
        });



    }
}