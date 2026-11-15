package com.hospital.management.controller;

import com.hospital.management.entity.Appointment;
import com.hospital.management.repository.AppointmentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @GetMapping("/appointments")
    public String showAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        return "appointments";
    }

    @PostMapping("/appointments")
    public String addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }
}