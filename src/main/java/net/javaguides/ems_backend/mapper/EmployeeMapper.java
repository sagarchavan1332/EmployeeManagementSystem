package net.javaguides.ems_backend.mapper;

import net.javaguides.ems_backend.dto.response.EmployeeResponse;
import net.javaguides.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeResponse mapToEmployeeDto(Employee employee) {
        EmployeeResponse employeeDto = new EmployeeResponse();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeResponse employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }

}
