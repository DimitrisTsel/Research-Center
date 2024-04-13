
markdown
Copy code
# Research Center Desktop App

## Overview
This project was an application implemented for the purpose of the course: **Relational Databases** during my **MSc in Advanced Information Systems**.
This Java desktop application, implemented with Swing for the user interface (UI) and MySQL database for data storage, is designed to serve as a management 
tool for a research center. It provides functionalities for visitors to retrieve announcements, members, the labs of the Research Center, the classes, and the publications.
Also, only admins have rights to insert, update, and delete data.

## Features
- **User Interface with Swing**: Utilizes the Swing framework to create a user-friendly interface for interacting with the application.
- **MySQL Database Integration**: Integrates with a MySQL database to store and manage research-related data efficiently.
- **Data Management**: Provides functionalities for adding, editing, deleting, and searching research projects, researchers, publications, funding sources, etc.
- **Reporting**: Generates reports and analytics based on research data, providing insights into the center's activities and performance.
- **Authentication and Authorization**: Implements user authentication and authorization to ensure secure access to the application's functionalities.
- **Data Validation**: Enforces data validation rules to ensure data integrity and accuracy.
- **Export and Import**: Allows exporting and importing data to and from external sources for backup or sharing purposes.

## Installation
1. Clone the repository: `git clone https://github.com/DimitrisTsel/research-center-desktop-app.git`
2. Set up MySQL database:
- Install MySQL and create a new database for the application.
- Update the database connection settings in the Java code.

## Usage
1. Open the project in your preferred Java IDE.
2. Compile and run the `MainMenu.java` file to launch the application.
3. Use the provided functionalities to manage research-related data.
