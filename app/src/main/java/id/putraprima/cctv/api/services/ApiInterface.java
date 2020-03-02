package id.putraprima.cctv.api.services;

import java.util.List;

import id.putraprima.cctv.api.models.Angkot;
import id.putraprima.cctv.api.models.Envelope;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //angkot
//    @GET("/angkot")
//    Call<List<Angkot>> getAngkot();

    @GET("/angkot")
    Call<Envelope<Angkot>> getAngkot();
}
