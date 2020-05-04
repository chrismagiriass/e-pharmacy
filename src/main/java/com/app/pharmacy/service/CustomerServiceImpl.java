package com.app.pharmacy.service;

import com.app.pharmacy.dto.CustomerDTO;
import com.app.pharmacy.mapper.CustomerMapper;
import com.app.pharmacy.model.Customer;
import com.app.pharmacy.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> findAll() {
        return customerMapper.entityToDTOList(customerRepo.findAll());
    }

    @Override
    @Transactional
    public void save(CustomerDTO dto) {
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

}