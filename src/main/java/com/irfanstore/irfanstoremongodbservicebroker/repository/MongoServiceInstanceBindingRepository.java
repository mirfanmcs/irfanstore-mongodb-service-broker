package com.irfanstore.irfanstoremongodbservicebroker.repository;


import com.irfanstore.irfanstoremongodbservicebroker.model.ServiceInstanceBinding;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoServiceInstanceBindingRepository extends MongoRepository<ServiceInstanceBinding, String> {

}
