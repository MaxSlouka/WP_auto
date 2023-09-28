package auto.backe.auto_project.models.dto;

import auto.backe.auto_project.models.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String model;
    private String color;
    private int performance;
    private int consumption;
    private int yearOfProduction;
    private boolean isActive;
}
