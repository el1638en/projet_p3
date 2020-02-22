package com.openclassrooms.bibliotheque.models;

import com.openclassrooms.bibliotheque.ws.BorrowWs;

import java.util.List;

public class SearchMember {

    private String name;

    private String mailAdress;

    private List<BorrowWs> borrowList;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getMailAdress() {

        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {

        this.mailAdress = mailAdress;
    }

    public List<BorrowWs> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<BorrowWs> borrowList) {

        this.borrowList = borrowList;
    }
}

