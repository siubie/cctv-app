package id.putraprima.cctv.api.models;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
    public String peta;

    public Angkot(int id, String nama, String rute, String peta) {
        this.id = id;
        this.nama = nama;
        this.rute = rute;
        this.peta = peta;
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

    public String getPeta() {
        return peta;
    }

    public void setPeta(String peta) {
        this.peta = peta;
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

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(Angkot item, List<Object> payloads) {
            nama_angkot.setText(item.getNama());
            rute_angkot.setText(item.getRute());
            Glide.with(itemView.getContext()).load("https://cctv.putraprima.id/uploads/"+item.getPeta()).into(peta_angkot);
        }

        @Override
        public void unbindView(Angkot item) {
            nama_angkot.setText(null);
            rute_angkot.setText(null);
        }
    }
}
