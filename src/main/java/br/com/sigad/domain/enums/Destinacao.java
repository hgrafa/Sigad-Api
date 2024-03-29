package br.com.sigad.domain.enums;

import br.com.sigad.domain.interfaces.EnumWithText;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Destinacao implements EnumWithText {

	RECOLHIMENTO("Recolhimento"),
	ELIMINACAO("Eliminação");

	private String absoluteText;
	private String parsedText;

	Destinacao(String text) {
		this.parsedText = text;
		this.absoluteText = text.replaceAll(" ", "_").toUpperCase();
	}

}
