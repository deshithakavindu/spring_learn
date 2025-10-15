package com.jdbc.spring.jdbc.repo;

import com.jdbc.spring.jdbc.Models.Alien;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo {

    private List<Alien> aliens = new ArrayList<>();

    public void save(Alien alien) {
        aliens.add(alien); // ✅ Add alien to the list
        System.out.println(alien.getId()+  " "  + " " + alien.getTech());
    }

    public List<Alien> findall() {
        System.out.println("All Aliens:");

        for (Alien a : aliens) {
            System.out.println(a.getId() + " " + a.getName() + " " + a.getTech());
        }
        return aliens;
    }

    }


