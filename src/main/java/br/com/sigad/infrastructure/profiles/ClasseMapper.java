package br.com.sigad.infrastructure.profiles;

import br.com.sigad.domain.dto.input.ClasseForm;
import br.com.sigad.domain.dto.output.ClasseViewDto;
import br.com.sigad.domain.model.document.DocumentClass;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ClasseMapper {
    DocumentClass formToClasse(ClasseForm classeForm);
    ClasseViewDto classeToView(DocumentClass classe);
    void updateClasse(@MappingTarget DocumentClass destination, DocumentClass source);
}