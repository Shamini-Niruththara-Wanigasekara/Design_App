package com.example.designapp_final;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.SearchView;

import com.example.designapp_final.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.designapp_final.databinding.ActivityMapsSearchBinding;

import java.io.IOException;
import java.util.List;

public class MapsActivitySearch extends DrawerBaseActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    SearchView searchView;
    private int ACCESS_LOCATION_REQUEST_CODE = 1001;
    private ActivityMapsSearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        allocateActivityTitle("Search Location");
        searchView = findViewById(R.id.sv_location);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;

                if (location != null || !location.equals("")) {
                    Geocoder geocoder = new Geocoder((MapsActivitySearch.this));
                    try {
                        addressList = geocoder.getFromLocationName(location, 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng((address.getLatitude()), address.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
//        if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) == getPackageManager().PERMISSION_GRANTED ){
//            enableuserlocation();
//        }else {
//            if(ActivityCompat.shouldShowRequestPermissionRationale(this, ACCESS_FINE_LOCATION)){
//                ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, ACCESS_LOCATION_REQUEST_CODE);
//            }
//            else{
//                ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, ACCESS_LOCATION_REQUEST_CODE);
//            }
//        }
//        LatLng sydney = new LatLng(6.914936, 79.889164);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Cycle Location"));
//
//        LatLng sydney1 = new LatLng(5.914936, 89.889164);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Cycle Location1 "));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney1));
//
//        }
//
//    private void enableuserlocation() {
//    }


    }
}
