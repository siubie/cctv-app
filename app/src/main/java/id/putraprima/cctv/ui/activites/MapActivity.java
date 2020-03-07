package id.putraprima.cctv.ui.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;
import java.util.List;

import id.putraprima.cctv.R;
import id.putraprima.cctv.api.helper.ServiceGenerator;
import id.putraprima.cctv.api.models.Cctv;
import id.putraprima.cctv.api.models.Envelope;
import id.putraprima.cctv.api.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapActivity extends AppCompatActivity {
    MapView map = null;
    Context ctx;
    ItemizedIconOverlay<OverlayItem> mOverlay;
    IMapController mapController;
    List<Cctv> cctvList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        this.ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setMultiTouchControls(true);


        requestCctvList();
        GeoPoint startPoint = new GeoPoint(-7.9771298, 112.6318751);
        ArrayList<OverlayItem> items = items = new ArrayList<OverlayItem>();
        mOverlay = new ItemizedIconOverlay<>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int position, final OverlayItem item) {
                        Toast.makeText(ctx,"Position :"+position,Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ctx, CctvActivity.class);
                        i.putExtra("stream_url",cctvList.get(position).getStream_url());
                        startActivity(i);
                        return true;
                    }

                    @Override
                    public boolean onItemLongPress(final int position, final OverlayItem item) {
                        return false;
                    }
                }, getApplicationContext());
        mapController = map.getController();
        mapController.setZoom(5.0);
        mapController.setCenter(startPoint);


    }

    private void requestCctvList() {
        Log.d("OVERLAY", "Dipanggil");
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);
        Call<Envelope<List<Cctv>>> call = service.getCctv();
        call.enqueue(new Callback<Envelope<List<Cctv>>>() {
            @Override
            public void onResponse(Call<Envelope<List<Cctv>>> call, Response<Envelope<List<Cctv>>> response) {
                if (response.isSuccessful()) {
                    Log.d("OVERLAY", "Masuk");
                    cctvList.addAll(response.body().getData());
                    for (Cctv cctv : response.body().getData()) {
                        Log.d("OVERLAY", String.valueOf(response.body().getData()));
                        GeoPoint startPoint = new GeoPoint(cctv.getLatitude(), cctv.getLongitude());
                        OverlayItem olItem = new OverlayItem("Here", "SampleDescription", startPoint);
                        Drawable newMarker = ctx.getResources().getDrawable(R.drawable.marker);
                        olItem.setMarker(newMarker);
                        mOverlay.addItem(olItem);
                    }
                    map.getOverlays().add(mOverlay);
                    mapController.setZoom(14.0);
                }
            }

            @Override
            public void onFailure(Call<Envelope<List<Cctv>>> call, Throwable t) {
                Log.e("Error fetching angkot", t.getMessage());
                Log.d("OVERLAY", "Gagal");
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }
}

