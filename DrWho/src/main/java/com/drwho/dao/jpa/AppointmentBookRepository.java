package com.drwho.dao.jpa;

import com.drwho.domain.AppointmentBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface AppointmentBookRepository extends PagingAndSortingRepository<AppointmentBook, Long> {
    //Client findHotelByCity(String city);
    Page findAll(Pageable pageable);
}