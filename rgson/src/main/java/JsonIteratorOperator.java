import com.google.gson.stream.JsonReader;

import rx.Observable;
import rx.Subscriber;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;

/**
 * Created by Shitij on 30/07/16.
 */
@Experimental
public class JsonIteratorOperator implements Observable.Operator<JsonReader, JsonReader>{
    final Func1<JsonReader, JsonReader> func1;

    JsonIteratorOperator(Func1<JsonReader, JsonReader> func1) {
        this.func1 = func1;
    }

    public Subscriber<? super JsonReader> call(final Subscriber<? super JsonReader> subscriber) {

        return new Subscriber<JsonReader>(subscriber) {
            @Override
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                subscriber.onError(e);
            }

            @Override
            public void onNext(JsonReader jsonReader) {
                try {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        func1.call(jsonReader);
                        subscriber.onNext(jsonReader);
                    }
                    jsonReader.endObject();
                    onCompleted();
                } catch (Throwable e) {
                    Exceptions.throwIfFatal(e);
                    onError(OnErrorThrowable.addValueAsLastCause(e, jsonReader.toString()));
                }
            }
        };
    }
}
