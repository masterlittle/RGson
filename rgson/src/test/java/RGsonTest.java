import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import models.Data;
import models.Entity;
import models.Friend;
import org.jetbrains.annotations.NotNull;
import org.junit.*;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.TestSubscriber;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * Created by Shitij on 18/10/16.
 */
@RunWith(JUnit4ClassRunner.class)
public class RGsonTest {

    private RGson rGson;
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private JsonReader jsonReader;
    private Reader reader;
    private String fullJsonOutput;
    private FileInputStream inputStream;
    private final String filePath = "src/test/java/entity2.json";

    @Before
    public void init() throws IOException {
        rGson = RGson.create();
        inputStream = new FileInputStream(filePath);
        reader = new InputStreamReader(inputStream);
        jsonReader = new JsonReader(reader);
        fullJsonOutput = "{\"_id\":\"5805e3ffef2597651f5f1807\",\"index\":0,\"guid\":\"a7a024c9-4ef2-4395-9274-d0313c5dcde4\",\"isActive\":true,\"picture\":\"http://placehold.it/32x32\",\"age\":34,\"eyeColor\":\"green\",\"name\":\"Maxine Campbell\",\"gender\":\"female\",\"company\":\"ASSISTIX\",\"email\":\"maxinecampbell@assistix.com\",\"phone\":\"\",\"address\":\"116 Cheever Place, Kula, Arizona, 578\",\"about\":\"Excepteur excepteur culpa non dolor in id. Sint velit sit tempor dolor occaecat laboris ut. Quis eiusmod mollit ea mollit magna id non. Voluptate cillum fugiat culpa nulla ut qui. Qui aute Lorem consectetur adipisicing.\\r\\n\",\"registered\":\"2014-11-24T04:33:26 -06:-30\",\"latitude\":63.159189,\"longitude\":-81.304678,\"tags\":[\"eiusmod\",\"velit\",\"quis\",\"sunt\",\"magna\",\"excepteur\",\"et\"],\"friends\":[{\"id\":0,\"name\":\"Freida Guthrie\"},{\"id\":1,\"name\":\"Morales Daugherty\"},{\"id\":2,\"name\":\"Acevedo Hart\"}],\"greeting\":\"Hello, Maxine Campbell! You have 8 unread messages.\",\"favoriteFruit\":\"strawberry\"}";
    }

    @Test
    public void read_String_Class() throws Exception {

        final String json = "{ \"data\" : \"test\"}";

        TestSubscriber<Data> testSubscriber = new TestSubscriber<Data>();
        Observable<Data> observable = rGson.read(json, Data.class);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Data> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("test", list.get(0).getData());

    }

    @Test
    public void read1_JsonReader_Class() throws Exception {

        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();
        Observable<Entity> observable = rGson.read(jsonReader, Entity.class);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("female", list.get(0).getGender());
        Assert.assertEquals(0, list.get(0).getIndex());
        Assert.assertEquals(34, list.get(0).getAge());
        Assert.assertEquals("strawberry", list.get(0).getFavoriteFruit());
        Assert.assertEquals("green", list.get(0).getEyeColor());
        Assert.assertEquals(null, list.get(0).getBalance());
        Assert.assertEquals("", list.get(0).getPhone());
    }

    @Test
    public void read2_Reader_Class() throws Exception {
        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();
        Observable<Entity> observable = rGson.read(reader, Entity.class);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("female", list.get(0).getGender());
        Assert.assertEquals(0, list.get(0).getIndex());
        Assert.assertEquals(34, list.get(0).getAge());
        Assert.assertEquals("strawberry", list.get(0).getFavoriteFruit());
        Assert.assertEquals("green", list.get(0).getEyeColor());
        Assert.assertEquals(null, list.get(0).getBalance());
        Assert.assertEquals("", list.get(0).getPhone());
    }

    @Test
    public void read3_Reader_Type() throws Exception {
        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();
        Type type = new TypeToken<Entity>() {
        }.getType();
        Observable<Entity> observable = rGson.read(reader, type);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("female", list.get(0).getGender());
        Assert.assertEquals(0, list.get(0).getIndex());
        Assert.assertEquals(34, list.get(0).getAge());
        Assert.assertEquals("strawberry", list.get(0).getFavoriteFruit());
        Assert.assertEquals("green", list.get(0).getEyeColor());
        Assert.assertEquals(null, list.get(0).getBalance());
        Assert.assertEquals("", list.get(0).getPhone());
    }

    @Test
    public void read4_JsonReader_Type() throws Exception {
        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();
        Type type = new TypeToken<Entity>() {
        }.getType();
        Observable<Entity> observable = rGson.read(jsonReader, type);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("female", list.get(0).getGender());
        Assert.assertEquals(0, list.get(0).getIndex());
        Assert.assertEquals(34, list.get(0).getAge());
        Assert.assertEquals("strawberry", list.get(0).getFavoriteFruit());
        Assert.assertEquals("green", list.get(0).getEyeColor());
        Assert.assertEquals(null, list.get(0).getBalance());
        Assert.assertEquals("", list.get(0).getPhone());
    }

