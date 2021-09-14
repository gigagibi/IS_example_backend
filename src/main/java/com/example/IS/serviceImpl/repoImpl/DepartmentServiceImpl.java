package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import com.example.IS.repositories.DepartmentRepository;
import com.example.IS.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department getById(int departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Department> createDepartment(Department department) {
        departmentRepository.save(department);
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> deleteDepartment(int departmentId) {
        departmentRepository.deleteById(departmentId);
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> updateDepartment(int departmentId, Department department) {
        if(departmentRepository.findByDepartmentId(departmentId) != null) {
            departmentRepository.save(department);
            return departmentRepository.findAll();
        }
        else
            return null;
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> getAllByName(String name) {
        return departmentRepository.findAllByName(name);
    }

    @Override
    public List<Department> getAllByOffice(Office office) {
        return departmentRepository.findAllByOffice(office);
    }
}