package com.hackaton.finishdown.repos;

import com.hackaton.finishdown.domain.EventCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventCompanyRepo extends JpaRepository<EventCompany, Long> {

    EventCompanyRepo findById(long id);

    List<EventCompanyRepo> findByName(String name);
}
