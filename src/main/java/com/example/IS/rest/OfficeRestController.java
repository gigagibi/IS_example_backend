package com.example.IS.rest;

import com.example.IS.exceptions.EntityNotFoundException;
import com.example.IS.models.Office;
import com.example.IS.serviceImpl.repoImpl.OfficeServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/office")
@AllArgsConstructor
public class OfficeRestController {
    private final OfficeServiceRepoImpl officeService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/")
    public List<Office> getOffices() {
        return officeService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public List<Office> createOffice(@RequestBody Office office) {
        return officeService.create(office);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public Office getOffice(@PathVariable int id) {
        return officeService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<Office> deleteOffices() {
        return officeService.deleteAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public List<Office> deleteOffice(@PathVariable int id) throws EntityNotFoundException{
        if(officeService.getById(id) == null)
            throw new EntityNotFoundException();
        return officeService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{officeId}")
    public List<Office> updateOffice(@PathVariable int officeId, @RequestBody Office newOffice) throws EntityNotFoundException {
        if(officeService.getById(officeId) == null)
            throw new EntityNotFoundException();
        else {
            officeService.update(officeId, newOffice);
            return officeService.getAll();
        }
    }


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/address")
    public Office getOfficeByAddress(@RequestParam String address) {
        return officeService.getOfficeByAddress(address);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/address")
    public List<Office> deleteOfficeByAddress(@RequestParam String address) {
        return officeService.deleteOfficeByAddress(address);
    }

    @GetMapping("/department")
    public Office getOfficeByDepartmentId(@RequestParam int departmentId) {
        return officeService.getOfficeByDepartmentId(departmentId);
    }
}
