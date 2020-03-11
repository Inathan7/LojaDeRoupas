package model.decorator;

import view.exception.EmailInvalidoException;

public class ValidacaoEmailDecorator extends DecoratorValidacao{

	public ValidacaoEmailDecorator(Validacao validacao) {
		super(validacao);
	}
	
	/**
	 * M�TODO PARA VALIDAR EMAIL
	 * @param entradaParaValidar: texto passado para validar se o email � v�lido 
	 * @return: retorna um true se o email � v�lido e se n�o lan�a uma exce��o
	 * @throws EmailInvalidoException: � uma exce��o criada para lan�ar um erro caso o email n�o sera v�lido
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
