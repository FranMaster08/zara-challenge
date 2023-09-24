package com.zara.zara.repository;

import com.zara.zara.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Query(value = "SELECT * FROM PRICES p " +
            "WHERE :timestamp BETWEEN p.start_date AND p.end_date " +
            "AND p.product_id = :productId " +
            "AND p.brand_id = :brandId " +
            "ORDER BY p.priority_id DESC " +
            "LIMIT 1", nativeQuery = true)
    Prices findPriceForProduct(@Param("timestamp") String timestamp,
                                         @Param("productId") String productId,
                                         @Param("brandId") Long brandId);
}
