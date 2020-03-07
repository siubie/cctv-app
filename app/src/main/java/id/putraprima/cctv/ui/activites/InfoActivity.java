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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.putraprima.cctv.R;
import id.putraprima.cctv.api.helper.ServiceGenerator;
import id.putraprima.cctv.api.models.Envelope;
import id.putraprima.cctv.api.models.Info;
import id.putraprima.cctv.api.services.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {
    @BindView(R.id.rv_info)
    RecyclerView rv_info;

    List<Info> infoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        ItemAdapter itemAdapter = new ItemAdapter();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

        fastAdapter.withOnClickListener(new OnClickListener() {
            @Override
            public boolean onClick(View v, IAdapter adapter, IItem item, int position) {
                Toast.makeText(InfoActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        rv_info.setAdapter(fastAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_info.setLayoutManager(layoutManager);

        ApiInterface service = ServiceGenerator.createService(ApiInterface.class);

        Call<Envelope<List<Info>>> call = service.getInfo();
        call.enqueue(new Callback<Envelope<List<Info>>>() {
            @Override
            public void onResponse(Call<Envelope<List<Info>>> call, Response<Envelope<List<Info>>> response) {
                if (response.isSuccessful()) {
                    itemAdapter.add(response.body().getData());
                    infoList.addAll(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<Envelope<List<Info>>> call, Throwable t) {
                Log.e("Error fetching angkot", t.getMessage());
            }
        });
    }
}
