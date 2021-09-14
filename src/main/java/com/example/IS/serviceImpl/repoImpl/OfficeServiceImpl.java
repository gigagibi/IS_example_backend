package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Office;
import com.example.IS.repositories.OfficeRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.service.OfficeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;

    @Override
    public Office getById(int officeId) {
        return officeRepository.findByOfficeId(officeId);
    }

    @Override
    public List<Office> createOffice(Office office) {
        officeRepository.save(office);
        return officeRepository.findAll();
    }

    @Override
    public List<Office> deleteOffice(int officeId) {
        officeRepository.deleteById(officeId);
        return officeRepository.findAll();
    }

    @Override
    public List<Office> updateOffice(int officeId, Office office) {
        if(officeRepository.findByOfficeId(officeId) != null) {
            officeRepository.save(office);
            return officeRepository.findAll();
        }
        else
            return null;
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
}
