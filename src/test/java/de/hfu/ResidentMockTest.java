package de.hfu;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResidentMockTest {
	Resident test = new Resident("Dominik", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test1 = new Resident("Eduard", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test2 = new Resident("Vitali", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test3 = new Resident("Katja", "Schäfer", "Goethestrasse 30", "Trossingen", null);
	Resident test4 = new Resident("Hegrid", "Stieb", "Tuninger Strasse 7", "Trossingen", null);
	Resident test5 = new Resident("Helmut", "Kolb", "Keplerstraße 22", "Trossingen", null);
	Resident test6 = new Resident("Herman", "Winter", "Vogesenstrasse 22", "Trossingen", null);
	List<Resident> allResidents = new ArrayList<Resident>();
	List<Resident> SchaeferResidents = new ArrayList<Resident>();
	@Before
	public void init() {
		allResidents.add(test);
		allResidents.add(test1);
		allResidents.add(test2);
		allResidents.add(test3);
		allResidents.add(test4);
		allResidents.add(test5);
		allResidents.add(test6);
		SchaeferResidents.add(test);
		SchaeferResidents.add(test1);
		SchaeferResidents.add(test2);
		SchaeferResidents.add(test3);
		
	}
	@Test
    public void testGetFilteredResidentsList() {
        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);

        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryMock);

        expect(residentRepositoryMock.getResidents()).andReturn(allResidents);
        replay(residentRepositoryMock);

        Resident testFilterResident = new Resident();
        testFilterResident.setFamilyName("Schä*");;

        List<Resident> result = baseResidentService.getFilteredResidentsList(testFilterResident);

        verify(residentRepositoryMock);

        assertThat(result, equalTo(SchaeferResidents));
    }
	 @Test
	 public void testGetUniqueResident() throws ResidentServiceException {
	        ResidentRepository residentRepositoryMock = createMock(ResidentRepository.class);

	        BaseResidentService baseResidentService = new BaseResidentService();
	        baseResidentService.setResidentRepository(residentRepositoryMock);

	        expect(residentRepositoryMock.getResidents()).andReturn(allResidents);
	        replay(residentRepositoryMock);

	        Resident testFilterResident = new Resident();
	        testFilterResident.setGivenName("Dominik");

	        Resident result = baseResidentService.getUniqueResident(testFilterResident);

	        verify(residentRepositoryMock);

	        assertThat(result, equalTo(allResidents.get(0)));
	    }
}