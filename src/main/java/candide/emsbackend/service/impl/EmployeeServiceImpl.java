package candide.emsbackend.service.impl;

import candide.emsbackend.dto.EmployeeDto;
import candide.emsbackend.entity.Employee;
import candide.emsbackend.mapper.EmployeeMapper;
import candide.emsbackend.repository.EmployeeRepository;
import candide.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;



    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
         Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
         Employee saveEmployee = employeeRepository.save(newEmployee);
         return EmployeeMapper.mapToEmployeeDto(saveEmployee);



    }
}
