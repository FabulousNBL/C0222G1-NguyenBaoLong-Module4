package com.example.casestudy.rest;

import com.example.casestudy.model.contract.AttachService;
import com.example.casestudy.model.contract.ContractDetail;
import com.example.casestudy.service.contract.IAttachService;
import com.example.casestudy.service.contract.IContractService;
import com.example.casestudy.service.contractDetail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contract-rest")
public class ContractRestController {
    @Autowired
    private IAttachService attachService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService detailService;

    @GetMapping("/getId")
    public ResponseEntity<?> findAttachList(int id){
        List<AttachService> attachServiceList= new ArrayList<>();

       List<Integer> attachListId = attachService.attachId(id);
        for (Integer item:attachListId) {
            attachServiceList.add(attachService.findById(item));
        }

        return new ResponseEntity<>(attachServiceList, HttpStatus.OK);
    }
}