    @Test
    public void read5_String_Type() throws Exception {
        final String json = "{ \"data\" : \"test\"}";

        TestSubscriber<Data> testSubscriber = new TestSubscriber<Data>();
        Type type = new TypeToken<Data>() {
        }.getType();
        Observable<Data> observable = rGson.read(json, type);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Data> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("test", list.get(0).getData());
    }

    @Test
    public void read6_JsonElement_Present_Class() throws Exception {
        final JsonElement jsonElement = new Gson().fromJson(jsonReader, JsonElement.class);

        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();

        Observable<Entity> observable = rGson.read(jsonElement, Entity.class);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("female", list.get(0).getGender());
        Assert.assertEquals(0, list.get(0).getIndex());
        Assert.assertEquals(34, list.get(0).getAge());
        Assert.assertEquals("strawberry", list.get(0).getFavoriteFruit());
        Assert.assertEquals("green", list.get(0).getEyeColor());
        Assert.assertEquals(null, list.get(0).getBalance());
        Assert.assertEquals("", list.get(0).getPhone());
    }

    @Test
    public void read7_JsonElement_Null_Class() throws Exception {
        final JsonElement jsonElement = null;

        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();

        Observable<Entity> observable = rGson.read(jsonElement, Entity.class);
        observable.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals(null, list.get(0));

    }

    @Test
    public void read8_JsonElement_Present_Type() throws Exception {
        final JsonElement jsonElement = new Gson().fromJson(jsonReader, JsonElement.class);

        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();
        Type type = new TypeToken<Entity>() {
        }.getType();
        Observable<Entity> observable = rGson.read(jsonElement, type);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals("female", list.get(0).getGender());
        Assert.assertEquals(0, list.get(0).getIndex());
        Assert.assertEquals(34, list.get(0).getAge());
        Assert.assertEquals("strawberry", list.get(0).getFavoriteFruit());
        Assert.assertEquals("green", list.get(0).getEyeColor());
        Assert.assertEquals(null, list.get(0).getBalance());
        Assert.assertEquals("", list.get(0).getPhone());
    }

    @Test
    public void read9_JsonElement_Null_Type() throws Exception {
        final JsonElement jsonElement = null;

        TestSubscriber<Entity> testSubscriber = new TestSubscriber<Entity>();
        Type type = new TypeToken<Entity>() {
        }.getType();

        Observable<Entity> observable = rGson.read(jsonElement, type);
        observable.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<Entity> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals(null, list.get(0));

    }

    @Test
    public void write_String_Class() throws Exception {
        Friend friend = getFriend();

        String output = getSmallJsonString();

        TestSubscriber<String> testSubscriber = new TestSubscriber<String>();
        Observable<String> observable = rGson.write(friend);
        observable.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<String> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals(output, list.get(0));
    }

    @NotNull
    private String getSmallJsonString() {
        return "{\"id\":123,\"name\":\"Shitij\"}";
    }

    @Test
    public void write1_String_Type() throws Exception {
        Friend friend = getFriend();

        String output = getSmallJsonString();

        TestSubscriber<String> testSubscriber = new TestSubscriber<String>();
        Type type = new TypeToken<Friend>() {
        }.getType();
        Observable<String> observable = rGson.write(friend, type);
        observable.subscribe(testSubscriber);
        testSubscriber.assertNoErrors();

        List<String> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals(output, list.get(0));
    }

    @NotNull
    private Friend getFriend() {
        Friend friend = new Friend();
        friend.setId(123);
        friend.setName("Shitij");
        return friend;
    }

    @Test
    public void write2_JsonElement() throws Exception {
        final JsonElement jsonElement = new Gson().fromJson(jsonReader, JsonElement.class);

        TestSubscriber<String> testSubscriber = new TestSubscriber<String>();
        Observable<String> observable = rGson.write(jsonElement);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<String> list = testSubscriber.getOnNextEvents();
        Assert.assertEquals(list.get(0), fullJsonOutput);
    }

    @Test
    public void write3_JsonElement_AppendableWriter() throws Exception {

        Writer writer = new StringWriter();
        final JsonElement jsonElement = new Gson().fromJson(jsonReader, JsonElement.class);

        TestSubscriber<Void> testSubscriber = new TestSubscriber<Void>();
        Observable<Void> observable = rGson.write(jsonElement, writer);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(writer.toString(), fullJsonOutput);
    }

