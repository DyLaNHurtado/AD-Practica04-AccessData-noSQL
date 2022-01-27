package dto;

import dao.JefeDepartamento;
import dao.Programador;
import dao.Proyecto;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class DepartamentoDTO {
    private long id;
    private String nombre;
    private JefeDepartamento jefeDepartamento;
    private List<Proyecto> proyFinalizados;
    private List<Proyecto> proyDesarrollo;
    private Double presupuesto;
    private Double presupuestoAnual;
    private List<Programador> programadores;

    @Override
    public String toString(){
        return "Departamento{id="+this.id
                +", nombre="+this.nombre
                +", jefe="+this.jefeDepartamento
                +", presupuesto="+this.presupuesto
                +", presupuesto_anual="+this.presupuestoAnual
                +", proyectos_desarrollo="+proyDesarrollo.stream().map(Proyecto::getId).collect(Collectors.toList())
                +", proyectos_finalizados="+proyFinalizados.stream().map(Proyecto::getId).collect(Collectors.toList())
                +", programadores="+ programadores.stream().map(Programador::getId).collect(Collectors.toList())
                +"}";
    }
}
