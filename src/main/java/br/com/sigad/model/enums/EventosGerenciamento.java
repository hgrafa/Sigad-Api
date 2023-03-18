package br.com.sigad.model.enums;


public enum EventosGerenciamento  {
	// TODO adicionar getter + AllArgs + atributo text

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

	EventosGerenciamento(String string) {
		// TODO Auto-generated constructor stub
	}

	private String text;

}
