

Libraries Used

- Ktor
- Coroutines
- Kotlinx Serialization
- Coil
- Dagger Hilt
- Jetpack Compose
- Viewmodel



 The domain layer logic for this app was minimal so I chose to use functions/extensions whereas in a larger, more complex app I would use classes and Interfaces. Generally I like to use very few libraries and platform specific code in my business logic to make them easier to test with unit tests. I also like to break my logic down into smaller functions to allow each part to be tested then use interfaces to make it easier only use the needed overall function in other classes/places.  
 
 I put most of the application/Presentation logic in a "controller" class choosing to use viewmodel like a presenter just updating the ui. This pattern also works well on multiplatform apps for me as it means more code can be shared. However I have 1O:O?>@-='!^¬\&\?"
 
 As the whole app is based on and timhtly coupled to the CatApi I used the same models throughout.
 
 In a larger app I would have liked to limit the parmaters that can be passed to the api based on it's stated limits (e.g limit has a min of 0 and a max of 100),
 possibly using inline/value classes and delegates for those fields in the ImageSearchParameters class

It is possible to filter by type but currently filtering by png doesn't work because it appears the data returned has no categories field so special handling is needed for this.

I used a custom Result class to implement "Railway Oriented Programming" and used Sealed classes to describe states to better handle all eventualites e.g the aforementioned png issue.
