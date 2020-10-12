package exceptions;

public class ClientException extends Exception{

	private String msg;

	public ClientException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}

}
