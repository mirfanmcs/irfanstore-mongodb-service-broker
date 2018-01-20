package com.irfanstore.irfanstoremongodbservicebroker.repository;


import com.irfanstore.irfanstoremongodbservicebroker.model.ServiceInstance;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoServiceInstanceRepository extends MongoRepository<ServiceInstance, String> {

}