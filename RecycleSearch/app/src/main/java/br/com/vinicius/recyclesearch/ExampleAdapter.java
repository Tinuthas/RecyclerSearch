package br.com.vinicius.recyclesearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.Holder> {

    List<String> lista;

    public ExampleAdapter(List<String> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View exampleAdapter = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_example, viewGroup, false);
        return new Holder(exampleAdapter);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.textView.setText(lista.get(i));
    }

    @Override
    public int getItemCount() {
        if(lista == null) return 0;
        return lista.size();
    }

    public void filterList(ArrayList<String> filteredList) {
        lista = filteredList;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

    }
}
