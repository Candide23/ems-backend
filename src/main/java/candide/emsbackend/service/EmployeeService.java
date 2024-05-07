package candide.emsbackend.service;

import candide.emsbackend.dto.EmployeeDto;
import candide.emsbackend.entity.Employee;
import org.springframework.stereotype.Service;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
}
