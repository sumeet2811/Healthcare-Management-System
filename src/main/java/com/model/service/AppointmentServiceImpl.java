package com.model.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Appointment;
import com.bean.Patient;
import com.bean.Schedule;
import com.bean.Payment;
import com.model.persistence.AppointmentDao;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PaymentService paymentService;

	private static final Double APPOINTMENT_CHARGE = 500.0;

	@Override
	@Transactional
	public Appointment requestAppointment(String patientId, String doctorId, Date date, String paymentMode) {
		try {
			// Get patient information
			Patient patient = patientService.getPatientById(patientId);
			List<Schedule> doctorSchedules = doctorService.getDoctorSchedule(doctorId);
			List<Schedule> availableDoctors = doctorService.getAvailableDoctors(date);
			
			// Check if the doctor is available on the requested date
			boolean isDoctorAvailable = availableDoctors.stream()
					.anyMatch(schedule -> schedule.getDoctorId().equals(doctorId));

			if (!isDoctorAvailable) {
				throw new IllegalArgumentException("Doctor is not available on the requested date");
			}
			
			if (patient != null && !doctorSchedules.isEmpty()) {
				// Create and save appointment
				Appointment appointment = new Appointment();
				appointment.setPatientId(patientId);
				appointment.setPatientName(patient.getPatientName());
				appointment.setDoctorId(doctorId);
				appointment.setDoctorName(doctorSchedules.get(0).getNameOfDoctor());
				appointment.setDate(date);
				appointment.setSlot(doctorSchedules.get(0).getSlotStart());
				appointment.setDepartment(patient.getPatientSymptoms());
				
				Appointment savedAppointment = appointmentDao.save(appointment);
				
				// Process payment
				if (savedAppointment != null) {
					paymentService.processPayment(
						patientId,
						doctorId,
						APPOINTMENT_CHARGE,
						paymentMode,
						savedAppointment.getAppointmentId()
					);
				}
				
				return savedAppointment;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to book appointment: " + e.getMessage());
		}
	}
}