# Academics-Management-System
## Overview
This project is a **University Management System** for **IIIT Kottayam** that helps manage different users within the university. It provides an interactive console-based system where different types of users can log in and perform tasks.

## Features
- **Admin User**: Handles administrative functions.
- **Academics User**: Manages academic-related activities.
- **Faculty User**: Allows faculty members to access relevant information.
- **Student User**: Provides students with access to university-related functionalities.

## How It Works
1. When the program runs, it displays a **welcome message** for IIIT Kottayam.
2. Users can select their role from the menu:
   - `1` for Admin
   - `2` for Academics
   - `3` for Faculty
   - `4` for Student
   - `0` to Exit
3. Based on the user selection, the corresponding class is initialized.
4. The selected user can then perform role-specific operations.

## Project Structure
- `University.java`: Defines the main interface for the university.
- `UniversityApp.java`: The main application that manages user interactions.
- `AdminApp`, `AcademicsApp`, `FacultyApp`, `StudentApp`: Handle functionalities for different users.

## How to Run
1. Compile the Java files using:
    ```sh
   javac -d . University.java UniversityApp.java
2. Run the application.
 ```sh
   java com.iiitk.UniversityApp

