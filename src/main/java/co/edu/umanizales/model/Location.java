package co.edu.umanizales.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String codigoDepartamento;
    private String nombreDepartamento;
    private String codigoMunicipio;
    private String nombreMunicipio;
}


