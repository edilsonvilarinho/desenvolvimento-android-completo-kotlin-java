package br.com.edilsonvilarinho.pedrapapeltesoura;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView appEscolha;
    private ImageView jogarPedra;
    private ImageView jogarPapel;
    private ImageView jogarTesoura;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        appEscolha = findViewById(R.id.imageViewaAppEscolha);
        jogarPedra = findViewById(R.id.imageViewJogarPedra);
        jogarPapel = findViewById(R.id.imageViewJogarPapel);
        jogarTesoura = findViewById(R.id.imageViewJogarTesoura);
        resultado = findViewById(R.id.textView3);

        jogarPedra.setOnClickListener(v -> jogar(Jogada.PEDRA));

        jogarPapel.setOnClickListener(v -> jogar(Jogada.PAPEL));

        jogarTesoura.setOnClickListener(v -> jogar(Jogada.TESOURA));
    }

    public void jogar(Jogada jogada) {
        Jogada jogadaApp = Jogada.values()[(int) (Math.random() * Jogada.values().length)];
        appEscolha.setImageResource(getImagem(jogadaApp));
        if (jogada == jogadaApp) {
            resultado.setText(R.string.empate);
        } else if ((jogada == Jogada.PEDRA && jogadaApp == Jogada.TESOURA) || (jogada == Jogada.PAPEL && jogadaApp == Jogada.PEDRA) || (jogada == Jogada.TESOURA && jogadaApp == Jogada.PAPEL)) {
            resultado.setText(R.string.voc_venceu);
        } else if ((jogada == Jogada.PEDRA && jogadaApp == Jogada.PAPEL) || (jogada == Jogada.PAPEL && jogadaApp == Jogada.TESOURA) || (jogada == Jogada.TESOURA && jogadaApp == Jogada.PEDRA)) {
            resultado.setText(R.string.voc_perdeu);
        }
    }

    private int getImagem(Jogada jogadaApp) {
        switch (jogadaApp) {
            case PEDRA:
                return R.drawable.pedra;
            case PAPEL:
                return R.drawable.papel;
            case TESOURA:
                return R.drawable.tesoura;
            default:
                return 0;
        }
    }

    public enum Jogada {
        PEDRA, PAPEL, TESOURA,
    }
}