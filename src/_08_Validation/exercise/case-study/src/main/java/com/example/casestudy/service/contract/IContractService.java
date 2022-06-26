package com.example.casestudy.service.contract;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface IContractService {
    Page<Contract> findAllContract(Pageable pageable);

    void create (Contract contract);
}
