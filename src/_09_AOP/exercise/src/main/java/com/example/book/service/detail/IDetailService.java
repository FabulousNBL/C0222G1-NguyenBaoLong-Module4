package com.example.book.service.detail;

import com.example.book.model.Detail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDetailService {
    void save(Detail detail);

    Detail findById(String id);

    void delete(Detail detail);

}
