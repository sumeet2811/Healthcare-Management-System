<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment Page</title>
    <style>
        .payment-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .payment-details {
            margin-bottom: 20px;
        }
        .payment-mode {
            margin-bottom: 15px;
        }
        .submit-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .submit-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="payment-container">
        <h2>Payment Details</h2>
        <div class="payment-details">
            <p><strong>Appointment Charge:</strong> ₹${appointmentCharge}</p>
        </div>
        <form action="processPayment" method="post">
            <div class="payment-mode">
                <label for="paymentMode">Select Payment Mode:</label>
                <select name="paymentMode" id="paymentMode" required>
                    <option value="">Select Payment Mode</option>
                    <option value="CASH">Cash</option>
                    <option value="CARD">Card</option>
                    <option value="UPI">UPI</option>
                    <option value="NET_BANKING">Net Banking</option>
                </select>
            </div>
            <button type="submit" class="submit-btn">Proceed to Payment</button>
        </form>
    </div>
</body>
</html> 