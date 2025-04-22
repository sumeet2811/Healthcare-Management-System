package com.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.bean.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {
    Payment findByAppointmentId(Integer appointmentId);
    List<Payment> findByPatientId(String patientId);
    List<Payment> findByDoctorId(String doctorId);
} 