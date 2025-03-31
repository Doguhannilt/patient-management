package com.project.patient_service.mapper;

import com.project.patient_service.dto.PatientResponseDTO;
import com.project.patient_service.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setName(patient.getName());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        patientDTO.setEmail(patient.getEmail());

        return patientDTO;
    }
}
