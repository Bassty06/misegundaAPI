package co.edu.umanizales.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    private String cedula;
    private String nombres;
    private String apellidos;
    private String sexo;
    private int edad;
    private String ciudad;
}


