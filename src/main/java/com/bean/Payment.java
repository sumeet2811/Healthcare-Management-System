package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "payment")
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;
    
    @Column(name = "patient_id")
    private String patientId;
    
    @Column(name = "doctor_id")
    private String doctorId;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "payment_mode")
    private String paymentMode;
    
    @Column(name = "payment_status")
    private String paymentStatus;
    
    @Column(name = "appointment_id")
    private Integer appointmentId;
    
    public Payment() {
    }
    
    public Payment(String patientId, String doctorId, Double amount, String paymentMode, String paymentStatus, Integer appointmentId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.appointmentId = appointmentId;
    }
    
    // Getters and Setters
    public Integer getPaymentId() {
        return paymentId;
    }
    
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    
    public String getDoctorId() {
        return doctorId;
    }
    
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String getPaymentMode() {
        return paymentMode;
    }
    
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
    
    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    public Integer getAppointmentId() {
        return appointmentId;
    }
    
    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    @Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", amount="
                + amount + ", paymentMode=" + paymentMode + ", paymentStatus=" + paymentStatus + ", appointmentId="
                + appointmentId + "]";
    }
} 