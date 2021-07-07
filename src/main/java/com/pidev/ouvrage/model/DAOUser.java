package com.pidev.ouvrage.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String role;
	  //new column
	  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	  private Set<OuvrageUser> UserOuvrages = new HashSet<>();
	   //new column
	  @OneToMany(mappedBy="user")
	    private Set<Panier> paniers;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<OuvrageUser> getUserOuvrages() {
		return UserOuvrages;
	}

	public void setUserOuvrages(Set<OuvrageUser> userOuvrages) {
		UserOuvrages = userOuvrages;
	}

	public Set<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(Set<Panier> paniers) {
		this.paniers = paniers;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
