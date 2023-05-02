package br.com.sigad.domain.enums;

import br.com.sigad.domain.interfaces.EnumWithText;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Permissao implements EnumWithText {
	ESTRUTURA_HIERARQUICA ("Estrutura Hierárquica"),
	TEMPORALIDADE_E_DESTINACAO("Temporalidade e Destinação");

	private String absoluteText;
	private String parsedText;

	Permissao(String text) {
		this.parsedText = text;
		this.absoluteText = text.replaceAll(" ", "_").toUpperCase();
	}
}
