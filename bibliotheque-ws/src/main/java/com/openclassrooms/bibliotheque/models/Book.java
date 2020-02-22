package com.openclassrooms.bibliotheque.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_BOOK")
public class Book implements Serializable {

    @Id
    @Column(name = "BOOK_ID")
    private Long id;
    @Column(name = "BOOK_AVAILABLE")
    private boolean available;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", available=" + available +
                '}';
    }
}
