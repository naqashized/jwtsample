package com.jwtsample.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        })
})
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

}
