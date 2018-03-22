package br.com.conectasampa.busy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import model.Linhas;
import br.com.conectasampa.busy.R;

/**
 * Created by dfernandes on 19/03/2018.
 */

public class LinhasAdapter extends ArrayAdapter {

    private final Context context;
    private final ArrayList<Linhas> elementos;
    public LinhasAdapter(Context context, ArrayList<Linhas> elementos) {
        super(context, R.layout.item_linhas, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_linhas, parent, false);

        TextView nomeLinha = (TextView) rowView.findViewById(R.id.txtNomeLinha);
        TextView descricaoLinha = (TextView) rowView.findViewById(R.id.txtDescricaoLinha);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.icone);

        nomeLinha.setText(elementos.get(position).getNomeLinha());
        descricaoLinha.setText(elementos.get(position).getDescricaoLinha());
        imagem.setImageResource(elementos.get(position).getImagem());

        return rowView;
    }
}
