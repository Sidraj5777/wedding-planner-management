# wedding-planner-management

# wedding-planner-management

cliet url and request bodys

1. to create new client :- (POST) http://localhost:8080/clients 

body :- {
  "name": "sid raj",
  "budget": 90000,
  "contactNumber": "8218387777",
   "weddingDate": "2025-07-15",
  "events": [
    {
      "name": "Wedding Ceremony",
      "eventDate": "2024-01-15",
      "status": "UPCOMING",
      "totalCost":25000.0
    }
  ],
  "payments": [
    {
      "status": "PENDING",
      "paymentDate": "2023-12-01"
    }
  ]
}


2. to get all the clients :- (GET) http://localhost:8080/clients

3. to get client by Id :- (GET) http://localhost:8080/clients/3

4. to add new events :- (POST) http://localhost:8080/events

body :- {
    "name": "Wedding new Ceremony",
    "eventDate": "2025-07-30",
    "status": "UPCOMING",
    "totalCost": 1500.0,
    "clientId": 3
}


5. to retrive specific detals of events by id :- (GET) http://localhost:8080/events/4

6. to get List all events, including filtering by upcoming or completed status :- (GET) http://localhost:8080/events?status=UPCOMING

7.to Register a new vendor :- (POST) http://localhost:8080/vendors

body :- {
  "name": "nik son",
  "serviceType": "lightman",
  "available": false
}

8. to Update the availability status of a vendor :- (PUT) http://localhost:8080/vendors/1/updateAvailability?available=true

body :- {
  "name": "nik son",
  "serviceType": "lightman",
  "available": false
}



Wedding Planner Management System
Objective: Build a backend system that manages wedding planning services. This
system will track client information, manage event bookings, assign vendors, handle
payments, and generate reports.
Expectation:
•
•
•
•
•
•
•
Develop Spring boot application with Rest APIs and DB integration
Write Junit test case
best coding practices
should follow OOPS and SOLID principles
proper naming conventions
use design patterns , where ever possible
optimized code.
Task 1: Backend Service Development
Create a RESTful API service using Java and Spring Boot for a "Wedding Planner
Management System" with the following requirements:
1. API Endpoints:
o /clients: Register a new client and their wedding details.
o /clients/{id}: Retrieve details of a specific client.
o /clients: List all clients, with options to filter by wedding date or budget
range.
o /events: Add an event for a specific client.
o /events/{id}: Retrieve details of a specific event.
o /events: List all events, including filtering by upcoming or completed
status.
o /vendors: Register a new vendor.
o /vendors/{id}/updateAvailability: Update the availability status of a
vendor.o /bookings: Book a vendor for a specific event, checking the vendor's
availability.
o /bookings/{id}/cancel: Cancel a vendor booking.
o /payments: Record a payment for a client.
o /payments: List all payments, with filters for pending or completed
status.
2. Additional Requirements:
o Event Date Validation: Ensure events cannot be scheduled in the past.
o Budget Check: Validate that a client’s budget is not exceeded by their
booked services.
o Vendor Availability: Only allow bookings for vendors who are available on
the specified event date.
Task 2: Unit and Integration Testing using Junit
Task 3: Implementation
Problem: Available Vendor Lookup
Implement a method to retrieve a list of vendors who provide a specified service type
and are available on the given date.
Bonus Task (Optional): Monthly Summary Report
Feature: Implement a function generateMonthlyReport() that generates a summary
report for the previous month, including:
• Total clients registered.
• Total events organized, categorized by status.
• Top 3 most popular vendors based on bookings.
• Total revenue from payments received.Some useful API Endpoint for Testing:
1. Create Client
•
Description: Registers a new client.
2. Get Client by ID
• Description: Fetches details of a specific client.
• Path Variable: Set clientId to the ID of a registered client.
3. Create Event for Client
•
Description: Creates an event for a client.
4. Add Vendor
•
Description: Registers a new vendor.
5. Book Vendor for Event
•
Description: Books a vendor for a specific event.
6. Cancel Vendor Booking
• Description: Cancels a specific vendor booking.
• Path Variable: Set bookingId to the ID of an existing booking.
7. Record a Payment
•
Description: Records a payment for a client.
8. Get All Payments with Filter
•
Description: Lists all payments filtered by status.9. Get Available Vendors by Service Type and Date
•
Description: Retrieves available vendors for a specific service type and date.
10. Generate Monthly Summary Report (Bonus)
•
Description: Generates a report of all activities from the previous month.
