package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import com.example.IS.repositories.DepartmentRepository;
import com.example.IS.repositories.OfficeRepository;
import com.example.IS.services.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OfficeServiceRepoImpl implements OfficeService {
    private final OfficeRepository officeRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public Office getById(int officeId) {
        return officeRepository.findByOfficeId(officeId);
    }

    @Override
    public List<Office> create(Office office) {
        officeRepository.saveAndFlush(office);
        return officeRepository.findAll();
    }

    @Override
    public List<Office> delete(int officeId) {
        officeRepository.deleteById(officeId);
        return officeRepository.findAll();
    }

    @Override
    public List<Office> update(int officeId, Office office) {
        officeRepository.updateOffice(officeId, office.getAddress());
        officeRepository.flush();
        return officeRepository.findAll();
    }

    @Override
    public List<Office> getAll() {
        return officeRepository.findAll();
    }

    @Override
    public List<Office> deleteOfficeByAddress(String address) {
        officeRepository.deleteByAddress(address);
        return officeRepository.findAll();
    }

    @Override
    public Office getOfficeByAddress(String address) {
        return officeRepository.findByAddress(address);
    }

    @Override
    public Office getOfficeByDepartmentId(int departmentId) {
        return departmentRepository.getById(departmentId).office;
    }


    @Override
    public List<Office> deleteAll() {
        officeRepository.deleteAll();
        return officeRepository.findAll();
    }
}
