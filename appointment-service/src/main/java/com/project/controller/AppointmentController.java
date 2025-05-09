package com.project.controller;

import org.springframework.web.bind.annotation.*;

import com.project.dto.AppointmentDTO;
import com.project.model.Appointment;
import com.project.service.AppointmentService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

@RestController()
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody Appointment appointment) {
        // Validation if patientId exists in patient-service - REST TEMPLATE
        // Validation if doctorId exists in doctor-service - REST TEMPLATE
        // if patientId and doctorId are valid, create the appointment
        // else return error

        return ResponseEntity.ok().body(new AppointmentDTO());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody Appointment appointment) {

        return ResponseEntity.ok().body(new AppointmentDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@RequestBody UUID id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();

        if (appointments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(appointments);
    }

}
