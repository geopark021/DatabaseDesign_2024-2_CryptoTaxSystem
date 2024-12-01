package com.cryptotaxsystem.backend.repository;

import com.cryptotaxsystem.backend.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Integer> {
}
