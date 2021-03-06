package com.app.pharmacy.service;

import com.app.pharmacy.dto.EmployeeDTO;
import com.app.pharmacy.mapper.EmployeeMapper;
import com.app.pharmacy.model.Employee;
import com.app.pharmacy.repository.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris Tzelis
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeMapper.entityToDTOList(employeeRepository.findAll());
    }

    @Override
    public void save(EmployeeDTO dto) {

        if (dto.getNewPassword() != null && dto.getNewPassword().length() > 0) {
            dto.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        }
        if (dto.getPersonId() == null) {
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        employeeRepository.save(employeeMapper.dtoToEntity(dto));
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);
        return result.isPresent() ? employeeMapper.entityToDTO(result.get()) : null;
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

}
