package com.pidev.ouvrage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserOuvrageId implements Serializable{
	   
	    @Column(name = "user_id")
	    private long userId;

	    @Column(name = "ouvrage_id")
	    private long ouvrageId;
	    
	    @Column(name = "panier_id")
	    private long panierId;

		public UserOuvrageId() {
			super();
		}

		public UserOuvrageId(long userId, long ouvrageId, long panierId) {
			super();
			this.userId = userId;
			this.ouvrageId = ouvrageId;
			this.panierId = panierId;
		
		}

	

		
	    

}
