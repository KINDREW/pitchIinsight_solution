# PitchInsight Interview Solution

## Overview

This project aims to build a simple webpage for sorting integers. The frontend is developed using Vue.js, the backend is powered by Spring Boot, and MySQL is used as the database.

## Features

1. **User Input:**

   - Users can input integers using the provided input box.
   - A "Save" button is available to submit the input number to the backend.

2. **Display Numbers:**
   - Clicking the "Display Numbers" button shows the previously stored numbers sorted in ascending order.
   - Pagination is implemented to enhance readability for a large number of integers.

## Project Structure

### Backend and Frontend

- Both the backend (Spring Boot) and frontend (Vue.js) are contained in the same directory.

### Backend (Spring Boot)

- **Endpoint:**
  - `/userinput`: Handles saving and retrieving integers.

### Frontend (Vue.js)

- **Components:**
  - `InputForm.vue`: Manages user input and saving numbers.

## Getting Started

1. **Setup Database:**

   - Create a MySQL database and update the database configuration in the Spring Boot application properties.

2. **Run Backend:**

   - Navigate to the project directory.
   - Execute the Spring Boot application: `java -jar pitchinsight.jar`.

3. **Run Frontend:**

   - Navigate to the project directory.
   - Install dependencies: `npm install`.
   - Run the Vue.js application: `npm run serve`.

4. **Access the Webpage:**
   - Open the provided URL after running the Vue.js application in your browser.

## Technologies Used

- **Frontend:**

  - Vue.js

- **Backend:**

  - Spring Boot

- **Database:**
  - MySQL
