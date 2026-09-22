package com.example.projetopdm_ii;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ArrayList<Slide> lista;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        texto = findViewById(R.id.textView7);
        viewPager = findViewById(R.id.viewpager);
        lista = new ArrayList<Slide>();
        ///mudar depois no exercercicio (as imagens)
        lista.add(new Slide("Slide 1", R.drawable.img1, "A música 'Hard Red Heart' é uma faixa instrumental/blues lançada pelo projeto Blue Beat Review. \n Detalhes da FaixaArtista: \n Blue Beat ReviewÁlbum: Slip Away (2026) \n Duração: 3 minutos e 33 \n segundosEstilo: Baseada em sonoridades de blues e ritmo contínuo."));
        lista.add(new Slide("Slide 2", R.drawable.img2, "O termo 'Mukbang' é o título de faixas de diferentes artistas, como Lil Cherry & Goldbuuda, Haarper e BabyTron, variando entre K-rap, Phonk e Michigan Rap. Você pode encontrar as letras completas e traduções nas seguintes plataformas"));
        lista.add(new Slide("Slide 3", R.drawable.img3, "A música 'Paradise' mais famosa do mundo é o megahit da banda britânica de rock alternativo Coldplay, lançado em 12 de setembro de 2011.Detalhes da FaixaArtista: \nColdplayÁlbum: Mylo Xyloto (2011) \nGênero: Rock alternativo \n Pop rockSignificado: A letra narra a história de uma garota que esperava muito do mundo, mas se viu frustrada pelas dificuldades da vida. Para escapar dessa realidade pesada, ela fecha os olhos e foge em seus sonhos para o seu próprio 'paraíso'."));
        lista.add(new Slide("Slide 4", R.drawable.img4, "A faixa 'Purple Desire' existe no mundo real e possui algumas versões e colaborações notáveis em diferentes gêneros.\n 1. Versão Pop / Eletrônica (Clark Sims)A versão mais recente e popular é de Clark Sims, lançada em parceria com o projeto The Grey Room.\n Álbum: B Sides (2025)\nGênero: Bright Pop / Synthpop"));
        lista.add(new Slide("Slide 5", R.drawable.img5, "A música 'Six Seven' seria um thriller sonoro no estilo indie rock alternativo, com uma pegada cinematográfica e cheia de suspense, lembrando a trilha sonora de um filme de espionagem moderno.\n Detalhes da Faixa \nGênero: Indie Rock \n Neo-NoirEstrutura: Uma transição rítmica que começa em um compasso lento de 6/8 e acelera bruscamente para 7/8 no refrão, criando uma sensação de urgência e fuga. \n Sonoridade: Guitarras com distorção matemática (math rock), uma linha de baixo pulsante e vocais duplos (uma voz masculina grave e uma feminina angelical se sobrepondo)."));
        SlideAdapter adapter = new SlideAdapter(lista, texto);
        viewPager.setAdapter(adapter);
    }
}