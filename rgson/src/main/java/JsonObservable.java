import com.google.gson.stream.JsonReader;

import rx.Observable;
import rx.Subscriber;
import rx.annotations.Experimental;
import rx.functions.Func1;

/**
 * Created by Shitij on 30/07/16.
 */
@Experimental
public class JsonObservable extends Observable<JsonReader> {
    /**
     * Creates an Observable with a Function to execute when it is subscribed to.
     * <p>
     * <em>Note:</em> Use {@link #create(OnSubscribe)} to create an Observable, instead of this
     * constructor,
     * unless you specifically have a need for inheritance.
     *
     * @param f {@link OnSubscribe} to be executed when {@link #subscribe(Subscriber)} is called
     */
    protected JsonObservable(OnSubscribe<JsonReader> f) {
        super(f);
    }

    /**
     * Iterate observable.
     *
     * @param mapper the mapper
     *
     * @return the observable
     */
    @Experimental
    public final <R> Observable<R> iterate(Func1<JsonReader, R> mapper) {
        return lift(iterateOverJson(mapper));
    }

    private static <R> Observable.Operator<R, JsonReader> iterateOverJson(Func1<JsonReader, R> mapper) {
        return new JsonIteratorOperator<R>(mapper);
    }
}
