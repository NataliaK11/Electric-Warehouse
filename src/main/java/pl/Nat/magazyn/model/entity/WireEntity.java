package pl.Nat.magazyn.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="wire")
public class WireEntity {
    @Id
    @GeneratedValue
    private int id;
    private String type;
    private double length;

}
