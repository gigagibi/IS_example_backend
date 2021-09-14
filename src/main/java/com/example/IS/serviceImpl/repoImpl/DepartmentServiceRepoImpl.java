package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import com.example.IS.repositories.DepartmentRepository;
import com.example.IS.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceRepoImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department getById(int departmentId) {
        return departmentRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Department> createDepartment(Department department) {
        departmentRepository.saveAndFlush(department);
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> deleteDepartment(int departmentId) {
        departmentRepository.deleteById(departmentId);
        return departmentRepository.findAll();
    }

    @Override
    public List<Department> updateDepartment(int departmentId, Department department) {
        departmentRepository.updateDepartment(departmentId, department.getName(), department.getOffice().getOfficeId());
        return departmentRepository.findAll();
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

    @Override
    public List<Department> deleteAll() {
        departmentRepository.deleteAll();
        return departmentRepository.findAll();
    }
}