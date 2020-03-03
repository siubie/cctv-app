package id.putraprima.cctv.ui.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.putraprima.cctv.R;

public class AngkotDetailActivity extends AppCompatActivity {
    public String nama, rute, peta;
    @BindView(R.id.nama_angkot)
    TextView nama_angkot;
    @BindView(R.id.rute_angkot)
    TextView rute_angkot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angkot_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("nama");
        rute = bundle.getString("rute");
        peta = bundle.getString("peta");

        nama_angkot.setText(nama);
        rute_angkot.setText(rute);


    }
}
