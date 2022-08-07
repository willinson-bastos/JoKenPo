package com.willinson.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imagemResultado = findViewById(R.id.imagemResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int numeroRandomico = new Random().nextInt(3);// 0 1 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numeroRandomico];

        switch (opcaoApp){
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (opcaoApp == "tesoura" && opcaoSelecionada == "papel")||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra")
        )
        {//app ganhador
            textoResultado.setText("Você perdeu :(");
        }
        else if(
                (opcaoApp == "tesoura" && opcaoSelecionada == "pedra")||
                (opcaoApp == "pedra" && opcaoSelecionada == "papel")||
                (opcaoApp == "papel" && opcaoSelecionada == "tesoura")
        )
        {//usuario ganhador
            textoResultado.setText("Você ganhou :)");
        }
        else {//empate
            textoResultado.setText("Empatamos :/");
        }

        System.out.println(opcaoApp);

    }

}