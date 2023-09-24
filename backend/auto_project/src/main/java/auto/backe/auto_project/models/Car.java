package auto.backe.auto_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Long modelId;
    private String color;
    private int performance;
    private int consumption;
    private int yearOfProduction;
    private boolean isActive;

}
