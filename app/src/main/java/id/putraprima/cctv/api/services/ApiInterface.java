package id.putraprima.cctv.api.services;

import java.util.List;

import id.putraprima.cctv.api.models.Angkot;
import id.putraprima.cctv.api.models.Cctv;
import id.putraprima.cctv.api.models.Envelope;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/angkot")
    Call<Envelope<List<Angkot>>> getAngkot();

    @GET("/cctv")
    Call<Envelope<List<Cctv>>> getCctv();
}
