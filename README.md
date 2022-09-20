

Libraries Used

- Ktor
- Coroutines
- Kotlinx Serialization
- Coil
- Dagger Hilt
- Jetpack Compose
- Viewmodel

Architecture

 The domain layer logic for this app was minimal so I chose to use functions/extensions whereas in a larger, more complex app I would use classes and Interfaces.
 
 I put most of the application/Presentation logic in a "controller" class choosing to use viewmodel like a presenter just updating the ui.
