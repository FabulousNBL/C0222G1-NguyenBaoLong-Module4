package com.example.casestudy.service.contractDetail;

import com.example.casestudy.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    ContractDetail findByContract(int id);
}
