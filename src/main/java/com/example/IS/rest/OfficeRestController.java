package com.example.IS.rest;

import com.example.IS.exceptions.EntityNotFoundException;
import com.example.IS.models.Office;
import com.example.IS.serviceImpl.repoImpl.OfficeServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/office")
@AllArgsConstructor
public class OfficeRestController {
    private final OfficeServiceRepoImpl officeService;

    @GetMapping("/")
    public List<Office> getOffices() {
        return officeService.getAll();
    }

    @PostMapping("/")
    public List<Office> createOffice(@RequestBody Office office) {
        return officeService.create(office);
    }

    @GetMapping("/{id}")
    public Office getOffice(@PathVariable int id) {
        return officeService.getById(id);
    }

    @DeleteMapping("/")
    public List<Office> deleteOffices() {
        return officeService.deleteAll();
    }


    @DeleteMapping("/{id}")
    public List<Office> deleteOffice(@PathVariable int id) throws EntityNotFoundException{
        if(officeService.getById(id) == null)
            throw new EntityNotFoundException();
        return officeService.delete(id);
    }

    @PutMapping("/{officeId}")
    public List<Office> updateOffice(@PathVariable int officeId, @RequestBody Office newOffice) throws EntityNotFoundException {
        if(officeService.getById(officeId) == null)
            throw new EntityNotFoundException();
        else {
            officeService.update(officeId, newOffice);
            return officeService.getAll();
        }
    }

    @GetMapping("/address")
    public Office getOfficeByAddress(@RequestParam String address) {
        return officeService.getOfficeByAddress(address);
    }

    @DeleteMapping("/address")
    public List<Office> deleteOfficeByAddress(@RequestParam String address) {
        return officeService.deleteOfficeByAddress(address);
    }

    @GetMapping("/department")
    public Office getOfficeByDepartmentId(@RequestParam int departmentId) {
        return officeService.getOfficeByDepartmentId(departmentId);
    }
}
