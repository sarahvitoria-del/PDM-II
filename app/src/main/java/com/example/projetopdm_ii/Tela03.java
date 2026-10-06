package com.example.projetopdm_ii;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity implements View.OnClickListener {
    private ViewPager2 viewPager;
    private ArrayList<Slide> lista;
    private TextView texto;
    private ImageView imageView8;

    private MediaPlayer mediaPlayer;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.iddrawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        texto = findViewById(R.id.textView7);
        viewPager = findViewById(R.id.viewpager);

        lista = new ArrayList<Slide>();
        lista.add(new Slide("Slide 1", R.drawable.img1, "A música 'Hard Red Heart' é uma faixa instrumental/blues lançada pelo projeto Blue Beat Review. \n Detalhes da FaixaArtista: \n Blue Beat ReviewÁlbum: Slip Away (2026) \n Duração: 3 minutos e 33 \n segundosEstilo: Baseada em sonoridades de blues e ritmo contínuo."));
        lista.add(new Slide("Slide 2", R.drawable.img2, "O termo 'Mukbang' é o título de faixas de diferentes artistas, como Lil Cherry & Goldbuuda, Haarper e BabyTron, variando entre K-rap, Phonk e Michigan Rap. Você pode encontrar as letras completas e traduções nas seguintes plataformas"));
        lista.add(new Slide("Slide 3", R.drawable.img3, "A música 'Paradise' mais famosa do mundo é o megahit da banda britânica de rock alternativo Coldplay, lançado em 12 de setembro de 2011.Detalhes da FaixaArtista: \nColdplayÁlbum: Mylo Xyloto (2011) \nGênero: Rock alternativo \n Pop rockSignificado: A letra narra a história de uma garota que esperava muito do mundo, mas se viu frustrada pelas dificuldades da vida. Para escapar dessa realidade pesada, ela fecha os olhos e foge em seus sonhos para o seu próprio 'paraíso'."));
        lista.add(new Slide("Slide 4", R.drawable.img4, "A faixa 'Purple Desire' existe no mundo real e possui algumas versões e colaborações notáveis em diferentes gêneros.\n 1. Versão Pop / Eletrônica (Clark Sims)A versão mais recente e popular é de Clark Sims, lançada em parceria com o projeto The Grey Room.\n Álbum: B Sides (2025)\nGênero: Bright Pop / Synthpop"));
        lista.add(new Slide("Slide 5", R.drawable.img5, "A música 'Six Seven' seria um thriller sonoro no estilo indie rock alternativo, com uma pegada cinematográfica e cheia de suspense, lembrando a trilha sonora de um filme de espionagem moderno.\n Detalhes da Faixa \nGênero: Indie Rock \n Neo-NoirEstrutura: Uma transição rítmica que começa em um compasso lento de 6/8 e acelera bruscamente para 7/8 no refrão, criando uma sensação de urgência e fuga. \n Sonoridade: Guitarras com distorção matemática (math rock), uma linha de baixo pulsante e vocais duplos (uma voz masculina grave e uma feminina angelical se sobrepondo)."));

        SlideAdapter adapter = new SlideAdapter(lista, texto);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageSelected(position);
                texto.setText(lista.get(position).getTexto());
            }
        });
        viewPager.setAdapter(adapter);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        imageView8 = findViewById(R.id.imageView8);
        imageView8.setOnClickListener(this);
    }

    public void play() {
        int indiceLista = viewPager.getCurrentItem();
        int musica = 0;

        if (indiceLista == 0) {
            musica = R.raw.hardredheart;
        } else if (indiceLista == 1) {
            musica = R.raw.mukbang;
        } else if (indiceLista == 2) {
            musica = R.raw.paradise;
        } else if (indiceLista == 3) {
            musica = R.raw.purpledesire;
        } else if (indiceLista == 4) {
            musica = R.raw.sixseven;
        }

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, musica);
            mediaPlayer.setOnCompletionListener(mp -> stop());
            mediaPlayer.start();
        } else if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        } else {
            stop();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            stop();
            this.finish();
        }
        else if (view.getId() == R.id.imageView8) {
            play();
        }
    }
}