package com.hackaton.finishdown.repos;

import com.hackaton.finishdown.domain.EventCompany;
import com.hackaton.finishdown.domain.InfoOfCompany;
import com.hackaton.finishdown.domain.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

import java.util.List;

public interface CompanyRepo extends JpaRepository<InfoOfCompany, Long> {

    InfoOfCompany findById(long id);

    InfoOfCompany findByName(String name);

    InfoOfCompany findByAddress(String address);

    List<InfoOfCompany> findAll();
}
