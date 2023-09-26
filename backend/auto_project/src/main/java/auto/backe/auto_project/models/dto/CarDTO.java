package auto.backe.auto_project.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String color;
    private int performance;
    private int consumption;
    private boolean isActive;
}
