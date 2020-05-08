package com.med.springboot.moviecatalogservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.med.springboot.moviecatalogservice.models.CatalogItem;

public interface CatalogRepository extends CrudRepository<CatalogItem, Integer> {

}
