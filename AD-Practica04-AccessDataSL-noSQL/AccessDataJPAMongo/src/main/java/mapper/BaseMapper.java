package mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Estructura de los mapper
 * @author Dylan & Emilio
 * @verion 1.0 03/02/2022
 */
public abstract class BaseMapper<T, DTO> {
    public Optional<List<T>> fromDTO(List<DTO> items) {
        // hace falta meter cosas al dto
        return Optional.of(items.stream().map(this::fromDTO).collect(Collectors.toList()));
    }

    public abstract T fromDTO(DTO item);

    public Optional<List<DTO>> toDTO(Optional<List<T>> items) {
        //falta dto
            return Optional.of(items.get().stream().map(this::toDTO).collect(Collectors.toList()));

    }

    public abstract DTO toDTO(T item);
}

