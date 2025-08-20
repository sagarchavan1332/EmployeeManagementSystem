package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.request.EmployeeRequest;
import net.javaguides.ems_backend.dto.response.EmployeeResponse;

public interface EmployeeService {

    EmployeeResponse createEmployee(EmployeeRequest request);

    EmployeeResponse getEmployeeById(Long Id);


}
