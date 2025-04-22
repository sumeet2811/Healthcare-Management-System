package com.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.bean.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Long> {
    Payment findByAppointmentId(Long appointmentId);
    List<Payment> findByPatientId(String patientId);
    List<Payment> findByDoctorId(String doctorId);
} 