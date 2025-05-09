package com.project.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.dto.AppointmentDTO;
import com.project.model.Appointment;
import com.project.repository.AppointmentRepository;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public ResponseEntity<Appointment> updateAppointment(Appointment appointment) {
        Appointment existingAppointment = appointmentRepository.findById(appointment.getId()).orElse(null);
        if (existingAppointment != null) {
            existingAppointment.setPatientId(appointment.getPatientId());
            existingAppointment.setDoctorId(appointment.getDoctorId());
            existingAppointment.setServiceDate(appointment.getServiceDate());
            existingAppointment.setServiceType(appointment.getServiceType());
            existingAppointment.setAmount(appointment.getAmount());
            existingAppointment.setPaymentStatus(appointment.isPaymentStatus());
            existingAppointment.setPaymentType(appointment.getPaymentType());
            return ResponseEntity.ok().body(appointmentRepository.save(existingAppointment));
        }
        return ResponseEntity.badRequest().build(); 
    }

    public void deleteAppointment(UUID id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
}
