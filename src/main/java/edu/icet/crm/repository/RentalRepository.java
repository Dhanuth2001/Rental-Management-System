package edu.icet.crm.repository;

import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.entity.RentalEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository  extends CrudRepository<RentalEntity,Long> {
}
