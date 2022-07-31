package com.thalasoft.learnintouch.data.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.thalasoft.learnintouch.data.jpa.domain.Admin;
import com.thalasoft.learnintouch.data.jpa.domain.AdminOption;
import com.thalasoft.learnintouch.data.jpa.repository.AdminOptionRepository;
import com.thalasoft.learnintouch.data.jpa.repository.AdminRepository;

public class AdminOptionRepositoryTest extends AbstractRepositoryTest {

	@Autowired 
	AdminRepository adminRepository;

	@Autowired 
	AdminOptionRepository adminOptionRepository;

	private Admin admin0;
	private Admin admin1;
	private AdminOption adminOption0;
	private AdminOption adminOption1;
	private AdminOption adminOption2;
	private List<AdminOption> manyAdminOptions;

	public AdminOptionRepositoryTest() {
		admin0 = new Admin.AdminBuilder("Stephane", "Eybert", "stephane@thalasoft.com", "stephane")
		.setPassword("toto")
        .setPasswordSalt("")
        .build();

		admin1 = new Admin.AdminBuilder("Marc", "Eybert", "marceybert@yahoo.fr", "marc")
		.setPassword("marcus")
        .setPasswordSalt("")
        .build();

		adminOption0 = new AdminOption();
		adminOption0.setAdmin(admin0);
		adminOption0.setName("webpage");

		adminOption1 = new AdminOption();
		adminOption1.setAdmin(admin1);
		adminOption1.setName("elearning");

		adminOption2 = new AdminOption();
		adminOption2.setAdmin(admin1);
		adminOption2.setName("mail");

		manyAdminOptions = new ArrayList<AdminOption>();
		for (int i = 0; i < 40; i++) {
			AdminOption oneAdminOption = new AdminOption();
			String index = intToString(i, 2);
			oneAdminOption.setAdmin(admin1);
			oneAdminOption.setName("option" + index);
			manyAdminOptions.add(oneAdminOption);
		}
	}

	@Before
	public void beforeAnyTest() throws Exception {
		admin0 = adminRepository.saveAndFlush(admin0);
		admin1 = adminRepository.saveAndFlush(admin1);
		adminOption0 = adminOptionRepository.saveAndFlush(adminOption0);
		adminOption1 = adminOptionRepository.saveAndFlush(adminOption1);
		adminOption2 = adminOptionRepository.saveAndFlush(adminOption2);
		for (AdminOption oneAdminOption : manyAdminOptions) {
			oneAdminOption = adminOptionRepository.saveAndFlush(oneAdminOption);
		}
	}

    @After
    public void afterAnyTest() throws Exception {
    	if (null != adminOption0.getId()) {
    		adminOptionRepository.delete(adminOption0.getId());
    	}
    	if (null != adminOption1.getId()) {
    		adminOptionRepository.delete(adminOption1.getId());
    	}
    	if (null != adminOption2.getId()) {
    		adminOptionRepository.delete(adminOption2.getId());
    	}
		for (AdminOption oneAdminOption : manyAdminOptions) {
	    	if (null != oneAdminOption.getId()) {
	    		adminOptionRepository.delete(oneAdminOption.getId());
	    	}
		}
		if (null != admin0.getId()) {
			adminRepository.delete(admin0.getId());
		}
		if (null != admin1.getId()) {
			adminRepository.delete(admin1.getId());
		}
    }

	@Test
	public void testSaveAndRetrieve() {
		assertNotNull(adminOption2.getId());
		adminOption2.setName("myOption");
		AdminOption loadedAdminOption = adminOptionRepository.findOne(adminOption2.getId());
		assertNotNull(loadedAdminOption.getId());
		assertEquals(adminOption2.getAdmin(), loadedAdminOption.getAdmin());
		assertFalse(adminOption2.getName().equals(loadedAdminOption.getName()));
		assertNotSame(adminOption2.hashCode(), 0L);
		assertEquals(adminOption2.hashCode(), loadedAdminOption.hashCode());
		assertFalse(adminOption2.toString().equals(""));
	}
	
	@Test
	public void testDeleteById() {
		AdminOption loadedAdmin = adminOptionRepository.findOne(adminOption0.getId());
		assertNotNull(loadedAdmin);
		loadedAdmin = adminOptionRepository.deleteById(adminOption0.getId());
		loadedAdmin = adminOptionRepository.findOne(adminOption0.getId());
		assertNull(loadedAdmin);
		adminOption0 = adminOptionRepository.saveAndFlush(adminOption0);
		assertNotNull(adminOption0);
	}

	@Test
	public void testFindAll() {
		assertEquals(43, adminOptionRepository.count());
		Pageable pageRequest = new PageRequest(0, 10);
		Page<AdminOption> adminOptions = adminOptionRepository.findAll(pageRequest);
		assertEquals(10, adminOptions.getContent().size());
		assertEquals(adminOption0.getName(), adminOptions.getContent().get(0).getName());
		assertEquals(adminOption1.getName(), adminOptions.getContent().get(1).getName());
		assertEquals(adminOption2.getName(), adminOptions.getContent().get(2).getName());
		assertEquals(manyAdminOptions.get(0).getName(), adminOptions.getContent().get(3).getName());
		pageRequest = new PageRequest(1, 20);
		adminOptions = adminOptionRepository.findAll(pageRequest);
		assertEquals(20, adminOptions.getContent().size());
		assertEquals(manyAdminOptions.get(17).getName(), adminOptions.getContent().get(0).getName());
        assertEquals(manyAdminOptions.get(18).getName(), adminOptions.getContent().get(1).getName());
	}

	@Test
	public void testFindByAdmin() {
		Page<AdminOption> adminOptions = adminOptionRepository.findByAdmin(admin0, new PageRequest(0, 10));
        assertEquals(1, adminOptions.getContent().size());
        assertEquals(adminOption0.getName(), adminOptions.getContent().get(0).getName());
        adminOptions = adminOptionRepository.findByAdmin(admin1, new PageRequest(0, 10));
        assertEquals(10, adminOptions.getContent().size());
        assertEquals(adminOption1.getName(), adminOptions.getContent().get(0).getName());
        assertEquals(adminOption2.getName(), adminOptions.getContent().get(1).getName());
        adminOptions = adminOptionRepository.findByAdmin(admin1, new PageRequest(1, 10));
        assertEquals(manyAdminOptions.get(8).getName(), adminOptions.getContent().get(0).getName());
        assertEquals(manyAdminOptions.get(9).getName(), adminOptions.getContent().get(1).getName());
	}
	
    @Test
    public void testFindByOption() {
        Page<AdminOption> adminOptions = adminOptionRepository.findByName(adminOption0.getName(), new PageRequest(0, 10));
        assertEquals(1, adminOptions.getContent().size());
        assertEquals(adminOption0.getName(), adminOptions.getContent().get(0).getName());
        adminOptions = adminOptionRepository.findByName(adminOption1.getName(), new PageRequest(0, 10));
        assertEquals(1, adminOptions.getContent().size());
        assertEquals(adminOption1.getName(), adminOptions.getContent().get(0).getName());
    }

    @Test
    public void testFindByAdminAndOption() {
        AdminOption adminOption = adminOptionRepository.findByAdminAndName(admin0, adminOption0.getName());
        assertEquals(adminOption0.getName(), adminOption.getName());
        adminOption = adminOptionRepository.findByAdminAndName(admin1, adminOption1.getName());
        assertEquals(adminOption1.getName(), adminOption.getName());
        adminOption = adminOptionRepository.findByAdminAndName(admin1, adminOption0.getName());
        assertNull(adminOption);
    }
	
}