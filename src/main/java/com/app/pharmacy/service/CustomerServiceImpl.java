package com.app.pharmacy.service;

import com.app.pharmacy.dto.CustomerDTO;
import com.app.pharmacy.mapper.CustomerMapper;
import com.app.pharmacy.model.Customer;
import com.app.pharmacy.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerDTO> findAll() {
        return customerMapper.entityToDTOList(customerRepo.findAll());
    }

    @Override
    @Transactional
    public void save(CustomerDTO dto) {
        if (dto.getNewPassword() != null && dto.getNewPassword().length() > 0) {
            dto.setPassword(passwordEncoder.encode(dto.getNewPassword()));

        }

        if (dto.getPersonId() == null) {
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        customerRepo.save(customerMapper.dtoToEntity(dto));
    }

    @Override
    public CustomerDTO findById(Integer id) {
        Optional<Customer> result = customerRepo.findById(id);
        return result.isPresent() ? customerMapper.entityToDTO(result.get()) : null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO findByUsername(String email) {
        Optional<Customer> result = customerRepo.findByEmail(email);
        return result.isPresent() ? customerMapper.entityToDTO(result.get()) : null;
    }

    @Override
    public boolean uniqueEmail(String email) {
        Optional<Customer> result = customerRepo.findByEmail(email);
        return !result.isPresent(); //result.isEmpty() ? true : false;
    }

    @Override
    public List<CustomerDTO> findAllPagination(int page, int size, String sort) {
        Pageable pageable
                = PageRequest.of(page, size, Sort.by(sort));
        return customerMapper.entityToDTOList(customerRepo.findAll(pageable).getContent());
    }

}
