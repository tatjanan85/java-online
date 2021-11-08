package by.jonline.module6.task1.exception;

public class InvalidFileUserFormatException extends Exception{

	public InvalidFileUserFormatException() {
	}

	public InvalidFileUserFormatException(String message) {
		super(message);
	}

	public InvalidFileUserFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFileUserFormatException(Throwable cause) {
		super(cause);
	}
}
