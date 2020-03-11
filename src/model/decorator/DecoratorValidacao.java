package model.decorator;
import view.exception.EmailInvalidoException;
import view.exception.SenhaInvalidaException;

public class DecoratorValidacao extends Validacao{
    private Validacao validacao;
    /**
     * 
     * @param validacao: recebe uma validação
     */
	public DecoratorValidacao(Validacao validacao){
		this.validacao = validacao;
	}
	
	public boolean validacaoPadrao(String entradaParaValidar) {
		return validacao.validacaoPadrao(entradaParaValidar);
	}
	
	public boolean validarEmail(String entradaParaValidar) throws EmailInvalidoException {
		return validacao.validarEmail(entradaParaValidar);
	}
	
	public boolean validarSenha(String entradaParaValidar) throws SenhaInvalidaException {
		return validacao.validarSenha(entradaParaValidar);
	}

	


}

