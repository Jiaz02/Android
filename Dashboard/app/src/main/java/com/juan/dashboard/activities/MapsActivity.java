package com.juan.dashboard.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.juan.dashboard.R;
import com.juan.dashboard.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //Le decimos que los estilos de mapa que queremos enstan en el recurso que nos hemos traido
        // personalizar mapa
        try {
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(this, R.raw.style)
            );
            if(!success){
                Log.e("Mapas","existe el recurso pero no lo cargamos bien");
            }
        }catch (Resources.NotFoundException e){
            Log.e("Mapas","existe el recurso pero no lo cargamos bien");
        }
        mMap = googleMap;
        //si lo cambias cambia el tipo de mapa a satelite etc...
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        // Add a marker in Sydney and move the camera
        LatLng alcañiz = new LatLng(41.04935, -0.12681);
        mMap.addMarker(new MarkerOptions().position(alcañiz).title("Marker in Alcañiz"));

        LatLng Ichiraku = new LatLng(41.034042,-0.159670);
        LatLng Clam = new LatLng(41.054387,-0.127515);
        LatLng Maclaren = new LatLng(40.977067,-0.154186);
        LatLng Moe = new LatLng(40.979961,-0.145108);
        LatLng Pollos = new LatLng(41.047484,-0.129865);
        LatLng Roger = new LatLng(41.052866,-0.131594);
        LatLng Anteiku = new LatLng(41.045941,-0.133969);
        LatLng Yukihira = new LatLng(41.050331,-0125705);
        LatLng Crustaceo = new LatLng(41.052926,-0.134497);
        LatLng Resort = new LatLng(41.065649,-0.202386);
        mMap.addMarker(new MarkerOptions().position(Ichiraku).title("Ichiraku Ramen").snippet("Telefono ; 978456123"));
        mMap.addMarker(new MarkerOptions().position(Clam).title("The Drunken Clam").snippet("Telefono ; 978456124"));
        mMap.addMarker(new MarkerOptions().position(Maclaren).title("Maclaren's Pub").snippet("Telefono ; 978456125"));
        mMap.addMarker(new MarkerOptions().position(Moe).title("Moe's").snippet("Telefono ; 978456123"));
        mMap.addMarker(new MarkerOptions().position(Pollos).title("Los Pollos Hermanos").snippet("Telefono ; 978456124"));
        mMap.addMarker(new MarkerOptions().position(Roger).title("Roger's Place").snippet("Telefono ; 978456125"));
        mMap.addMarker(new MarkerOptions().position(Anteiku).title("Anteiku").snippet("Telefono ; 978456123"));
        mMap.addMarker(new MarkerOptions().position(Yukihira).title("Yukihira").snippet("Telefono ; 978456124"));
        mMap.addMarker(new MarkerOptions().position(Crustaceo).title("Crustaceo Crugiente").snippet("Telefono ; 978456125"));
        mMap.addMarker(new MarkerOptions().position(Resort).title("Resort Tōtsuki").snippet("Telefono ; 978456125"));


        mMap.moveCamera(CameraUpdateFactory.newLatLng(alcañiz));
    }
}