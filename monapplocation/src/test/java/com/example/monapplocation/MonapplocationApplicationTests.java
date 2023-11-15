package com.example.monapplocation;

import com.example.monapplocation.model.CommunityManager;
import com.example.monapplocation.repository.CommunityManagerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class MonapplocationApplicationTests {

	@Autowired
	private CommunityManagerRepository communityManagerRepository;

	@Test
		public void createCommunityManager(){

		var communityManager = CommunityManager.builder()
				.nom("Doss").prenom("Judi").email("jude@gmail.com")
				.password("silence").build();
		communityManagerRepository.save(communityManager); //test de la création d'un objet CM
	}

	@Test
	public void testFindCommunityManager()
	{ CommunityManager cm = communityManagerRepository.findById(1).get();
		System.out.println(cm);
	}

	/*@Test
	public void testFindCommunityManager(){
		CommunityManager cm = communityManagerRepository.findById(1).get();
		System.out.println(cm);
	}*/


	/*@Test
	public void testAllCommunityManager(){
		CommunityManager cm = (CommunityManager) communityManagerRepository.findAll();
		System.out.println(cm);
	}*/

    /*@Test
	public void testUpdate(){
		CommunityManager cm = communityManagerRepository.findById(1).get();
		cm.setPrenom("vignon");
		communityManagerRepository.save(cm);
		System.out.println(cm);
	}*/
}
