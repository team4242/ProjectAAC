package com.example.projectaac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location_recommend extends FragmentActivity implements OnMapReadyCallback {

    private FragmentManager FragmentManager;
    private MapFragment mapFragment;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_recommend);

        btn_back = (Button)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CommunicationPlate.class);
                startActivity(intent);
            }
        });

        FragmentManager = getFragmentManager();
        mapFragment = (MapFragment)FragmentManager.findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap){
        LatLng location = new LatLng(36.369042, 127.346312);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title("충남대학교");
        markerOptions.snippet("대학교");
        markerOptions.position(location);
        googleMap.addMarker(markerOptions);

        LatLng location2 = new LatLng(36.365152, 127.34662);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.title("공대3호관");
        markerOptions2.snippet("강의실");
        markerOptions2.position(location2);
        googleMap.addMarker(markerOptions2);

        LatLng location3 = new LatLng(36.36830, 127.34180);
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.title("인문대학");
        markerOptions3.snippet("강의실");
        markerOptions3.position(location3);
        googleMap.addMarker(markerOptions3);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
    }
}