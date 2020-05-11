package com.capgemini.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.cruddemo.entity.Asset;


public interface AssetRepository extends JpaRepository<Asset, Integer> {
	
	// no need to write code
}

