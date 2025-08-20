package net.javaguides.ems_backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.ems_backend.dto.request.EmployeeRequest;
import net.javaguides.ems_backend.dto.response.EmployeeResponse;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.exception.EmailAlreadyExistsException;
import net.javaguides.ems_backend.repository.EmployeeRepository;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final ObjectMapper objectMapper; // Injected automatically by Spring

    public EmployeeServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {

        if (employeeRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + request.getEmail());
        }

       // Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee employee = objectMapper.convertValue(request, Employee.class);

        // Save to database
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert back Entity to DTO
        return objectMapper.convertValue(savedEmployee, EmployeeResponse.class);
    }


    @Override
    public EmployeeResponse getEmployeeById(Long Id) {
        return null;
    }
}
