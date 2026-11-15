package com.hospital.management.controller;

import com.hospital.management.entity.Doctor;
import com.hospital.management.repository.DoctorRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/doctors")
    public String showDoctors(Model model) {
        model.addAttribute("doctors", doctorRepository.findAll());
        return "doctors";
    }

    @PostMapping("/doctors")
    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }
}