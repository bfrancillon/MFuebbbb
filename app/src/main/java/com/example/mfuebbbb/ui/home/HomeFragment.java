package com.example.mfuebbbb.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mfuebbbb.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    //private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    Location currentlocation;
    SupportMapFragment mapFragment;


    MarkerOptions marker;
    MarkerOptions marker1;
    MarkerOptions marker2;
    MarkerOptions marker3;
    MarkerOptions marker4;
    MarkerOptions marker5;

    LatLng centerlocation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //View root = binding.getRoot();


        centerlocation = new LatLng(28.6735353, -81.489182);

        marker= new MarkerOptions().title("7/11")
                .position(new LatLng(28.6735359, -81.489192))
                .snippet("Open 24Hrs");
        marker1= new MarkerOptions().title("ERROX")
                .position(new LatLng(28.597620, -81.396630))
                .snippet("Open 24Hrs");
        marker2= new MarkerOptions().title("Costco")
                .position(new LatLng(28.6041, -81.3006))
                .snippet("Open 24Hrs");
        marker3= new MarkerOptions().title("7/11")
                .position(new LatLng(28.4801, -81.3109))
                .snippet("Open 24Hrs");
        marker4= new MarkerOptions().title("7/11")
                .position(new LatLng(28.5021, -81.3312))
                .snippet("Open 24Hrs");
        marker5= new MarkerOptions().title("7/11")
                .position(new LatLng(28.5056, -81.3140))
                .snippet("Open 24Hrs");

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(HomeFragment.this);
        return root;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        getCurrentLocation();
        mMap.addMarker(marker);
        mMap.addMarker(marker1);
        mMap.addMarker(marker2);
        mMap.addMarker(marker3);
        mMap.addMarker(marker4);
        mMap.addMarker(marker5);

        // Add a marker in Sydney and move the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,8));
    }
    private void getCurrentLocation(){
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED){
            if(mMap != null){
                mMap.setMyLocationEnabled(true);
            }
            else{
                String perms[]= {"android.permissions.ACCESS_FINE_LOCATION"};
                ActivityCompat.requestPermissions(getActivity(),perms,200);
            }
        }

    }
}