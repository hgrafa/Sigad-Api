package br.com.sigad.model.enums;

import br.com.sigad.model.interfaces.EnumWithText;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EventosGerenciamento implements EnumWithText {

	EGC1("Abertura de classe"),
	EGC2("Desativação de classe"),
	EGC3("Reativação de classe"),
	EGC4("Mudança de classe"),
	EGC5("Deslocamento de classe"),
	EGC6("Extinção de classe"),
	EGC7("Alteração de prazo corrente"),
	EGC8("Alteração de evento corrente"), /*valor anterior do atributo - evento de contagem*/
	EGC9("Alteração de prazo intermediário"),
	EGC10("Alteração de evento intermediário"), /*valor anterior do atributo - evento de contagem*/
	EGC11("Alteração de destinação"),
	EGC12("Alteração de sigilo associado à classe");

	private String absoluteText;
	private String parsedText;

	EventosGerenciamento(String text) {
		this.parsedText = text;
		this.absoluteText = text.replaceAll(" ", "_").toUpperCase();
	}

}
