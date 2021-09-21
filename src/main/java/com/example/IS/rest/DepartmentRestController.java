package com.example.IS.rest;

import com.example.IS.exceptions.EntityNotFoundException;
import com.example.IS.models.Department;
import com.example.IS.serviceImpl.repoImpl.DepartmentServiceRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentRestController {
    private final DepartmentServiceRepoImpl departmentService;

    @GetMapping("/")
    public List<Department> getDepartments() {
        return departmentService.getAll();
    }

    @DeleteMapping("/")
    public List<Department> deleteDepartments() {
        return departmentService.deleteAll();
    }

    @PostMapping("/")
    public List<Department> createDepartment(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id) {
        return departmentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public List<Department> deleteDepartment(@PathVariable int id) throws EntityNotFoundException {
        if(departmentService.getById(id) == null)
            throw new EntityNotFoundException();
        else
            return departmentService.delete(id);
    }

    @PutMapping("/{id}")
    public List<Department> updateDepartment(@PathVariable int id, @RequestBody Department department) throws EntityNotFoundException  {
        if(departmentService.getById(id) == null)
            throw new EntityNotFoundException();
        else {
            departmentService.update(id, department);
            return departmentService.getAll();
        }
    }

    @GetMapping("/name")
    public List<Department> getDepartmentsByName(@RequestParam String name) {
        return departmentService.getAllByName(name);
    }

    @GetMapping("/office")
    public List<Department> getDepartmentsByOfficeId(@RequestParam int officeId) {
        return departmentService.getAllByOfficeId(officeId);
    }
}
