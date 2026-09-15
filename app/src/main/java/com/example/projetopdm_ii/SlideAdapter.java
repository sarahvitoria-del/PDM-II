package com.example.projetopdm_ii;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SlideAdapter /*classe adapter tem função de juntar tudo*/ extends RecyclerView.Adapter<SlideHolder> {
    private ArrayList<Slide> lista;

    public SlideAdapter (ArrayList<Slide> lista){
        this.lista = lista;
    }


    //___________________________________________________________________________________
    @NonNull
    @Override
    public SlideHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent,false);
        return new SlideHolder(view);
    }
    //___________________________________________________________________________________

    @Override
    public void onBindViewHolder(@NonNull SlideHolder holder, int position) {
        holder.titulo.setText(lista.get(position).getNome());
        holder.imagem.setImageResource(lista.get(position).getImagem());


    }
    //___________________________________________________________________________________

    @Override
    public int getItemCount() {
        return 0;
    }
}
