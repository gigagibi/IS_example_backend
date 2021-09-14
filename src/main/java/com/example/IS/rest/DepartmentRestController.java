//package com.example.IS.rest;
//
//import com.example.IS.exceptions.EntityNotFoundException;
//import com.example.IS.models.Department;
//import com.example.IS.repositories.DepartmentRepository;
//import com.example.IS.serviceImpl.repoImpl.DepartmentServiceRepoImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/department")
//@RequiredArgsConstructor
//public class DepartmentRestController {
//    private final DepartmentServiceRepoImpl departmentService;
//
//    @GetMapping("/{id}")
//    public Department getDepartment(@PathVariable int id) {
//        return departmentService.getById(id);
//    }
//
//    @PostMapping("/")
//    public List<Department> createDepartment(Department department) {
//        return departmentService.createDepartment(department);
//    }
//
//    @DeleteMapping("/{id}")
//    public List<Department> deleteDepartment(@PathVariable int id) throws EntityNotFoundException {
//        if(departmentService.getById(id) == null)
//            throw new EntityNotFoundException();
//        else
//            return departmentService.deleteDepartment(id);
//    }
//
//    @PutMapping("/{id}")
//    public List<Department>
//}
