package com.example.IS.rest;

import com.example.IS.exceptions.EntityNotFoundException;
import com.example.IS.models.Department;
import com.example.IS.serviceImpl.repoImpl.DepartmentServiceRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentRestController {
    private final DepartmentServiceRepoImpl departmentService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/")
    public List<Department> getDepartments() {
        return departmentService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<Department> deleteDepartments() {
        return departmentService.deleteAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public List<Department> createDepartment(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id) {
        return departmentService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public List<Department> deleteDepartment(@PathVariable int id) throws EntityNotFoundException {
        if(departmentService.getById(id) == null)
            throw new EntityNotFoundException();
        else
            return departmentService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public List<Department> updateDepartment(@PathVariable int id, @RequestBody Department department) throws EntityNotFoundException  {
        if(departmentService.getById(id) == null)
            throw new EntityNotFoundException();
        else {
            departmentService.update(id, department);
            return departmentService.getAll();
        }
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/name")
    public List<Department> getDepartmentsByName(@RequestParam String name) {
        return departmentService.getAllByName(name);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/office")
    public List<Department> getDepartmentsByOfficeId(@RequestParam int officeId) {
        return departmentService.getAllByOfficeId(officeId);
    }
}
