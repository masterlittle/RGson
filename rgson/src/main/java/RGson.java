import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.Subscriber;
import rx.annotations.Experimental;


/**
 * Created by Shitij on 21/07/16.
 */
public class RGson {

    @Nullable
    private Gson gson;

    public RGson(@Nullable Gson gson) {
        if (gson == null) throw new NullPointerException("mapper == null");
        this.gson = gson;
    }

    public static RGson create(Gson gson) {
        return new RGson(gson);
    }

    public static RGson create() {
        return create(new Gson());
    }









    /*
    /**********************************************************
    /* Observable wrapper over gson type conversion
    /**********************************************************
     */


    public <T> Observable<T> read(final String value, final Class<T> classInstance) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, value, classInstance);
            }
        });
    }

    public <T> Observable<T> read(final String value, final Type type) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, value, type);
            }
        });
    }

    public <T> Observable<T> read(final Reader reader, final Type type) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, reader, type);
            }
        });
    }

    public <T> Observable<T> read(final Reader reader, final Class<T> classInstance) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, reader, classInstance);
            }
        });
    }

    public <T> Observable<T> read(final JsonReader jsonReader, final Type type) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, jsonReader, type);
            }
        });
    }

    public <T> Observable<T> read(final JsonReader jsonReader, final Class<T> classInstance) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, jsonReader, classInstance);
            }
        });
    }

    public <T> Observable<T> read(final JsonElement jsonElement, final Type type) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, jsonElement, type);
            }
        });
    }

    public <T> Observable<T> read(final JsonElement jsonElement, final Class<T> classInstance) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return GsonFunctions.readValue(gson, jsonElement, classInstance);
            }
        });
    }

    public Observable<String> write(final Object object) {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return GsonFunctions.writeValue(gson, object);
            }
        });
    }

    public Observable<String> write(final Object object, final Type type) {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return GsonFunctions.writeValue(gson, object, type);
            }
        });
    }

    public Observable<String> write(final JsonElement jsonElement) {

        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return GsonFunctions.writeValue(gson, jsonElement);
            }
        });
    }

    public Observable<Void> write(final Object object, final Appendable writer) {
        return Observable.fromCallable(new Callable<Void>() {
            @Nullable
            @Override
            public Void call() throws Exception {
                GsonFunctions.writeValue(gson, object, writer);
                return null;
            }
        });
    }

    public Observable<Void> write(final Object object, final Type type, final Appendable writer) {
        return Observable.fromCallable(new Callable<Void>() {
            @Nullable
            @Override
            public Void call() throws Exception {
                GsonFunctions.writeValue(gson, object, type, writer);
                return null;
            }
        });
    }

    public Observable<Void> write(final Object object, final Type type, final JsonWriter
            jsonWriter) {
        return Observable.fromCallable(new Callable<Void>() {
            @Nullable
            @Override
            public Void call() throws Exception {
                GsonFunctions.writeValue(gson, object, type, jsonWriter);
                return null;
            }
        });
    }

    public Observable<Void> write(final JsonElement jsonElement, final Type type, final
    Appendable writer) {
        return Observable.fromCallable(new Callable<Void>() {
            @Nullable
            @Override
            public Void call() throws Exception {
                GsonFunctions.writeValue(gson, jsonElement, type, writer);
                return null;
            }
        });
    }

    public Observable<Void> write(final JsonElement jsonElement, final Appendable writer) {
        return Observable.fromCallable(new Callable<Void>() {
            @Nullable
            @Override
            public Void call() throws Exception {
                GsonFunctions.writeValue(gson, jsonElement, writer);
                return null;
            }
        });
    }

    public Observable<Void> write(final JsonElement jsonElement, final Type type, final
    JsonWriter jsonWriter) {
        return Observable.fromCallable(new Callable<Void>() {
            @Nullable
            @Override
            public Void call() throws Exception {
                GsonFunctions.writeValue(gson, jsonElement, type, jsonWriter);
                return null;
            }
        });
    }

    public Observable<Void> write(final JsonElement jsonElement, final JsonWriter jsonWriter) {
        return Observable.fromCallable(new Callable<Void>() {
            @Nullable
            @Override
            public Void call() throws Exception {
                GsonFunctions.writeValue(gson, jsonElement, jsonWriter);
                return null;
            }
        });
    }

    public Observable<JsonWriter> write(final Writer writer) {
        return Observable.fromCallable(new Callable<JsonWriter>() {
            @Override
            public JsonWriter call() throws Exception {
                return GsonFunctions.newJsonWriter(gson, writer);
            }
        });
    }

    @Experimental
    public JsonObservable readJsonObservable(final String filePath) {
        final Observable<JsonReader> jsonReaderObservable = Observable.fromCallable(new Callable<JsonReader>() {
            @Override
            public JsonReader call() throws Exception {
                return GsonFunctions.readJson(filePath);
            }
        });

        return new JsonObservable(new Observable.OnSubscribe<JsonReader>() {
            @Override
            public void call(Subscriber<? super JsonReader> subscriber) {
                jsonReaderObservable.unsafeSubscribe(subscriber);
            }
        });
    }

    @Experimental
    public JsonObservable readJsonObservable(final InputStream inputStream) {
        final Observable<JsonReader> jsonReaderObservable = Observable.fromCallable(new Callable<JsonReader>() {
            @Override
            public JsonReader call() throws Exception {
                return GsonFunctions.readJson(inputStream);
            }
        });

        return new JsonObservable(new Observable.OnSubscribe<JsonReader>() {
            @Override
            public void call(Subscriber<? super JsonReader> subscriber) {
                jsonReaderObservable.unsafeSubscribe(subscriber);
            }
        });
    }

    @Experimental
    public JsonObservable readJsonObservable(final InputStream inputStream, final String encoding) {
        final Observable<JsonReader> jsonReaderObservable = Observable.fromCallable(new Callable<JsonReader>() {
            @Override
            public JsonReader call() throws Exception {
                return GsonFunctions.readJson(inputStream, encoding);
            }
        });

        return new JsonObservable(new Observable.OnSubscribe<JsonReader>() {
            @Override
            public void call(Subscriber<? super JsonReader> subscriber) {
                jsonReaderObservable.unsafeSubscribe(subscriber);
            }
        });
    }


}
