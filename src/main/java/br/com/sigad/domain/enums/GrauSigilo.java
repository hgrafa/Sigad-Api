package br.com.sigad.domain.enums;

import br.com.sigad.domain.interfaces.EnumWithText;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum GrauSigilo implements EnumWithText {

	CONFIDENCIAL("Confidencial"),
	RESERVADO("Reservado"),
	SECRETO("Secreto"),
	ULTRA_SECRETO("Ultra Secreto");

	private String absoluteText;
	private String parsedText;

	GrauSigilo(String text) {
		this.parsedText = text;
		this.absoluteText = text.replaceAll(" ", "_").toUpperCase();
	}
}
