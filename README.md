# Android Coding Challenge

Android Coding Challenge is application showcasing the Launches listing, Launches detail and add launches into favorite.

The main purpose of this application is to show how to build a clean and multi-module application by using the MVVM clean architecture in Jetpack compose. To achieve the quality application i implement:
* Jetpack compose (for Building UI)
* Koin (for dependency injection)
* Coroutines (for async API calling)
* MVVM clean architecture
* Retrofit (for async API calling)
* Room (to save favorite items in local DB)
* Coil (For image loading)
* Navigation (To navigate the screens)
* jUnit (for testing)
* Mockito (for testing)

### Application:
In this application we shows the list of SpaceX Launches, User can also see the details of any launches like Rocket id, description flight number etc. In the detail screen there is a Favorite button to add any launches into favorite list in local database to see them later. 
This application is tested by writting the Unit test cases of required modules and classes by using the jUnit and Mockito.

### Development Approach:

* Re-usability
* Scalability
* Single responsibility
* Interface
* Testability

### Architecture:

The app uses MVVM clean architecture to have a unidirectional flow of data, separation of concern, testability, and a lot more.
* App (Contains the application)
* Common (Contains the base things)
* Domain (Contains the repository and data and usesCases)
* Features (Contains Features)
* Every feature has it's own API, Domain and presentation module 
* API (Contains the APIs)
* Domain(Contains the repo and data)
* Presentation (Contains the UI and viewModels)

### User Interface:
Application UI is design using Jetpack Compose
Application have a two screen that is regarded as feature i.e. Launches List and Launches Detail

* Loading State. Displaying loader when screen is launched and network call is on the ongoing to fetch the data.
* Error State. Display snackbar if any error happen with retry button.
* Launches List Loaded. Display List of Launches contains the ID and image of launches.
* Launches Details Screen. It opens when user click on any launch and show the complete detail of the launches with a Favorite button.


