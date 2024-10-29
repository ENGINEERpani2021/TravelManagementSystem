package com.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.entity.Cab;
import com.tms.service.CabService;



@RestController
@RequestMapping(value = "cab")
public class CabController {
@Autowired CabService cabService;

@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
public String addCab(@RequestBody Cab cab) {
	return cabService.addCab(cab);
}

@DeleteMapping(value="delete/{cid}")
public String deleteCab(@PathVariable("cid") int cid) {
	return cabService.deleteCab(cid);
}

@PutMapping(value = "update",consumes = MediaType.APPLICATION_JSON_VALUE)
public String updateCab(@RequestBody Cab cab) {
	return cabService.updateCab(cab);
}

@GetMapping(value="search/{cid}")
public String searchCab(@PathVariable("cid") int cid) {
	return cabService.findCab(cid);
}

@GetMapping(value="search/allCabs",produces = MediaType.APPLICATION_JSON_VALUE)
public List<Cab> findAllCabs() {
	return cabService.findAllCabs();
}

@GetMapping(value="search/type/{type}",produces = MediaType.APPLICATION_JSON_VALUE)
public Cab findCabsByType(@PathVariable("type") String type) {
	return cabService.findCabsByType(type);
}
}
