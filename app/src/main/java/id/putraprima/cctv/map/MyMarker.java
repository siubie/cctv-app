package id.putraprima.cctv.map;

import android.content.Context;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MyMarker extends Marker {
    private Context context;

    public MyMarker(MapView mapView) {
        super(mapView);
    }

    public MyMarker(MapView mapView, Context resourceProxy) {
        super(mapView, resourceProxy);
        this.context = resourceProxy;
    }

}
