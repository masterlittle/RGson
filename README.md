# RGson [![](https://www.jitpack.io/v/masterlittle/RGson.svg)](https://www.jitpack.io/#masterlittle/RGson)
A reactive wrapper over Gson library

## Usage

Create a Rgson instance which wraps over a Gson instance.
```
Rgson rgson = Rgson.create();
```
Call a method as you would call it in gson using simple read() and write() functions but now work with the power of Rx!
```
rgson.read("{\"data\":\"x\"}", Test.class).subscribe(subscriber);
rgson.write(InputStream).subscribe();
```

There is an operator provided in case you want to stream the json. It accepts the source JsonReader and emits a JsonReader with the relevant key-value pair depending upon how it is handled by the user.
_**This is an experimental feature so I would encourage people to try it out and give feedback.**_
```
Observable<String> ob = rgson.readJsonObservable(JsonReader)
     .iterate(new Func1<JsonReader, String> (){
         @Override
         public String call(JsonReader jsonReader) {
             String name = jsonReader.nextName();
             jsonReader.skipValue();
             return name;
     })
     .subscribe();
```

For more code samples refer to the test cases and src folder which contains some basic examples.

## Download
Add it in your root build.gradle
```
allprojects {
    repositories {
        maven { url "https://www.jitpack.io" }
        }
    }
```
Add the dependency
```
dependencies {
    compile 'com.github.masterlittle:RGson:1.0.0'
}
```

## License
MIT License 2.0




