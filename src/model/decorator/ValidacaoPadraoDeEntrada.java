package model.decorator;

import view.exception.EmailInvalidoException;
import view.exception.SenhaInvalidaException;

public class ValidacaoPadraoDeEntrada extends Validacao{

	public boolean validacaoPadrao(String entradaParaValidar) {
		if(entradaParaValidar.equals("")){
			return false;
		}
		return true;
	}

	public boolean validarEmail(String entradaParaValidar) throws EmailInvalidoException {
		return false;
	}

	public boolean validarSenha(String entradaParaValidar) throws SenhaInvalidaException {
		return false;
	}
}
