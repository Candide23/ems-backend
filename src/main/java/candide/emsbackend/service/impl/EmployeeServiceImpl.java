package candide.emsbackend.service.impl;

import candide.emsbackend.dto.EmployeeDto;
import candide.emsbackend.entity.Employee;
import candide.emsbackend.exception.ResourceNotFoundException;
import candide.emsbackend.mapper.EmployeeMapper;
import candide.emsbackend.repository.EmployeeRepository;
import candide.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {

       List <Employee> employees = employeeRepository.findAll();

       return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }


}
