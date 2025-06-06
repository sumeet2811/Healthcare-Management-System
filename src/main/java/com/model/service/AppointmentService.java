package com.model.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.Appointment;
import com.bean.Patient;

@Service
public interface AppointmentService {
	Appointment requestAppointment(String id, String doc_id, Date date, String paymentMode);
}
