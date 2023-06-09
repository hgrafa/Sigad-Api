package br.com.sigad.infrastructure.profiles;

import br.com.sigad.domain.dto.input.ClasseForm;
import br.com.sigad.domain.dto.output.ClasseViewDto;
import br.com.sigad.domain.model.Classe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClasseMapper {
    Classe formToClasse(ClasseForm classeForm);
    ClasseViewDto classeToView(Classe classe);
    void updateClasse(@MappingTarget Classe destination, Classe source);
}