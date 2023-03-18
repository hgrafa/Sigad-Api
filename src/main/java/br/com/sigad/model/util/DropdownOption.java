package br.com.sigad.model.util;

public record DropdownOption(
        String value,
        String text
) {

    public DropdownOption(String sharedValue) {
        this(sharedValue, sharedValue);
    }

}