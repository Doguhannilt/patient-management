package com.project.patient_service.service;

import com.project.patient_service.dto.PatientRequestDTO;
import com.project.patient_service.dto.PatientResponseDTO;
import com.project.patient_service.exception.EmailAlreadyExistsException;
import com.project.patient_service.mapper.PatientMapper;
import com.project.patient_service.model.Patient;
import com.project.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = patients
                .stream()
                .map(PatientMapper::toDTO).toList();

        return patientResponseDTOS;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) throws EmailAlreadyExistsException {
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists.");
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

        return PatientMapper.toDTO(newPatient);
    }
}
