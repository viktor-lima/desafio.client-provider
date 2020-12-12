package exceptions;

public class ProviderException extends Exception{

	private String msg;

	public ProviderException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
