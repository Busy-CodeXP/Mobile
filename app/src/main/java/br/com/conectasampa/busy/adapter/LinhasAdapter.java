package br.com.conectasampa.busy.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.Principal;
import java.util.ArrayList;

import br.com.conectasampa.busy.ClassificaActivity;
import br.com.conectasampa.busy.LinhasDetalheActivity;
import model.Linhas;
import br.com.conectasampa.busy.R;

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
        final View rowView = inflater.inflate(R.layout.item_linhas, parent, false);

        TextView nomeLinha = (TextView) rowView.findViewById(R.id.txtNomeLinha);
        TextView descricaoLinha = (TextView) rowView.findViewById(R.id.txtDescricaoLinha);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.icone);

        final Linhas linha = elementos.get(position);

        if(linha.getSl() == 1){
            nomeLinha.setText(elementos.get(position).getLt()+ " - " + linha.getTl());
            descricaoLinha.setText(elementos.get(position).getTp() + " - " + linha.getTs());

        }else{
            nomeLinha.setText(elementos.get(position).getLt()+ " - " + linha.getTl());
            descricaoLinha.setText(elementos.get(position).getTs() + " - " + linha.getTp());

        }

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, LinhasDetalheActivity.class);

                i.putExtra("numlinha", linha.getLt() + " - " + linha.getTl());
                i.putExtra("prefixo", linha.getCl());


                if (linha.getSl() == 1){
                 i.putExtra("nomelinha", linha.getTp()+ " - " + linha.getTs());
                }else{
                    i.putExtra("nomelinha",linha.getTs()+ " - " + linha.getTp());}

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(i);
            }
        });

        return rowView;
    }
}
