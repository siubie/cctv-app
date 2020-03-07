package id.putraprima.cctv.api.models;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.putraprima.cctv.R;

public class Info extends AbstractItem<Info,Info.ViewHolder> {

    public String judul,pengumuman;

    public Info(String judul, String pengumuman) {
        this.judul = judul;
        this.pengumuman = pengumuman;
    }

    public Info() {
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengumuman() {
        return pengumuman;
    }

    public void setPengumuman(String pengumuman) {
        this.pengumuman = pengumuman;
    }

    @NonNull
    @Override
    public Info.ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.rv_info;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_info;
    }

    public class ViewHolder extends FastAdapter.ViewHolder<Info>{
        @BindView(R.id.txt_info_judul)
        TextView txt_info_judul;

        @BindView(R.id.txt_info_pengumuman)
        TextView txt_info_pengumuman;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void bindView(Info item, List<Object> payloads) {
            txt_info_judul.setText(item.getJudul());
            txt_info_pengumuman.setText(item.getPengumuman());
        }

        @Override
        public void unbindView(Info item) {
            txt_info_pengumuman.setText(null);
            txt_info_judul.setText(null);

        }
    }
}

