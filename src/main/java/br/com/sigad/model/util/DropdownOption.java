package br.com.sigad.model.util;

import br.com.sigad.model.interfaces.EnumWithText;

public record DropdownOption(
        String value,
        String text
) {

    public <E extends Enum<E> & EnumWithText> DropdownOption(E myEnum) {
        this(myEnum.getAbsoluteText(),  myEnum.getParsedText());
    }
}