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
public class JsonIteratorOperator<R> implements Observable.Operator<R, JsonReader>{
    final Func1<JsonReader, R> func1;

    JsonIteratorOperator(Func1<JsonReader, R> func1) {
        this.func1 = func1;
    }

    public Subscriber<? super JsonReader> call(final Subscriber<? super R> subscriber) {

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
                        R r = func1.call(jsonReader);
                        subscriber.onNext(r);
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
