/*
 * Autor: Jaime Ramírez
 * Metodos para el CRUD Service
 * 23/05/2019
 *
 * */
package com.cds.dao;
import java.util.List;
import java.util.Map;

import com.cds.model.Service;

public interface ServiceDao {
	Long saveService(Service service) ;
	List<Map<String, String>> findAllService();
    Long deleteService(Long id); 
	Long updateService(Service service);  
	List<Map<String, String>> findServiceById(Long id);
}
