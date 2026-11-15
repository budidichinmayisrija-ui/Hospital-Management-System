
package com.hospital.management.controller;

import com.hospital.management.entity.Staff;
import com.hospital.management.repository.StaffRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StaffController {

    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping("/staff")
    public String showStaff(Model model) {
        model.addAttribute("staffList", staffRepository.findAll());
        return "staff";
    }

    @PostMapping("/staff")
    public String addStaff(Staff staff) {
        staffRepository.save(staff);
        return "redirect:/staff";
    }
}
