package dto;

import dao.JefeDepartamento;
import dao.Programador;
import dao.Proyecto;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO de Departamento
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
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

    /**
     * toString modificado para mostrar la información de los departamentos
     * @return String
     */
    public String getDepartamentoCompleto(){
        return "Departamento{id="+this.id
                +", \nnombre="+this.nombre
                +", \njefe="+this.jefeDepartamento
                +", \npresupuesto="+this.presupuesto
                +", \npresupuesto_anual="+this.presupuestoAnual
                +", \nproyectos_desarrollo="+proyDesarrollo
                +", \nproyectos_finalizados="+proyFinalizados
                +", \nprogramadores="+ programadores
                +"}";
    }
}
