package ie.ul.googlemaps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.Objects;


public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mapWindow;
    private Context mapContext;

    public CustomInfoWindowAdapter(Context context){
        mapContext = context;
        mapWindow = LayoutInflater.from(context).inflate(R.layout.info_window,null);
    }
    private void renderWindowText(Marker marker, View view){
        String title = marker.getTitle();
        TextView infoTitle;
        infoTitle = (TextView) view.findViewById(R.id.title);

        if(!Objects.equals(title, "")) infoTitle.setText(title);

        String snippet =  marker.getSnippet();
        TextView infoSnippet;
        infoSnippet = (TextView) view.findViewById(R.id.snippet);

        if(!Objects.equals(snippet, "")) infoSnippet.setText(snippet);

    }
    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker, mapWindow);
        return mapWindow;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker, mapWindow);
        return mapWindow;
    }
}
