package id.putraprima.cctv.ui.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.util.List;

import butterknife.BindView;
import id.putraprima.cctv.R;
import id.putraprima.cctv.api.helper.ServiceGenerator;
import id.putraprima.cctv.api.models.Angkot;
import id.putraprima.cctv.api.models.Envelope;
import id.putraprima.cctv.api.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AngkotActivity extends AppCompatActivity {
    RecyclerView rv_angkot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angkot);
        rv_angkot = findViewById(R.id.rv_angkot);

        ItemAdapter itemAdapter = new ItemAdapter();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);
        fastAdapter.withOnClickListener(new OnClickListener() {
            @Override
            public boolean onClick(View v, IAdapter adapter, IItem item, int position) {
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        rv_angkot.setAdapter(fastAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_angkot.setLayoutManager(layoutManager);
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);

        Call<Envelope<List<Angkot>>> call = service.getAngkot();
        call.enqueue(new Callback<Envelope<List<Angkot>>>() {
            @Override
            public void onResponse(Call<Envelope<List<Angkot>>> call, Response<Envelope<List<Angkot>>> response) {
                if (response.isSuccessful()) {
                    itemAdapter.add(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<Envelope<List<Angkot>>> call, Throwable t) {
                Log.e("Error fetching angkot", t.getMessage());
            }
        });
    }
}
