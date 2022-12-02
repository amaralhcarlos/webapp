package io.github.amaralhcarlos.webapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @ToString.Include
    private String name;

    @ToString.Include
    private String streetName;

    @ToString.Include
    private String streetNumber;

    @ToString.Include
    private String number;

    @ToString.Include
    private String city;

    @ToString.Include
    private String state;

    @ToString.Include
    private String zipCode;

    @ToString.Include
    private String country;

    @OneToMany(fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Book> books = new HashSet<>();

}
