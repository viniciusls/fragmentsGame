package br.com.viniciusls.fragmentsproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.viniciusls.fragmentsproject.R;

/**
 * Created by Vinicius Luiz on 16/09/2016.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Define o layout desta activity

        Button btnIniciarJogo = (Button) findViewById(R.id.btnIniciarJogo); // Seleciona o botão no xml da activity a partir de seu ID
        btnIniciarJogo.setOnClickListener(iniciarJogoClickListener); // Define a função onClick do botão
    }

    private View.OnClickListener iniciarJogoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, GameActivity.class); // Cria a intenção de iniciar a Activity GameActivity a partir desta activity (this)
            startActivity(intent); // Inicia a activity conforme configurado na Intent

            finish(); // Finaliza a activity para que ela não fique em execução em background
        }
    };
}
