package model.decorator;

import view.exception.EmailInvalidoException;

public class ValidacaoEmailDecorator extends DecoratorValidacao{

	public ValidacaoEmailDecorator(Validacao validacao) {
		super(validacao);
	}
	
	/**
	 * MÉTODO PARA VALIDAR EMAIL
	 * @param entradaParaValidar: texto passado para validar se o email é válido 
	 * @return: retorna um true se o email é válido e se não lança uma exceção
	 * @throws EmailInvalidoException: É uma exceção criada para lançar um erro caso o email não sera válido
	 *  
	 */
	public boolean validarEmail(String entradaParaValidar) throws EmailInvalidoException {
		String regex = "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+";
		if(entradaParaValidar.matches(regex)==false){
		   throw new EmailInvalidoException();
		}
		return true;
	}
}
