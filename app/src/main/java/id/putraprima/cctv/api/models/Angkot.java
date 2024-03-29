package id.putraprima.cctv.api.models;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.putraprima.cctv.R;

public class Angkot extends AbstractItem<Angkot, Angkot.ViewHolder> {
    public int id;
    public String nama;
    public String rute;
    public String peta_keluar;
    public String peta_masuk;
    public String jalur_masuk;
    public String jalur_keluar;

    public Angkot(int id, String nama, String rute, String peta_keluar, String peta_masuk, String jalur_masuk, String jalur_keluar) {
        this.id = id;
        this.nama = nama;
        this.rute = rute;
        this.peta_keluar = peta_keluar;
        this.peta_masuk = peta_masuk;
        this.jalur_masuk = jalur_masuk;
        this.jalur_keluar = jalur_keluar;
    }

    public String getPeta_masuk() {
        return peta_masuk;
    }

    public void setPeta_masuk(String peta_masuk) {
        this.peta_masuk = peta_masuk;
    }

    public String getJalur_masuk() {
        return jalur_masuk;
    }

    public void setJalur_masuk(String jalur_masuk) {
        this.jalur_masuk = jalur_masuk;
    }

    public String getJalur_keluar() {
        return jalur_keluar;
    }

    public void setJalur_keluar(String jalur_keluar) {
        this.jalur_keluar = jalur_keluar;
    }

    public Angkot(int id, String nama, String rute, String peta_keluar) {
        this.id = id;
        this.nama = nama;
        this.rute = rute;
        this.peta_keluar = peta_keluar;
    }

    public Angkot() {
    }

    @NonNull
    @Override
    public Angkot.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public String getPeta_keluar() {
        return peta_keluar;
    }

    public void setPeta_keluar(String peta_keluar) {
        this.peta_keluar = peta_keluar;
    }

    @Override
    public int getType() {
        return R.id.rv_angkot;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_angkot;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<Angkot> {
        @BindView(R.id.nama_angkot)
        TextView nama_angkot;

        @BindView(R.id.rute_angkot)
        TextView rute_angkot;

        @BindView((R.id.peta_angkot))
        ImageView peta_angkot;

//        @BindView(R.id.jalur_masuk)
//        TextView jalur_masuk;
//
//        @BindView(R.id.jalur_keluar)
//        TextView jalur_keluar;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(Angkot item, List<Object> payloads) {
            nama_angkot.setText(item.getNama());
            rute_angkot.setText(item.getRute());
//            jalur_masuk.setText(item.getJalur_masuk());
//            jalur_keluar.setText(item.getJalur_keluar());
            Glide.with(itemView.getContext())
                    .setDefaultRequestOptions(new RequestOptions().timeout(300000))
                    .load("https://cctv.putraprima.id/uploads/"+item.getPeta_keluar())
                    .dontTransform()
                    .into(peta_angkot);
        }

        @Override
        public void unbindView(Angkot item) {
            nama_angkot.setText(null);
            rute_angkot.setText(null);
//            jalur_masuk.setText(null);
//            jalur_keluar.setText(null);
        }
    }
}
