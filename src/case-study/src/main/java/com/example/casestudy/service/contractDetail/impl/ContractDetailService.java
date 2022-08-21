package com.example.casestudy.service.contractDetail.impl;

import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.repository.contractDetail.IContractDetailRepository;
import com.example.casestudy.service.contractDetail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findByContract(int id) {
        return contractDetailRepository.findByContract(id);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
