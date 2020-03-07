package id.putraprima.cctv.ui.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ortiz.touchview.TouchImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.putraprima.cctv.R;

public class AngkotDetailActivity extends AppCompatActivity {
    public String nama, rute, peta_angkot, jalur_masuk, jalur_keluar;
    @BindView(R.id.judul)
    TextView nama_angkot;
    @BindView(R.id.pengumuman)
    TextView rute_angkot;
    @BindView(R.id.peta_angkot)
    TouchImageView img_peta_angkot;
    @BindView(R.id.jalur_masuk)
    TextView txt_jalur_masuk;
    @BindView(R.id.jalur_keluar)
    TextView txt_jalur_keluar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angkot_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        nama = bundle.getString("nama");
        rute = bundle.getString("rute");
        peta_angkot = bundle.getString("peta_angkot");
        jalur_masuk = bundle.getString("jalur_masuk");
        jalur_keluar = bundle.getString("jalur_keluar");

        nama_angkot.setText(nama);
        rute_angkot.setText(rute);
        txt_jalur_keluar.setText(jalur_keluar);
        txt_jalur_masuk.setText(jalur_masuk);

        Glide.with(getApplicationContext())
                .setDefaultRequestOptions(new RequestOptions().timeout(300000))
                .load("https://cctv.putraprima.id/uploads/"+peta_angkot)
                .dontTransform()
                .into(img_peta_angkot);


    }
}
