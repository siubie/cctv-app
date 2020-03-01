package id.putraprima.cctv.api.converters;

import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import id.putraprima.cctv.api.models.Envelope;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class UnwrapEnvelopeConverterFactory extends Converter.Factory{
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Type envelopeType = com.google.inject.util.Types.newParameterizedType(Envelope.class,type);
        final Converter<ResponseBody,Envelope> delegateConverter =
                retrofit.nextResponseBodyConverter(this,envelopeType,annotations);
        return new UnwrapEnvelopeConverter(delegateConverter);
    }
}
