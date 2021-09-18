package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Office;

import java.util.List;

public interface OfficeService {
    Office getById(int officeId);

    List<Office> create(Office office);

    List<Office> delete(int officeId);

    List<Office> update(int officeId, Office office);

    List<Office> getAll();

    List<Office> deleteOfficeByAddress(String address);

    Office getOfficeByAddress(String address);

    Office getOfficeByDepartmentId(int departmentId);

    List<Office> deleteAll();
}
