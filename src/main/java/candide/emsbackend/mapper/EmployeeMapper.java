package candide.emsbackend.mapper;

import candide.emsbackend.dto.EmployeeDto;
import candide.emsbackend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {

        return new EmployeeDto(employee.getId(),
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLastName()
        );
    }

    public  static Employee mapToEmployee(EmployeeDto employeeDto) {

        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
