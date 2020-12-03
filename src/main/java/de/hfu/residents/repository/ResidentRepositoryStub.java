package de.hfu.residents.repository;

import java.util.ArrayList;
import java.util.List;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository{
	
	private List<Resident> Bewohner=new ArrayList<Resident>();
	
	public void addResident(Resident test) {
		Bewohner.add(test);
	}
	
	@Override
	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		return Bewohner;
	}
	
}