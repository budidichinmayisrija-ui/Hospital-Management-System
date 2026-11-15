
package com.hospital.management.controller;

import com.hospital.management.entity.Admission;
import com.hospital.management.repository.AdmissionRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdmissionController {

    private final AdmissionRepository admissionRepository;

    public AdmissionController(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    @GetMapping("/admissions")
    public String showAdmissions(Model model) {
        model.addAttribute("admissionList", admissionRepository.findAll());
        return "admissions";
    }

    @PostMapping("/admissions")
    public String addAdmission(Admission admission) {
        admissionRepository.save(admission);
        return "redirect:/admissions";
    }
}
