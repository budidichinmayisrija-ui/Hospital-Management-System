
package com.hospital.management.controller;

import com.hospital.management.entity.LabTest;
import com.hospital.management.repository.LabTestRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LabTestController {

    private final LabTestRepository labTestRepository;

    public LabTestController(LabTestRepository labTestRepository) {
        this.labTestRepository = labTestRepository;
    }

    @GetMapping("/lab-tests")
    public String showLabTests(Model model) {
        model.addAttribute("labTestList", labTestRepository.findAll());
        return "lab-tests";
    }

    @PostMapping("/lab-tests")
    public String addLabTest(LabTest labTest) {
        labTestRepository.save(labTest);
        return "redirect:/lab-tests";
    }
}
