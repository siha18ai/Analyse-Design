package com.gmail.simon.backend;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.gmail.simon.backend.data.entity.HistoryItem;

@Repository
public interface HistoryItemRepository extends EntityRepository<HistoryItem, Long> {
}
