package model.decorator;

import view.exception.SenhaInvalidaException;

public class ValidacaoSenhaDecorator extends DecoratorValidacao{

	public ValidacaoSenhaDecorator(Validacao validacao) {
		super(validacao);
	}
		
	/**
	 * M�TODO PARA VALIDAR SENHA
	 * @param entradaParaValidar: texto passado pelo cliente para v�lidar a senha de acordo com as regras
	 * @return: retorna true se a senha � v�lida para o sistema, se n�o lan�a uma exce��o de senha inv�lida
	 * @throws SenhaInvalidaException: � uma exce��o criada para quando a senha n�o obedecer as regras do sistema de valida��o
	 *  
	 */
	public boolean validarSenha(String entradaParaValidar) throws SenhaInvalidaException {
		/**
		 * a primeira regra para validar � ter pelo menos 4 caracteres
		 * a segunda regra � ter pelo menos 3 letras
		 * e a terceira � ter pelo menos 1 numero
		 */
		if(entradaParaValidar.length()<4){
			throw new SenhaInvalidaException();
		}else{
			int numeros = 0;
			int letras = 0;
			for(int cont = 0;cont<entradaParaValidar.length();cont++){
				if(Character.isDigit(entradaParaValidar.charAt(cont))==true){
					numeros+=1;
				}if(Character.isLetter(entradaParaValidar.charAt(cont))==true){
					letras+=1;
				}
			}
			if(numeros<1 || letras<3){
				throw new SenhaInvalidaException();
			}
			
		}
		return true;
	}
}
