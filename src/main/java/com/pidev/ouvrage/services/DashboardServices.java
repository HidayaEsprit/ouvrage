package com.pidev.ouvrage.services;

import java.util.ArrayList;
import java.util.List;

import com.pidev.ouvrage.model.DAOUser;
import com.pidev.ouvrage.model.Ouvrage;
import com.pidev.ouvrage.repository.DashboardRepository;
import com.pidev.ouvrage.repository.UserRepository;
import com.pidev.ouvrage.services.dto.DTODashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServices {

	@Autowired
    DashboardRepository dashboardRepository;
    
    private final PanierServices panierServices;
	private final OuvrageServices ouvrageServices ; 
	private final UserRepository userRepository ; 

    public DashboardServices(PanierServices panierServices , OuvrageServices ouvrageServices , UserRepository userRepository){
		this.panierServices = panierServices;
		this.ouvrageServices = ouvrageServices;
		this.userRepository = userRepository ;
	}

    public List<String> getCommandeByUserAndMois(){
		List<String> list_user_active = new ArrayList<>();
		List<DAOUser> users = userRepository.findAll();
		// System.out.println("*************************");
		// System.out.println(users);
		for (DAOUser user : users) {
			// Integer result = CommandeRepository.findCommandeByUserAndMois(user.getId());
			Integer result = dashboardRepository.findCommandeByUserAndMois(user);
			System.out.println("--------------------------");
			System.out.println(result);
			if (result>= 2){
				System.out.println("=================== result 2");
				list_user_active.add(user.getUsername());
			}
		};
		System.out.println("===================");
		System.out.println(list_user_active);
		return list_user_active;
		
	}

	public Integer findUsersByMonth(){
		
		// find User By Month ,  fi kol chhar 9adeh men user yetzed li site mte3na 

		Integer result = dashboardRepository.findUsersByMonth();
		System.out.println("===================");
		System.out.println(result);	
		return result;

	}

	public Integer findUsersByYEAR(){
		
		// find User By 3am ,  fi kol 3am 9adeh men user yetzed li site mte3na 

		Integer result = dashboardRepository.findUsersByYEAR();
		System.out.println("===================");
		System.out.println(result);	
		return result;

	}


	public Integer findOuvrageByYEAR(){
		
		// find ouvrage By 3am ,  fi kol 3am 9adeh men ouvrage yetzed li site mte3na 
		Integer result = dashboardRepository.findOuvrageByYEAR();
		System.out.println("===================");
		System.out.println(result);	
		return result;

	}

	public Integer countOuvrage(){
		
		// find ouvrage By 3am ,  fi kol 3am 9adeh men ouvrage yetzed li site mte3na 
		Integer result = dashboardRepository.countOuvrage();
		System.out.println("===================");
		System.out.println(result);	
		return result;

	}

	public Ouvrage listOuvrageActive(){
		
		// find ouvrage By 3am ,  fi kol 3am 9adeh men ouvrage yetzed li site mte3na 
		ArrayList<Ouvrage> listOuvrages = dashboardRepository.findOuvrageByMonth();
		int result = 0;
		Ouvrage ouvrage = new Ouvrage();;
		for(Ouvrage o : listOuvrages){
			int stockInt = o.getInitStock() ;
			int stockCourant = o.getQteStock() ; 
			int stock = stockInt - stockCourant ;
			if (stock>result){
				result =stock ; 
				ouvrage = o ;
			}

		}
		System.out.println("===================");
		System.out.println(ouvrage);	
		return ouvrage;

	}

	public DTODashboard getDashboard(){
		
		Integer nbrOuvrages = countOuvrage() ;
		Ouvrage bestSellingBook = listOuvrageActive();
		Integer newBooksOnTheSiteInThisYear = findOuvrageByYEAR();
		Integer numOfUsersSubscribedToTheSiteInThisMonth = findUsersByMonth();
		Integer numOfUsersSubscribedToTheSiteInThisYear = findUsersByYEAR();
		List<String> theMostActiveUsers = getCommandeByUserAndMois();

		DTODashboard dashboard = new DTODashboard(nbrOuvrages,bestSellingBook,newBooksOnTheSiteInThisYear,
		numOfUsersSubscribedToTheSiteInThisMonth,numOfUsersSubscribedToTheSiteInThisYear,theMostActiveUsers);
		
		return dashboard ;
	}
}
