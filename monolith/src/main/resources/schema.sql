CREATE TABLE Orders (
    orderId VARCHAR(255) PRIMARY KEY,
    foodSelection VARCHAR(255),
    quantity INT,
    specialRequest VARCHAR(255),
    deliveryAddress VARCHAR(255),
    paymentMethod VARCHAR(255),
    orderAmount DECIMAL(10, 2),
    orderStatus VARCHAR(255),
    estimatedDeliveryTime VARCHAR(255)
);

CREATE TABLE Riders (
    riderId VARCHAR(255) PRIMARY KEY,
    riderName VARCHAR(255),
    riderStatus VARCHAR(255)
);