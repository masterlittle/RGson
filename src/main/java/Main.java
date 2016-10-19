import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import models.Entity;
import rx.Observable;
import rx.Subscriber;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by Shitij on 18/10/16.
 */
public class Main {

    public static void main(String args[]) {
        example1();
        example2();
    }

    private static void example1() {
        try {
            Reader reader = new InputStreamReader(new FileInputStream("src/main/resources/entity.json"));
            final JsonReader jsonReader = new JsonReader(reader);
            Type type = new TypeToken<Collection<Entity>>(){}.getType();

             Observable<Collection<Entity>> collectionObservable= RGson.create().read(jsonReader, type);
            collectionObservable.subscribe(new Subscriber<Collection<Entity>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Collection<Entity> entities) {
                    System.out.println(entities.size());
                }
            });


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void example2() {
        try {
            Reader reader = new InputStreamReader(new FileInputStream("src/main/resources/entity2.json"));

            RGson.create()
                    .read(reader, Entity.class)
                    .subscribe(new Subscriber<Entity>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Entity entity) {
                            System.out.println(entity.toString());
                        }
                    });


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
