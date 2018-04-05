package br.com.conectasampa.busy.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.conectasampa.busy.ClassificaActivity;
import br.com.conectasampa.busy.LinhasActivity;
import br.com.conectasampa.busy.R;
import model.LinhaDetalheResult;
import model.Linhas;
import model.LinhasDetalhe;
import services.BusyRestService;

import static android.content.Intent.getIntent;
import static android.content.Intent.normalizeMimeType;

public class LinhasDetalheAdapter extends ArrayAdapter {

    private final Context context;
    private final List<LinhasDetalhe> elementos;
    private String linhaNum = "";
    private String linhaNome = "";
    private ImageView imagem;

    final BusyRestService service = new BusyRestService();

    public LinhasDetalheAdapter(Context context, List<LinhasDetalhe> elementos, String linhaNum, String linhaNome) {
        super(context, R.layout.item_linhasdetalhe, elementos);

        this.context = context;
        this.elementos = elementos;
        this.linhaNum = linhaNum;
        this.linhaNome = linhaNome;
        this.imagem = imagem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.item_linhasdetalhe, parent, false);


        TextView numLinha = (TextView) rowView.findViewById(R.id.txtNumLinha);
        numLinha.setText(linhaNum);

        TextView descricaoLinha = (TextView) rowView.findViewById(R.id.txtDescricaoLinha);
        descricaoLinha.setText(linhaNome);

        ImageView imagem = (ImageView) rowView.findViewById(R.id.icone);

        final LinhasDetalhe linha = elementos.get(position);

        TextView lotacaoLinha = (TextView) rowView.findViewById(R.id.txtLotacaoLinha);
        lotacaoLinha.setText("Lotação: " + elementos.get(position).getLotacao() + " %");

        if (Integer.parseInt(linha.getLotacao()) <= 30) {
            imagem.setImageResource(R.drawable.bus_green3);

        }
        else if (Integer.parseInt(linha.getLotacao()) > 30 & Integer.parseInt(linha.getLotacao()) <= 80) {
            imagem.setImageResource(R.drawable.bus_yellow3);

        } else
            imagem.setImageResource(R.drawable.bus_red3);


        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ClassificaActivity.class);
                i.putExtra("numlinha",linhaNum + " - " + linhaNome);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(i);
            }
        });

        return rowView;
    }
}
