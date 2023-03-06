package br.com.sigad.util;

import br.com.sigad.model.enums.GrauSigilo;
import br.com.sigad.model.util.DropdownOption;

import java.util.Arrays;
import java.util.List;

public class Dropdown {

    public static <E extends Enum<E>> void addEnumsOptions(
            List<DropdownOption> options,
            E[] enums) {

        Arrays.stream(enums)
                .map(e -> new DropdownOption(parseEnumText(e.name())))
                .forEach(options::add);
    }

    private static String parseEnumText(String enumText) {
        String first = enumText.substring(0, 1);
        String end = enumText.substring(1, enumText.length()).toLowerCase();
        return first.concat(end);
    }

}
