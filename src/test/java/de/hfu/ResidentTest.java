package de.hfu;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;



public class ResidentTest {
	Resident test = new Resident("Dominik", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test1 = new Resident("Eduard", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test2 = new Resident("Vitali", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test3 = new Resident("Katja", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test4 = new Resident("Hegrid", "Stieb", "Tuninger Strasse 7", "Trossingen", null);
	Resident test5 = new Resident("Helmut", "Kolb", "Keplerstraße 22", "Trossingen", null);
	Resident test6 = new Resident("Herman", "Winter", "Vogesenstrasse 22", "Trossingen", null);
	ResidentRepositoryStub Datenbank = new ResidentRepositoryStub();
	
	@Test
	public void testHeResident(){
		BaseResidentService Service = new BaseResidentService();
		Datenbank.addResident(test);
		Datenbank.addResident(test1);
		Datenbank.addResident(test2);
		Datenbank.addResident(test3);
		Datenbank.addResident(test4);
		Datenbank.addResident(test5);
		Datenbank.addResident(test6);
		Service.setResidentRepository(Datenbank);
		
		List<Resident> HeResidents = new ArrayList<Resident>();
		HeResidents.add(test4);
		HeResidents.add(test5);
		HeResidents.add(test6);
		List<Resident> HeResidentsService= Service.getFilteredResidentsList(new Resident("He*","","","",null));
		
		assertEquals(HeResidents,HeResidentsService);
	}
	@Test
	public void testStreetResidents() {
		BaseResidentService Service = new BaseResidentService();
		Datenbank.addResident(test);
		Datenbank.addResident(test1);
		Datenbank.addResident(test2);
		Datenbank.addResident(test3);
		Datenbank.addResident(test4);
		Datenbank.addResident(test5);
		Datenbank.addResident(test6);
		Service.setResidentRepository(Datenbank);
		
		List<Resident> StreetResidents = new ArrayList<Resident>();
		StreetResidents.add(test);
		StreetResidents.add(test1);
		StreetResidents.add(test2);
		StreetResidents.add(test3);
		List<Resident> StreetResidentsService = Service.getFilteredResidentsList(new Resident(null,null,"Goethestras*",null,null));
		assertEquals(StreetResidents,StreetResidentsService);
	}
	@Test
	public void testCityResidents() {
		BaseResidentService Service = new BaseResidentService();
		Datenbank.addResident(test);
		Datenbank.addResident(test1);
		Datenbank.addResident(test2);
		Datenbank.addResident(test3);
		Datenbank.addResident(test4);
		Datenbank.addResident(test5);
		Datenbank.addResident(test6);
		Service.setResidentRepository(Datenbank);
		
		List<Resident> CityResidents = new ArrayList<Resident>();
		CityResidents.add(test);
		CityResidents.add(test1);
		CityResidents.add(test2);
		CityResidents.add(test3);
		CityResidents.add(test4);
		CityResidents.add(test5);
		CityResidents.add(test6);
		List<Resident> CityResidentsService = Service.getFilteredResidentsList(new Resident(null,null,null,"Trossingen",null));
		
		assertEquals(CityResidents,CityResidentsService);
	}
	@Test
	public void testUniqueResident() {
		BaseResidentService Service = new BaseResidentService();
		Datenbank.addResident(test);
		Datenbank.addResident(test1);
		Datenbank.addResident(test2);
		Datenbank.addResident(test3);
		Datenbank.addResident(test4);
		Datenbank.addResident(test5);
		Datenbank.addResident(test6);
		Service.setResidentRepository(Datenbank);
		
		Resident Dominik = null,Eduard = null,Vitali = null;
		try {
			Dominik =Service.getUniqueResident(new Resident("Dominik",null,null,null,null));
		} catch (ResidentServiceException e) {
			e.printStackTrace();
		}
		assertEquals(test,Dominik);
		try {
			Eduard=Service.getUniqueResident(new Resident("Eduard",null,null,null,null));
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Vitali= Service.getUniqueResident(new Resident("Vitali",null,null,null,null));
		} catch (ResidentServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(test,Dominik);
		assertEquals(test1,Eduard);
		assertEquals(test2,Vitali);
	}

}