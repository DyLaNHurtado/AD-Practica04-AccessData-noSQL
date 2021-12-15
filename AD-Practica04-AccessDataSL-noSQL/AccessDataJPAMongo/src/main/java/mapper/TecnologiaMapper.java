package mapper;

import dao.Tecnologia;
import dto.TecnologiaDTO;

import java.util.Optional;

public class TecnologiaMapper extends BaseMapper<Tecnologia, TecnologiaDTO> {

    @Override
    public Tecnologia fromDTO(TecnologiaDTO item) {
        return Tecnologia.builder()
                .idTecnologia(item.getIdTecnologia())
                .nombre(item.getNombre())
                .build();
    }

    @Override
    public TecnologiaDTO toDTO(Tecnologia item) {
        return TecnologiaDTO.builder()
                .idTecnologia(item.getIdTecnologia())
                .nombre(item.getNombre())
                .build();
    }
}