package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bean.Payment;
import com.model.persistence.PaymentDao;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentDao paymentDao;

    private static final Double APPOINTMENT_CHARGE = 500.0; // Fixed appointment charge

    @Override
    @Transactional
    public Payment processPayment(String patientId, String doctorId, Double amount, String paymentMode, Integer appointmentId) {
        try {
            logger.info("Processing payment for appointment: {}", appointmentId);
            Payment payment = new Payment(patientId, doctorId, amount, paymentMode, "COMPLETED", appointmentId);
            Payment savedPayment = paymentDao.save(payment);
            logger.info("Payment processed successfully with ID: {}", savedPayment.getPaymentId());
            return savedPayment;
        } catch (Exception e) {
            logger.error("Error processing payment: {}", e.getMessage());
            throw new RuntimeException("Failed to process payment: " + e.getMessage());
        }
    }

    @Override
    public Payment getPaymentByAppointmentId(Integer appointmentId) {
        return paymentDao.findByAppointmentId(appointmentId);
    }

    @Override
    public boolean verifyPayment(Integer paymentId) {
        try {
            Payment payment = paymentDao.findById(paymentId).orElse(null);
            return payment != null && "COMPLETED".equals(payment.getPaymentStatus());
        } catch (Exception e) {
            logger.error("Error verifying payment: {}", e.getMessage());
            return false;
        }
    }

    public Double getAppointmentCharge() {
        return APPOINTMENT_CHARGE;
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Integer paymentId) {
        return paymentDao.findById(paymentId).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDao.findAll();
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public void deletePayment(Integer paymentId) {
        paymentDao.deleteById(paymentId);
    }

    @Override
    public List<Payment> getPaymentsByPatientId(String patientId) {
        return paymentDao.findByPatientId(patientId);
    }

    @Override
    public List<Payment> getPaymentsByDoctorId(String doctorId) {
        return paymentDao.findByDoctorId(doctorId);
    }
} 