package com.hospital.management.controller;

import com.hospital.management.entity.MedicalRecord;
import com.hospital.management.repository.MedicalRecordRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalRecordController {

    private final MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordController(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @GetMapping("/medical-records")
    public String showMedicalRecords(Model model) {
        model.addAttribute("medicalRecords", medicalRecordRepository.findAll());
        return "medical-records";
    }

    @PostMapping("/medical-records")
    public String addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
        return "redirect:/medical-records";
    }
}