package com.gmail.simon.backend;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryResult;
import org.apache.deltaspike.data.api.Repository;

import com.gmail.simon.backend.data.entity.PickupLocation;

@Repository
public interface PickupLocationRepository extends EntityRepository<PickupLocation, Long> {

	QueryResult<PickupLocation> findByNameLikeIgnoreCase(String nameFilter);

	@Query("select count(e) from PickupLocation e WHERE lower(e.name) like lower(?1)")
	int countByNameLikeIgnoreCase(String nameFilter);
}
