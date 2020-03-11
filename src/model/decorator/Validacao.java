package model.decorator;

import view.exception.EmailInvalidoException;
import view.exception.SenhaInvalidaException;

public abstract class Validacao {

	public abstract boolean validacaoPadrao(String entradaParaValidar);
	
	public abstract boolean validarEmail(String entradaParaValidar)throws EmailInvalidoException;
	
	public abstract boolean validarSenha(String entradaParaValidar)throws SenhaInvalidaException;
}
