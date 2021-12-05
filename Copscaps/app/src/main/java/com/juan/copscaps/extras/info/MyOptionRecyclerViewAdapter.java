package com.juan.copscaps.extras.info;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.juan.copscaps.databinding.FragmentOptionBinding;

import java.util.List;

public class MyOptionRecyclerViewAdapter extends RecyclerView.Adapter<MyOptionRecyclerViewAdapter.ViewHolder> {
    private final List<Option> mValues;

    private Context ccx;

    public MyOptionRecyclerViewAdapter(Context context, List<Option> items) {
        mValues = items;
        ccx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentOptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNombre());
        holder.mContentView.setText(mValues.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Option mItem;

        public ViewHolder(FragmentOptionBinding binding) {
            super(binding.getRoot());
            mIdView = binding.nombre;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}