package br.com.sigad.domain.enums;

import lombok.Getter;

public enum EventosGerenciamento {

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

	private String text;

	EventosGerenciamento(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
