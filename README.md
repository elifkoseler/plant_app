# 🌿 PlantApp

**PlantApp** is a modern Android application designed to help users discover plant-related content. The app includes an intuitive onboarding experience, a paywall screen with subscription options, and a home page that showcases informative plant articles.

---

## 🧠 Architecture

This project follows **Clean Architecture** and the **MVVM (Model-View-ViewModel)** design pattern to ensure a modular, testable, and scalable codebase.

---

- Presentation Layer: Fragments, ViewModels, LiveData, UI logic
- Domain Layer: UseCases and Repository Interfaces
- Data Layer: Room (local) and Retrofit (remote) data sources and Repository implementations.

---

## 🧱 Tech Stack & Libraries

- **Kotlin** – The primary language of development  
- **MVVM + Clean Architecture** – Clear separation of concerns and better testability  
- **Hilt** – Dependency injection framework for managing application-level and scoped dependencies  
- **Jetpack Navigation** – Handles in-app navigation and fragment transactions  
- **Room** – For local database and offline support  
- **Retrofit + Gson** – For API communication and JSON parsing  
- **Coroutines + ViewModelScope** – For asynchronous and lifecycle-aware background operations  
- **LiveData** – For reactive UI updates  
- **Glide** – For efficient image loading and caching  
- **FragmentContainerView** – Single-activity architecture with NavHostFragment
- **Git + GitHub** – Actively used GitHub for version control with a clean Git workflow. Developed features in isolated feature branches, used pull requests (PRs) to track progress and maintain code quality.

---

## ⏱ Time Constraints & Effort
Due to time limitations, I wasn’t able to fully complete or polish all parts of the app. However, I focused on building a **solid architectural foundation** and demonstrating my knowledge of modern Android development practices, including Clean Architecture and dependency injection.

A significant portion of my time was spent dealing with **Hilt setup** and **Gradle-related configuration challenges**, which were particularly time-consuming.

This project reflects my understanding of these modern technologies and architectural patterns. I’ve also included a short 
**demo video** (PlantApp Demo.mp4) to showcase the current state of the app.
The goal was not perfection under the time pressure, but to show my **hands-on capabilities and technical growth** in building scalable Android applications.

