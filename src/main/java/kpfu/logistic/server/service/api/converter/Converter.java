package kpfu.logistic.server.service.api.converter;

public interface Converter<T, V> {

    V convert(T t);

}
