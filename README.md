# Locations

### About the project
This app is integrated from Foursquare Locations API (https://foursquare.com/). Users able to see top 10 locations around 10000 Meter radius around Minneapolis with details.


### Tools Used

The app is build with  **Kotlin** It supports from Android Sdk 21.


### Architecture

The app uses **Clean Architecture** to have a unidirectional flow of data, separation of concern, testability, readable and maintainable.
-   Separate layers: Data, Domain and Presentation
-   MVVM architecture for clean separation

### Libraries and tools
The Locations app uses below libraries and tools to build efficient application

- [Kotlin](https://kotlinlang.org/)
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) 
- [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) for data stream
- Architecture components (**Navigation, LiveData, ViewModel, Data Binding etc.**)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)  for dependency injection
- [Retrofit](https://square.github.io/retrofit/)
- [Coil](https://github.com/coil-kt/coil) for image loading
- [Mockito](https://site.mockito.org/) for unit testing