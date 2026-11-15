
package com.hospital.management.controller;

import com.hospital.management.entity.Bill;
import com.hospital.management.repository.BillRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BillController {

    private final BillRepository billRepository;

    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @GetMapping("/bills")
    public String showBills(Model model) {
        model.addAttribute("bills", billRepository.findAll());
        return "bills";
    }

    @PostMapping("/bills")
    public String addBill(Bill bill) {

        double total = bill.getConsultationFee()
                + bill.getMedicineCharges()
                + bill.getRoomCharges();

        bill.setTotalAmount(total);

        billRepository.save(bill);

        return "redirect:/bills";
    }
}
