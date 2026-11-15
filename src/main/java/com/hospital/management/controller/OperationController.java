
package com.hospital.management.controller;

import com.hospital.management.entity.Operation;
import com.hospital.management.repository.OperationRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OperationController {

    private final OperationRepository operationRepository;

    public OperationController(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @GetMapping("/operations")
    public String showOperations(Model model) {
        model.addAttribute("operationList", operationRepository.findAll());
        return "operations";
    }

    @PostMapping("/operations")
    public String addOperation(Operation operation) {
        operationRepository.save(operation);
        return "redirect:/operations";
    }
}
