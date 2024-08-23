package com.example.cortemaestro;


import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.cortemaestro.databinding.ActivityMapsBinding;

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
        mMap = googleMap;

        // SEDES RESTAURANTE
        LatLng poblado = new LatLng(6.208576132151832, -75.56599418978841);
        LatLng llanoGrande = new LatLng(6.119895585632587, -75.41900036058239);
        LatLng laureles = new LatLng(6.246024919486562, -75.58934120186791);

        mMap.addMarker(new MarkerOptions().position(poblado).title("Sede poblado"));
        mMap.addMarker(new MarkerOptions().position(llanoGrande).title("Sede llano grande"));
        mMap.addMarker(new MarkerOptions().position(laureles).title("Sede laureles"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(poblado, 10));

        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }
}