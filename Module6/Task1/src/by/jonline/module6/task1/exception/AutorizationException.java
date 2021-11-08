package by.jonline.module6.task1.exception;

public class AutorizationException extends  Exception {

	public AutorizationException() {
	}

	public AutorizationException(String message) {
		super(message);
	}

	public AutorizationException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutorizationException(Throwable cause) {
		super(cause);
	}
}
