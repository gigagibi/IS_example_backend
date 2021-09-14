package com.example.IS.rest;

import com.example.IS.models.Office;
import com.example.IS.serviceImpl.repoImpl.OfficeServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/office")
@AllArgsConstructor
public class OfficeRestController {
    private final OfficeServiceImpl officeService;

    @GetMapping("/")
    public List<Office> getAllOffices() {
        return officeService.getAll();
    }

    @PostMapping("/")
    public List<Office> createOffice(@RequestBody Office office) {
        officeService.createOffice(office);
        return officeService.getAll();
    }
}
