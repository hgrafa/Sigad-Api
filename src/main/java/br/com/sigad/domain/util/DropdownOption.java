package br.com.sigad.domain.util;

import br.com.sigad.domain.interfaces.EnumWithText;

public record DropdownOption(
        String value,
        String text
) {

//    public <E extends Enum<E> & EnumWithText> DropdownOption(E myEnum) {
//        this(myEnum.getAbsoluteText(),  myEnum.getParsedText());
//    }
}