package com.example.storage.dao;

import com.example.storage.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDao extends JpaRepository<Storage, Long>, JpaSpecificationExecutor<Storage> {


}
