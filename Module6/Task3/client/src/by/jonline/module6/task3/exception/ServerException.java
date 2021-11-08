package by.jonline.module6.task3.exception;

public class ServerException extends Throwable{
	public ServerException() {
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerException(Throwable cause) {
		super(cause);
	}
}
