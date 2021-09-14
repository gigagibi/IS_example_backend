package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Office;

import java.util.List;

public interface OfficeService {
    Office getById(int officeId);

    List<Office> createOffice(Office office);

    List<Office> deleteOffice(int officeId);

    List<Office> updateOffice(int officeId, Office office);

    List<Office> getAll();

    List<Office> deleteOfficeByAddress(String address);

    Office getOfficeByAddress(String address);

    List<Office> deleteAll();
}
