package com.example.projetopdm_ii;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, Runnable, View.OnClickListener{
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekbar;
    private Handler handler;
    private Button b;
    private boolean flag;
    private int musica;
    //___________________________________________________________________________________________________________________________

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); //a depender do tipo de dispositivo, o app ira prenecer a tela toda no maximo posivel
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.toolbar);
        //atribui a toolbar o "poder" de ActionBar
        setSupportActionBar(toolbar);
        //habilita o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //🠔
        seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(this);
        handler = new Handler();

        b = findViewById(R.id.button2);
        b.setOnClickListener(this);
        flag = false;
        musica = R.raw.forrodofarol_quincasmoreira;


    }
    //___________________________________________________________________________________________________________________________

    public  boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            finish();
        }    //____________________________Runnable__________________________________________________________________________________________

        if (id == R.id.id001){ //se for o id 001 quer dizer que é para dar play
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, musica);
                mediaPlayer.setOnCompletionListener(this);
                seekbar.setMax(mediaPlayer.getDuration());
                handler.post(this);
                mediaPlayer.start();
            }else if (!mediaPlayer.isPlaying()){//se o mediaPlayer NÃO estiver tocando
                mediaPlayer.start();
            }

        }
        if (id == R.id.id003){
            if (mediaPlayer != null){
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;

            }
        }
        if (id == R.id.id002){
            if (mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
        return false;
    }
    //___________________________________________________________________________________________________________________________
    public boolean onCreateOptionsMenu(Menu menu) {//inflar o menu na tela 2
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }
    //___________________________________________________________________________________________________________________________
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        mediaPlayer = null;
        seekbar.setProgress(0); //a bolinha volta para o inicio quando damos pare

    }
    //___________________________SeekBar.OnSeekBarChangeListener__________________________________________________________________

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }
    //____________________________________________
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    //____________________________________________

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { //metodo do controle da bolinha
        if (mediaPlayer!=null){
            mediaPlayer.seekTo((seekBar.getProgress()));
        }

    }
    //____________________________Runnable__________________________________________________________________________________________
    @Override
    public void run() {
        if (mediaPlayer!=null){
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this, 1000);
        }

    }
    //____________________________View.OnClickListener______________________________________________________________________________

    @Override
    public void onClick(View view) {
        //ação veio do botão
        if (view == b){
            if (flag){
                musica = R.raw.forrodofarol_quincasmoreira;
                flag = true;

            }else {
                musica = R.raw.sixseven;
                flag = false;

            }
        }
    }

}