# Finnkino Movie Review Application

## Project Overview
This repository contains the codebase for a mobile application developed in Java using Android Studio. The application allows users to browse Finnkino's current movie selection, view detailed information about movies, create user profiles, and review movies. Users can also track their review history, enabling them to plan and reflect on their movie-going experiences.

## Features
### Core Features:
- Display Finnkino's current movie catalog using XML parsing.
- User authentication with login and registration functionality.
- Persistent user data storage using SQLite.
- User profiles that retain data, including movie reviews and history, even after closing the application.

### Additional Features:
- Search functionality to find movies by title or keywords.
- Age restriction filtering based on user profiles.
- Serialization for saving user profile data locally.
- Responsive UI design for various screen sizes.
- Singleton pattern for efficient data handling across components.

## Implementation
The application is built using the following technologies and patterns:
- **Language**: Java
- **Framework**: Android Studio
- **Libraries**: Picasso (`com.squareup.picasso:picasso:2.71828`) for loading images from URLs.
- **Database**: SQLite for persistent storage of user data and reviews.
- **Design Patterns**: Singleton for efficient data access and management.

### Key Components:
- **Movie View** (`MovieActivity`): Displays movie details and enables reviews.
- **User Authentication**: Handles user registration, login, and profile setup (`Register` and `SetupProfile` activities).
- **Review Management**: Allows users to rate and review movies, with a history view to track past reviews.
- **Finnkino Integration**: Parses XML data from Finnkino's API to display up-to-date movie information.

## Project Structure
- **Front-End**:
  - User interfaces for movie browsing, login, registration, and review history.
  - XML-based layouts designed for responsiveness.
- **Back-End**:
  - Data handling with SQLite and local serialization for offline persistence.
  - XML parsing for fetching movie data.
  - Profile management and review storage logic.

## Contributors
- **Jere Arokivi**:
  - Developed movie viewing, login, and registration functionalities.
  - Implemented SQLite database and user profile serialization.
- **Matti Aalto**:
  - Worked on history, reviews, and profile features.
  - Designed backend components for theater data handling.
- **Max Wesamaa**:
  - Focused on movie detail views and XML parsing.
  - Contributed to data storage and backend integration.

## Dependencies
- `com.squareup.picasso:picasso:2.71828` for loading and displaying images from URLs.

## Usage
1. Clone the repository and open it in Android Studio.
2. Build the project and run it on an emulator or physical device.
3. Use the application to:
   - Browse movies and view details.
   - Create a profile and log in.
   - Write and view movie reviews.
   - Plan future movie visits with the integrated movie catalog.

## Lessons Learned
The development process was a valuable learning experience in:
- **Android Development**: Gaining proficiency in Android Studio and Java.
- **UI/UX Design**: Creating responsive and intuitive interfaces.
- **Collaboration**: Working effectively in a team to deliver a functional and polished application.

## Future Improvements
- Enhance UI/UX with more advanced animations and theme customization.
- Implement cloud-based data storage for multi-device synchronization.
- Add social sharing features for reviews and movie recommendations.

---
