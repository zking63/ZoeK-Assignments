package com.codingdojo.productscategories.services;

import org.springframework.stereotype.Service;

import com.codingdojo.productscategories.repositories.AssociationRepo;
import com.codingdojo.productscategories.repositories.CategoryRepo;
import com.codingdojo.productscategories.repositories.ProductRepo;

@Service
public class PCService {
	private final ProductRepo prepo;
	private final CategoryRepo crepo;
	private final AssociationRepo arepo;
	public PCService(ProductRepo prepo, CategoryRepo crepo, AssociationRepo arepo) {
		this.crepo =crepo;
		this.prepo = prepo;
		this.arepo = arepo;
	}
}
