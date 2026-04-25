package com.jdbc.spring.jdbc.repo;

import com.jdbc.spring.jdbc.Models.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo {

  private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

//    private List<Alien> aliens = new ArrayList<>();

//    public void save(Alien alien) {
//
//        String sql = "insert into alien (id,name,tech) values (?,?,?)";
//        template.update(sql,alien.getId(), alien.getName(), alien.getTech());
//    }

    public List<Alien> findAll() {
        String sql = "SELECT * FROM alien";
        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));

                return a;
            }
        };
       List<Alien> aliens = template.query(sql,mapper);
        System.out.println("All Aliens from DB:");
        for (Alien a : aliens) {
            System.out.println(a.getId() + " " + a.getName() + " " + a.getTech());
        }

        return aliens;
    }


    public int save(Alien alien) {
    String sql = "INSERT INTO alien (id, name, tech) VALUES (?, ?, ?)";
    return template.update(sql, alien.getId(), alien.getName(), alien.getTech());
}


public Alien findById(int id) {
    String sql = "SELECT * FROM alien WHERE id = ?";

    RowMapper<Alien> mapper = (rs, rowNum) -> {
        Alien a = new Alien();
        a.setId(rs.getInt("id"));
        a.setName(rs.getString("name"));
        a.setTech(rs.getString("tech"));
        return a;
    };

    return template.queryForObject(sql, mapper, id);
}

public int update(Alien alien) {
    String sql = "UPDATE alien SET name = ?, tech = ? WHERE id = ?";
    return template.update(sql, alien.getName(), alien.getTech(), alien.getId());
}

    }


