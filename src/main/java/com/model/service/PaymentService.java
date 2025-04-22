package com.model.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bean.Payment;

@Service
public interface PaymentService {
    Payment processPayment(String patientId, String doctorId, Double amount, String paymentMode, Integer appointmentId);
    Payment getPaymentByAppointmentId(Integer appointmentId);
    boolean verifyPayment(Integer paymentId);
    Payment savePayment(Payment payment);
    Payment getPaymentById(Integer paymentId);
    List<Payment> getAllPayments();
    Payment updatePayment(Payment payment);
    void deletePayment(Integer paymentId);
    List<Payment> getPaymentsByPatientId(String patientId);
    List<Payment> getPaymentsByDoctorId(String doctorId);
} 