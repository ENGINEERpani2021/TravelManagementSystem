package com.tms.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entity.Cab;
import com.tms.repository.CabRepository;
@Service
public class CabService {
	@Autowired CabRepository cabRepository;
	
	public String addCab(Cab cab) {
		cabRepository.save(cab);
		return "Cab Details recorded successfully!";
	}
	
	public String deleteCab(int cid) {
		if (cabRepository.existsById(cid)) {
			cabRepository.deleteById(cid);
			return "Cab deleted successfully!";
		} else {
			return "No such cab with mentioned id. Please check the cab id!!!";
		}
	}
	
	public String updateCab(Cab cab) {
		Optional<Cab> cabRepo = cabRepository.findById(cab.getCid());
		if (cabRepo.isPresent()) {
			Cab temp = cabRepo.get();
			temp.setSeater(cab.getSeater());
			temp.setBaseFare(cab.getBaseFare());
			temp.setStatus(cab.getStatus());
			cabRepository.saveAndFlush(temp);
			return "Cab updated successfully!";
		} else {
			return "No such cab with mentioned id. Please check the cab id!!!";
		}	
	}
	
	public String findCab(int cid) {
		Optional<Cab> cabRepo = cabRepository.findById(cid);
		if (cabRepo.isPresent()) {
			return cabRepo.get().toString();
		} else {
			return "No such cab with mentioned id. Please check the cab id!!!";
		}
	}

	public List<Cab> findAllCabs() {
		return cabRepository.findAll();
	}
	
	public Cab findCabsByType(String type) {
		Random random = new Random();
		List<Cab> cabList = cabRepository.findAllcabsByType(type);
		if(cabList!=null && cabList.size()>0) {
				return cabList.get(random.nextInt(cabList.size()));
			 // selecting the particular cab 
		}
		else {
			return null;
		}
	}
}
