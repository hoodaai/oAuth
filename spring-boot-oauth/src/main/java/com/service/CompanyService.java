package com.service;

import com.domain.Company;
import com.web.rest.dto.BeneficialOwnerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 *
 */
public interface CompanyService {

    Company save(Company company);

    Page<Company> findAllCompanies(Pageable pageable);

    Optional<Company> getByName(String name);

    void updateCompany(Company company);

    void saveBeneficialOwner(Integer companyId, BeneficialOwnerDTO beneficialOwner);
}
