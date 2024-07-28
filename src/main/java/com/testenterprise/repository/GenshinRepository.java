package com.testenterprise.repository;

import com.testenterprise.entity.GenshinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenshinRepository extends JpaRepository<GenshinEntity, String> {
}