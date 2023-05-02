package br.com.sigad.domain.enums;

import br.com.sigad.domain.interfaces.EnumWithText;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum IndicadorAtiva implements EnumWithText {

    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String absoluteText;
    private String parsedText;

    IndicadorAtiva(String text) {
        this.parsedText = text;
        this.absoluteText = text.replaceAll(" ", "_").toUpperCase();
    }
}
