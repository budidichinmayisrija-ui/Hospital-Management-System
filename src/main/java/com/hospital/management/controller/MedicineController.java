
package com.hospital.management.controller;

import com.hospital.management.entity.Medicine;
import com.hospital.management.repository.MedicineRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicineController {

    private final MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @GetMapping("/medicines")
    public String showMedicines(Model model) {
        model.addAttribute("medicines", medicineRepository.findAll());
        return "medicines";
    }

    @PostMapping("/medicines")
    public String addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
        return "redirect:/medicines";
    }
}
