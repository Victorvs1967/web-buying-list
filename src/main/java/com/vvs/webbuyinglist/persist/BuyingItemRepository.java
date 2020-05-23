package com.vvs.webbuyinglist.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyingItemRepository extends JpaRepository<BuyingItem, Long> {

}
