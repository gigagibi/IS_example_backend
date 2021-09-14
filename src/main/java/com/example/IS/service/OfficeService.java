package com.example.IS.service;

import com.example.IS.models.Office;

import java.util.List;

public interface OfficeService {
    public Office getById(int officeId);

    public List<Office> createOffice(Office office);

    public List<Office> deleteOffice(int officeId);

    public List<Office> updateOffice(int officeId, Office office);

    public List<Office> getAll();

    public List<Office> deleteOfficeByAddress(String address);

    public Office getOfficeByAddress(String address);
}
