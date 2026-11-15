package com.hospital.management.controller;

import com.hospital.management.entity.Patient;
import com.hospital.management.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public String showPatients(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        return "patients";
    }

    @PostMapping("/patients")
    public String addPatient(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patients";
    }
}