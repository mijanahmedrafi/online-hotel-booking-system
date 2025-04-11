-- Create database
CREATE DATABASE IF NOT EXISTS hotel_db;
USE hotel_db;

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(256) NOT NULL,
    role ENUM('Customer', 'Admin') NOT NULL
);

-- Table: rooms
CREATE TABLE IF NOT EXISTS rooms (
    roomID INT PRIMARY KEY AUTO_INCREMENT,
    roomType VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    available BOOLEAN DEFAULT TRUE
);

-- Table: bookings
CREATE TABLE IF NOT EXISTS bookings (
    bookingID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT,
    roomID INT,
    checkIn DATE,
    checkOut DATE,
    FOREIGN KEY (userID) REFERENCES users(userID),
    FOREIGN KEY (roomID) REFERENCES rooms(roomID)
);

-- Insert sample users
INSERT INTO users (name, email, password, role) VALUES
('Admin User', 'admin@hotel.com', SHA2('admin123', 256), 'Admin'),
('John Doe', 'john@example.com', SHA2('password123', 256), 'Customer');

-- Insert sample rooms
INSERT INTO rooms (roomType, price, available) VALUES
('Single', 80.00, TRUE),
('Double', 100.00, TRUE),
('Deluxe', 150.00, TRUE);

-- Insert sample booking
INSERT INTO bookings (userID, roomID, checkIn, checkOut) VALUES
(2, 3, '2025-04-15', '2025-04-18');
