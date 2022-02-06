package com.techeer.techeers.domain.user.repository;

import com.techeer.techeers.domain.user.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
