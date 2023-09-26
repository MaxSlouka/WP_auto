package auto.backe.auto_project.models.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturerDTO {
    private String name;
    private String country;
    private String city;
    private String address;
    private int psc;
}
