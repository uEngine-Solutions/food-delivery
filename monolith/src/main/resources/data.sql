INSERT INTO Orders (orderId, foodSelection, quantity, specialRequest, deliveryAddress, paymentMethod, orderAmount, orderStatus, estimatedDeliveryTime) VALUES
('order1', 'Pizza', 1, 'Extra cheese', '123 Main St', 'Credit Card', 19.99, 'Placed', '30 mins'),
('order2', 'Burger', 2, 'No onions', '456 Elm St', 'Cash', 15.98, 'Placed', '45 mins');

INSERT INTO Riders (riderId, riderName, riderStatus) VALUES
('rider1', 'John Doe', 'Available'),
('rider2', 'Jane Smith', 'Available');