    @Test
    public void write4_JsonElement_Type_Writer() throws Exception {
        Writer writer = new StringWriter();
        final JsonElement jsonElement = new Gson().fromJson(jsonReader, JsonElement.class);
        Type type = new TypeToken<JsonObject>() {
        }.getType();

        TestSubscriber<Void> testSubscriber = new TestSubscriber<Void>();
        Observable<Void> observable = rGson.write(jsonElement, type, writer);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(writer.toString(), fullJsonOutput);
    }

    @Test
    public void write5_JsonElement_JsonWriter() throws Exception {
        Writer writer = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(writer);
        final JsonElement jsonElement = new Gson().fromJson(jsonReader, JsonElement.class);

        TestSubscriber<Void> testSubscriber = new TestSubscriber<Void>();
        Observable<Void> observable = rGson.write(jsonElement, jsonWriter);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(writer.toString(), fullJsonOutput);
    }

    @Test
    public void write6_Object_Writer() throws Exception {
        Writer writer = new StringWriter();
        Friend friend = getFriend();
        String output = getSmallJsonString();

        TestSubscriber<Void> testSubscriber = new TestSubscriber<Void>();
        Observable<Void> observable = rGson.write(friend, writer);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(writer.toString(), output);
    }

    @Test
    public void write7_JsonElement_Type_JsonWriter() throws Exception {
        Writer writer = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(writer);
        final JsonElement jsonElement = new Gson().fromJson(jsonReader, JsonElement.class);
        Type type = new TypeToken<JsonObject>() {
        }.getType();

        TestSubscriber<Void> testSubscriber = new TestSubscriber<Void>();
        Observable<Void> observable = rGson.write(jsonElement, type, jsonWriter);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(writer.toString(), fullJsonOutput);
    }

    @Test
    public void write8_Object_Type_Writer() throws Exception {
        Writer writer = new StringWriter();
        Friend friend = getFriend();
        String output = getSmallJsonString();
        Type type = new TypeToken<Friend>() {
        }.getType();

        TestSubscriber<Void> testSubscriber = new TestSubscriber<Void>();
        Observable<Void> observable = rGson.write(friend, type, writer);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(writer.toString(), output);
    }

    @Test
    public void write9_Object_Type_JsonWriter() throws Exception {
        Writer writer = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(writer);

        Friend friend = getFriend();
        String output = getSmallJsonString();
        Type type = new TypeToken<Friend>() {
        }.getType();

        TestSubscriber<Void> testSubscriber = new TestSubscriber<Void>();
        Observable<Void> observable = rGson.write(friend, type, jsonWriter);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(writer.toString(), output);
    }

    @Test
    public void write10_JsonWriter() throws Exception {
        Writer writer = new StringWriter();

        TestSubscriber<JsonWriter> testSubscriber = new TestSubscriber<JsonWriter>();
        Observable<JsonWriter> observable = rGson.write(writer);
        observable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        List<JsonWriter> jsonWriterList = testSubscriber.getOnNextEvents();

        Assert.assertThat(jsonWriterList.get(0), instanceOf(JsonWriter.class));
    }

    @Test
    public void readJsonObservable() throws Exception {
        TestSubscriber<JsonReader> testSubscriber = new TestSubscriber<JsonReader>();

        Observable<JsonReader> jsonReaderObservable = rGson.readJsonObservable(inputStream)
                .iterate(new Func1<JsonReader, JsonReader>() {
                    @Override
                    public JsonReader call(JsonReader jsonReader) {
                        try {
                            jsonReader.skipValue();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return jsonReader;
                    }
                });
        jsonReaderObservable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        int count = testSubscriber.getValueCount();
        Assert.assertEquals(count, 44);

    }

    @Test
    public void readJsonObservable1_Encoding() throws Exception {
        TestSubscriber<JsonReader> testSubscriber = new TestSubscriber<JsonReader>();
        String encoding = "UTF-8";

        Observable<JsonReader> jsonReaderObservable = rGson.readJsonObservable(inputStream, encoding)
                .iterate(new Func1<JsonReader, JsonReader>() {
                    @Override
                    public JsonReader call(JsonReader jsonReader) {
                        try {
                            jsonReader.skipValue();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return jsonReader;
                    }
                });
        jsonReaderObservable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        int count = testSubscriber.getValueCount();
        Assert.assertEquals(count, 44);
    }

    @Test
    public void readJsonObservable2_Filepath() throws Exception {
        TestSubscriber<JsonReader> testSubscriber = new TestSubscriber<JsonReader>();

        Observable<JsonReader> jsonReaderObservable = rGson.readJsonObservable(filePath)
                .iterate(new Func1<JsonReader, JsonReader>() {
                    @Override
                    public JsonReader call(JsonReader jsonReader) {
                        try {
                            jsonReader.skipValue();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return jsonReader;
                    }
                });
        jsonReaderObservable.subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        int count = testSubscriber.getValueCount();
        Assert.assertEquals(count, 44);
    }

    @After
    public void finish(){
        try {
            reader.close();
            jsonReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}