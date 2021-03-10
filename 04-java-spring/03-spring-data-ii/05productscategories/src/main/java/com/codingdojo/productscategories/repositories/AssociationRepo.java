package com.codingdojo.productscategories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productscategories.models.Association;

public interface AssociationRepo extends CrudRepository<Association, Long>{

}
