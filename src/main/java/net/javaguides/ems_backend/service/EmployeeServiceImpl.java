package net.javaguides.ems_backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.EmployeeDto;
import net.javaguides.ems_backend.entity.Employee;
import net.javaguides.ems_backend.exception.EmailAlreadyExistsException;
import net.javaguides.ems_backend.mapper.EmployeeMapper;
import net.javaguides.ems_backend.repository.EmployeeRepository;
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
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        if (employeeRepository.existsByEmail(employeeDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + employeeDto.getEmail());
        }

       // Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee employee = objectMapper.convertValue(employeeDto, Employee.class);

        // Save to database
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert back Entity to DTO
        return objectMapper.convertValue(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long Id) {
        return null;
    }
}
