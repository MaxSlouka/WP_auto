package auto.backe.auto_project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Long manufacturerId;
    private String name;
    private String type;
    private int priceRange;
    private int yearOfProduction;
    private boolean isActive;


}
