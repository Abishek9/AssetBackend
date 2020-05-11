package com.capgemini.springboot.cruddemo.service;

import java.util.List;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.springboot.cruddemo.dao.AssetRepository;
import com.capgemini.springboot.cruddemo.entity.Asset;



@Service
public class AssetServiceImpl implements AssetService {

	private AssetRepository assetRepository;

	@Autowired
	public AssetServiceImpl(AssetRepository theassetRepository) {
		assetRepository = theassetRepository;
	}

	@Override
	public List<Asset> findAllAssets() {

		return assetRepository.findAll();
	}

	@Override
	public Asset findAssetById(int id) {

		Optional<Asset> result = assetRepository.findById(id);
		Asset asset = null;
		if (result.isPresent()) {
			asset = result.get();
		} 

		return asset;
	}

	@Override
	public Asset save(Asset asset) {
		return assetRepository.save(asset);
	}

	@Override
	public void deleteById(int id) {
		assetRepository.deleteById(id);
	}

	

	

}
