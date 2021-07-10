package com.pidev.ouvrage.services.dto;

import java.util.List;

import com.pidev.ouvrage.model.Ouvrage;

public class DTODashboard {
    private Integer nbrOuvrages;
    private Ouvrage bestSellingBook;
    private Integer newBooksOnTheSiteInThisYear;
    private Integer numOfUsersSubscribedToTheSiteInThisMonth;
    private Integer numOfUsersSubscribedToTheSiteInThisYear;
    private List<String> theMostActiveUsers;

    public DTODashboard(Integer nbrOuvrages ,Ouvrage bestSellingBook,Integer newBooksOnTheSiteInThisYear,Integer numOfUsersSubscribedToTheSiteInThisMonth,Integer numOfUsersSubscribedToTheSiteInThisYear,
    List<String> theMostActiveUsers
    ){
        this.nbrOuvrages = nbrOuvrages ;
        this.bestSellingBook = bestSellingBook ;
        this.newBooksOnTheSiteInThisYear = newBooksOnTheSiteInThisYear;
        this.numOfUsersSubscribedToTheSiteInThisMonth = numOfUsersSubscribedToTheSiteInThisMonth;
        this.numOfUsersSubscribedToTheSiteInThisYear = numOfUsersSubscribedToTheSiteInThisYear;
        this.theMostActiveUsers = theMostActiveUsers ;
    }

    public DTODashboard(){

    }
    public Integer getNbrOuvrages() {
        return this.nbrOuvrages;
    }

    public void setNbrOuvrages(Integer nbrOuvrages) {
        this.nbrOuvrages = nbrOuvrages;
    }

    public Ouvrage getBestSellingBook() {
        return this.bestSellingBook;
    }

    public void setBestSellingBook(Ouvrage bestSellingBook) {
        this.bestSellingBook = bestSellingBook;
    }

    public Integer getNewBooksOnTheSiteInThisYear() {
        return this.newBooksOnTheSiteInThisYear;
    }

    public void setNewBooksOnTheSiteInThisYear(Integer newBooksOnTheSiteInThisYear) {
        this.newBooksOnTheSiteInThisYear = newBooksOnTheSiteInThisYear;
    }

    public Integer getNumOfUsersSubscribedToTheSiteInThisMonth() {
        return this.numOfUsersSubscribedToTheSiteInThisMonth;
    }

    public void setNumOfUsersSubscribedToTheSiteInThisMonth(Integer numOfUsersSubscribedToTheSiteInThisMonth) {
        this.numOfUsersSubscribedToTheSiteInThisMonth = numOfUsersSubscribedToTheSiteInThisMonth;
    }

    public Integer getNumOfUsersSubscribedToTheSiteInThisYear() {
        return this.numOfUsersSubscribedToTheSiteInThisYear;
    }

    public void setNumOfUsersSubscribedToTheSiteInThisYear(Integer numOfUsersSubscribedToTheSiteInThisYear) {
        this.numOfUsersSubscribedToTheSiteInThisYear = numOfUsersSubscribedToTheSiteInThisYear;
    }

    public List<String> getTheMostActiveUsers() {
        return this.theMostActiveUsers;
    }

    public void setTheMostActiveUsers(List<String> theMostActiveUsers) {
        this.theMostActiveUsers = theMostActiveUsers;
    }
  
}
