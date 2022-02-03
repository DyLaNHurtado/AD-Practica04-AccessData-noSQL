package dto;

import dao.Departamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * DTO de JefeDepartamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JefeDepartamentoDTO {
    private long id;
    private String nombre;
    private Timestamp fechaAlta;
    private Double salario;
    private List<String> tecnologias;
    private Departamento departamento;

    @Override
    public String toString(){
        return "JefeDepartamento{id="+this.id
                +", nombre="+this.nombre
                +", fecha="+this.fechaAlta
                +", salario="+this.salario
                +", tecnologias="+this.tecnologias
                +", departamento="+this.departamento.getId()
                +"}";
    }
}
