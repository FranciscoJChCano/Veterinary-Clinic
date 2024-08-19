## Patient Management System

### Project Description
This project aims to develop a patient management system in Java. Margarita, the primary user, will be able to list, add, edit, and delete patients through the application. Additionally, the application will allow users to efficiently manage appointments, including scheduling, viewing a list of appointments, modifying, and canceling appointments, while maintaining an organized and accessible record of them.

### Main Features
Patient Management
List Patients: View a list of all registered patients.
Add Patients: Add new patients to the system.
Edit Patients: Edit existing patient information.
Delete Patients: Remove a patient from the system.
Each patient will have a profile that includes:

Name
Age
Race
Gender
Identification number
Guardian's full name
Guardian's phone number
Appointment Management
List Appointments: View all scheduled appointments.
Add Appointments: Schedule new appointments for patients.
Edit Appointments: Change the details of an existing appointment.
Delete Appointments: Cancel a scheduled appointment.
Each appointment will include:

Date and time
Patient
Type of consultation (standard or urgent)
Reason for the appointment
Appointment status (pending, completed)

### Functional Requirements
Access to Patient Data: The system must allow access to a patient's information using their identification number.
Treatment Records: The application must provide access to the treatments performed on each patient.
Additional Features 
Patient Profile Image: Ability to add an image to each patient’s profile.
DTOs (Data Transfer Objects): Implement DTOs for better data transfer between layers of the application.
Dockerization: Containerize the application using Docker to facilitate deployment.

### Technical Requirements
Java Knowledge: The development of the application will be done in the Java programming language.
Object-Oriented Programming (OOP): The system design will follow OOP principles to ensure maintainable and scalable code.
Best Practices: Best programming practices will be adopted to ensure code quality, including the use of design patterns, SOLID principles, and proper dependency management.
Testing: Implementation of unit and integration tests to ensure the functionality and stability of the system.

API Endpoints
Patients
Add a Patient

POST http://localhost:8080/api/patients
Update a Patient

PUT http://localhost:8080/api/patients/${id}
Delete a Patient

DELETE http://localhost:8080/api/patients/${id}
Get All Patients

GET http://localhost:8080/api/patients
Appointments
Get All Appointments for a Patient

GET http://localhost:8080/appointments/${patientId}
Get a Specific Appointment

GET http://localhost:8080/appointments/appointment/${patientId}
Add an Appointment

POST http://localhost:8080/appointments
Update an Appointment

PUT http://localhost:8080/appointments/${id}
Delete an Appointment

DELETE http://localhost:8080/appointments/${id}
