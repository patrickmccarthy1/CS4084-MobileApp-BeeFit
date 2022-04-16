package com.example.beefit;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(MAP, "onMapReady: map is ready");
        map = googleMap;
        //calling DeviceLocation()
        if (mapAccessLocation) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            map.setMyLocationEnabled(true);

        }
        //hard coded longitudes and latitudes
        LatLng M1 = new LatLng(52.637372742442196, -8.645093526881073);
        LatLng M2= new LatLng(52.674720786335726, -8.677357487025255);
        LatLng M3= new LatLng(52.687240468528074, -8.576542148819742);
        LatLng M4= new LatLng(52.66056011361746, -8.622041987026016);
        LatLng M5= new LatLng(52.67267504267902, -8.619206855155992);
        LatLng M6 = new LatLng(52.62947797946474, -8.665615925131094);
        LatLng M7= new LatLng(52.64920896700298, -8.59994266704112);
        LatLng M8= new LatLng(52.64796871601961, -8.584736768961324);
        LatLng M9= new LatLng(52.625292036092695, -8.653313669228476);
        LatLng M10= new LatLng(52.6578634922227, -8.594934500247012);
        //Calling CustomInfoWindow
        map.setInfoWindowAdapter(new com.example.beefit.CustomInfoWindowAdapter(MapActivity.this));
        //Snippets for markers
        String snippet1 = String.format("Unit 34, Crescent Shopping Centre DOORADOYLE  \nPhone Number: (061) 308 199\n" +
                "Eircode:  V94 RH36 \nOpening: 7:00a.m.– 10p.m.\n");

        String snippet2 = String.format("Coonagh Cross, Coonagh Rd, Knock, Limerick\nPhone Number: 061422350\n" +
                "Eircode: V94 E5F6\nOpening: 6a.m.–10p.m.\n");

        String snippet3 = String.format("Address: University of Limerick, Sreelane, Limerick\nPhone Number: 061213555\n" +
                "Website: http://www.ulsport.ie\nOpening: 6:30a.m.–11p.m.\n");

        String snippet4 = String.format("Address: 17 Sexton St, Limerick,  \nWebsite: http://www.citygymlk.com\n" +
                "Eircode: V94 N5NH\nOpening: 7:00a.m.– 9p.m.\n");

        String snippet5 = String.format("Address: Abbey River Court, Unit 1, Island Rd, Limerick\nPhone Number: 061511040\n" +
                "Eircode: V94 42V0\nOpening: 6:30a.m.–10p.m.\n");

        String snippet6 = String.format("Address: Courtfields Shopping Centre, Courtfields, Raheen, Limerick  \nPhone Number: 061303586\n" +
                "Website: http://www.womensgym.ie\nOpening: 6:30a.m.–9:30p.m.\n");

        String snippet7 = String.format("Address: Unit1 Kilmallock road ind estate, Kilmallock road, Limerick\nPhone Number: 0857352296\n" +
                "Website: http://www.thefitfactorylimerick.com\nOpening: 6a.m.–8p.m.\n");

        String snippet8 = String.format("Address: Unit 1B Delta Sports Dome Delta Retail Park, Ballysimon Rd, Limerick\nPhone Number: 0858634090\n" +
                "Website:http://www.peakhealth.ie\nOpening: Friday, 6:30a.m.–10p.m.\n");

        String snippet9 = String.format("Address: Raheen Business Park, Raheen, Limerick,  Limerick\nPhone Number: 061309062\n" +
                "Website:http://www.tbb.ie\n Eircode: V94 27P2 \n Opening: 6a.m.–9p.m.\n");

        String snippet10 = String.format("Address: Childers Retail Park, Childers Rd, Limerick\nPhone Number: 061422350\n" +
                "Website: http://www.planethealthlimerick.ie/\nOpening: Friday, 6:30a.m.–10p.m.\n");


        //Markers featured in map
        map.addMarker(new MarkerOptions()
                .position(M1)
                .snippet(snippet1)
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.dooradoyle))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                .title("Dooradoyle Gym"));

        map.addMarker(new MarkerOptions()
                .position(M2)
                .snippet(snippet2)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.gogym2))
                .title("GO GYM Limerick"));

        map.addMarker(new MarkerOptions()
                .position(M3)
                .snippet(snippet3)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.university))
                .title("University of Limerick Gym"));

        map.addMarker(new MarkerOptions()
                .position(M4)
                .snippet(snippet4)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.citygym))
                .title("City Gym"));

        map.addMarker(new MarkerOptions()
                .position(M5)
                .snippet(snippet5)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.energia))
                .title("Energia Gym"));

        map.addMarker(new MarkerOptions()
                .position(M6)
                .snippet(snippet6)
               .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.limerickgym))
                .title("Woman's Fitness Limerick"));

        map.addMarker(new MarkerOptions()
                .position(M7)
                .snippet(snippet7)
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.limerickgym))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET))
                .title("The Fit Factory"));

        map.addMarker(new MarkerOptions()
                .position(M8)
                .snippet(snippet8)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.limerickgym))
                .title("Peak Fit"));

        map.addMarker(new MarkerOptions()
                .position(M9)
                .snippet(snippet9)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.limerickgym))
                .title("TBB, The Body Building - Motivated Fitness"));

        map.addMarker(new MarkerOptions()
                .position(M10)
                .snippet(snippet10)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.limerickgym))
                .title("Planet Health Club"));
    }

    private static final String MAP = "MapActivity";

    private static final String LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String LOCATION2 = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final float APP_ZOOM = 11f;
    //vars
    private Boolean mapAccessLocation = false;
    private GoogleMap map;
    private FusedLocationProviderClient mapCurrentLocation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getLocation();
    }

    private void getDeviceLocation() {
        mapCurrentLocation = LocationServices.getFusedLocationProviderClient(this);
            if (mapAccessLocation) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Task location = mapCurrentLocation.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {

                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            Location currentLocation = (Location) task.getResult();
                            //Move camera and zoom to user location
                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    APP_ZOOM);

                        }
                    }
                });
            }

            }

    private void moveCamera(LatLng latLng, float zoom){
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }


    //method intialises map fragment
    private void initMap(){
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapActivity.this);

        }

    private void getLocation() {

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    LOCATION2) == PackageManager.PERMISSION_GRANTED) {
                mapAccessLocation = true;
                initMap();
            }

        }
    }

}

