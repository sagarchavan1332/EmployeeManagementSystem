package net.javaguides.ems_backend.controller;

import jakarta.validation.Valid;
import net.javaguides.ems_backend.dto.request.EmployeeRequest;
import net.javaguides.ems_backend.dto.response.EmployeeResponse;
import net.javaguides.ems_backend.response.ApiResponse;
import net.javaguides.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(@Valid @RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.success(response, "Employee created successfully")
        );
    }

    //added

}
