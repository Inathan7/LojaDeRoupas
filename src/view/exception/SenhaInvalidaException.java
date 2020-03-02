package view.exception;

public class SenhaInvalidaException extends Exception{

	public String getMessage(){
		return "Senha inválida, a senha tem que ter 3 letras e 1 número pelo menos";
	}
}
