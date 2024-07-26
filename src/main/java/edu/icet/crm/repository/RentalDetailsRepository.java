package edu.icet.crm.repository;

import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.entity.RentalDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentalDetailsRepository extends CrudRepository<RentalDetailsEntity,Long> {
}
