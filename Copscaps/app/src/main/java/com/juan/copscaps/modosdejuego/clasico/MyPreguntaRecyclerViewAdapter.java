package com.juan.copscaps.modosdejuego.clasico;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juan.copscaps.Pregunta;
import com.juan.copscaps.databinding.FragmentPreguntaBinding;

import java.util.List;

public class MyPreguntaRecyclerViewAdapter extends RecyclerView.Adapter<MyPreguntaRecyclerViewAdapter.ViewHolder> {
    private final List<Pregunta> mValues;

    private Context ccx;

    public MyPreguntaRecyclerViewAdapter( Context context,List<Pregunta> items) {
        this.mValues = items;
        this.ccx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPreguntaBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.num.setText(mValues.get(position).getNumero());
        holder.palabra.setText(mValues.get(position).getPregunta());
        holder.palabraBien.setText(mValues.get(position).getPreguntaBienEscrita());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView num;
        public final TextView palabra;
        public final TextView palabraBien;
        public Pregunta mItem;

        public ViewHolder(FragmentPreguntaBinding binding) {
            super(binding.getRoot());
            num = binding.numpalabra;
            palabra = binding.palabra;
            palabraBien = binding.palabraBien;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + palabra.getText() + "'";
        }
    }
}