
package com.hospital.management.repository;

import com.hospital.management.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
