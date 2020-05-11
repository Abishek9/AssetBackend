package com.capgemini.springboot.cruddemo.rest;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.cruddemo.entity.Asset;
import com.capgemini.springboot.cruddemo.entity.Users;
import com.capgemini.springboot.cruddemo.exception.ProductNotFoundException;
import com.capgemini.springboot.cruddemo.service.AssetService;


import com.capgemini.springboot.cruddrmo.response.Response;




@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class AssetRestController {

	private AssetService assetService;
	

	

	@Autowired
	public AssetRestController(AssetService theassetService) {
		assetService = theassetService;
		
	}
	
//	@Autowired
//	public ProductRestController(RegisterUser theregisterUser) {
//		registerUser = theregisterUser;
//	}

	// expose "/students" to return list of students
	@GetMapping("/products")
	public List<Asset> findAllAssets() {

		return assetService.findAllAssets();
	}

	// add mapping for GET /students/{studentId}
	@GetMapping("/products/{productId}")
	public Response<Asset> getProduct(@PathVariable int assetId) {

		Asset asset = assetService.findAssetById(assetId);

		if (asset != null) {
			return new Response<>(false, "records found", asset);
		} else {
			throw new ProductNotFoundException("record not found");
		}
	}

	// add mapping for POST /students - add new student
	@PostMapping("/products")
	public Response<Asset> addAsset(@RequestBody Asset asset) {

		// also just in case they pass an id in JSON .... set id to 0
		// this is to force a save of new item .... instead of update
		asset.setAsset_id(0);

		Asset product1 = assetService.save(asset);
		if (product1 != null) {

			return new Response<>(false, "successfully saved", product1);

		} else {
			return new Response<>(true, "save failed", null);
		}
	}

	// add mapping for PUT /students - update student
	@PutMapping("/products")
	public Asset updateProduct(@RequestBody Asset product) {

		assetService.save(product);
		return product;
	}

	// add mapping for DELETE /students/{studentId} - delete student
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId) {

		Asset theProduct = assetService.findAssetById(productId);

		// throw exception if null
		if (theProduct == null) {
			throw new RuntimeException("Product Id not found:" + productId);
		}
		assetService.deleteById(productId);

		return "Deleted product id :" + productId;

	}
	
	
}
