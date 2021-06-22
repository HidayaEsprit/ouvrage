package com.pidev.ouvrage.model;

import javax.persistence.*;

@Entity
@Table(name = "ouvrage")
public class Ouvrage {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@Column
    private String ref;
    

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

}
