<h1>News Reader App</h1>

<h2>Project Overview</h2>
The News Reader App is a simple Android application built using Jetpack Compose. It allows users to browse news headlines and view detailed news articles. The app supports both light and dark themes and includes navigation between different screens. The project is designed to demonstrate modern Android development practices, including the use of Jetpack Compose, navigation components, and material design principles.<br>

<h2>Features Implemented</h2>
- News Headlines Screen: Displays a list of news articles with titles, dates, and images.<br>
- News Details Screen: Shows detailed information about a selected news article.<br>
- Theme Toggle: Allows users to switch between light and dark themes.<br>
- Navigation: Supports navigation between the headlines screen and the details screen.<br>
- Localization: Supports both English and Arabic languages.<br>

<h2>Project Structure</h2>
The project is structured as follows:<br>
- MainActivity.kt: The entry point of the application, where the navigation and theme setup are handled.<br>
- MainScreen.kt: Contains the composable function for the news headlines screen.<br>
- SecondScreen.kt: Contains the composable function for the news details screen.<br>
- NewsItem.kt: Defines the composable function for displaying individual news items.<br>
- UiText.kt: A sealed class for handling string resources and localization.<br>
- NewsObject.kt: A data class representing a news article.<br>
- strings.xml: Contains string resources for both English and Arabic languages.<br>

<h2>Screenshots</h2>

<h3>Dark Arabic Main Screen</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/a49d5465-1001-41a7-8c5f-0efdba1702ed" />
<br>

<h3>Light English Main Screen</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/669bdb08-b004-4b1a-8b73-d39c34e960c6" />
<br>

<h3>Dark English News Details Screen</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/78cf0150-4b8f-4ab1-9168-bcd40fe1500e" />
<br>

<h3>Light Arabic News Details Screen</h3>
<img width="180" alt="Image" src="https://github.com/user-attachments/assets/a9f876c7-f144-4e7a-9e7b-99b7032fc857" />

<h2>Technologies Used</h2>
- Jetpack Compose: For building the UI components.<br>
- Navigation Component: For handling navigation between screens.<br>
- Material Design: For implementing material design components and themes.<br>
- Kotlin: The primary programming language used for development.<br>
- Android Studio: The official IDE for Android development.<br>

<h2>Setup Instructions</h2>
1- Clone the Repository: Clone the project repository to your local machine.<br>
git clone https://github.com/yourusername/news-reader-app.git<br>
2- Open in Android Studio: Open the project in Android Studio.<br>
3- Build and Run: Build the project and run it on an Android emulator or a physical device.<br>

<h2>How to Contribute</h2>
1- Fork the Repository: Fork the repository to your GitHub account.<br>
2- Create a Branch: Create a new branch for your feature or bug fix.<br>
git checkout -b feature/your-feature-name<br>
3- Make Changes: Make your changes and commit them with a descriptive commit message.<br>
git commit -m "Add your commit message here"<br>
4- Push Changes: Push your changes to your forked repository.<br>
git push origin feature/your-feature-name<br>
5- Create a Pull Request: Open a pull request from your branch to the main repository. Provide a detailed description of your changes.<br>




