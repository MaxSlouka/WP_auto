package auto.backe.auto_project.models.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO {
    private String name;
    private String type;
    private int priceRange;
    private int yearOfProduction;
    private boolean isActive;
}
