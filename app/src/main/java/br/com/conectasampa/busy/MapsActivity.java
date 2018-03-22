package br.com.conectasampa.busy;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static br.com.conectasampa.busy.util.MessageHelper.MostraMensagem;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView txt_buscaLinha;
    private SearchView sv_lupaLinha;
    private final Activity act = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        txt_buscaLinha = (TextView) findViewById(R.id.txt_buscaLinha);
        sv_lupaLinha = (SearchView) findViewById(R.id.sv_lupaLinha);

        /* chamar a Activity lista de Linhas
        sv_lupaLinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(act, LinhasActivity.class);
                startActivity(i);
                finish();
            }
        });
        */

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in local and move the camera

       LatLng local = new LatLng(-23.535978, -46.612752);

       mMap.moveCamera(CameraUpdateFactory.newLatLng(local));
       mMap.addMarker(new MarkerOptions().position(local).title("Você está aqui!"));

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                } else {
                MostraMensagem(act, "Erro na validação", "Sem permissão. Ative a localização");
                return;
            }

    }


}
