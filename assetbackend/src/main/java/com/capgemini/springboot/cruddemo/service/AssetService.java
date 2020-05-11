package com.capgemini.springboot.cruddemo.service;

import java.util.List;

import com.capgemini.springboot.cruddemo.entity.Asset;

public interface AssetService {

	public List<Asset> findAllAssets();

	public Asset findAssetById(int id);

	public Asset save(Asset asset);

	public void deleteById(int id);
	

	
	
}
