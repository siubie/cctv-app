package id.putraprima.cctv.api.converters;

import java.io.IOException;

import id.putraprima.cctv.api.models.Envelope;
import okhttp3.ResponseBody;
import retrofit2.Converter;

class UnwrapEnvelopeConverter<T> implements Converter<ResponseBody, T> {
    final Converter<ResponseBody,Envelope<T>> delegateConverter;
    public UnwrapEnvelopeConverter(Converter<ResponseBody, Envelope<T>> delegateConverter) {
        this.delegateConverter = delegateConverter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        Envelope<T> envelope = delegateConverter.convert(value);
        return envelope.getData();
    }
}
