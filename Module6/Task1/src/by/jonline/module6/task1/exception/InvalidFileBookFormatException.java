package by.jonline.module6.task1.exception;

public class InvalidFileBookFormatException extends Exception {
	public InvalidFileBookFormatException() {
	}

	public InvalidFileBookFormatException(String message) {
		super(message);
	}

	public InvalidFileBookFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFileBookFormatException(Throwable cause) {
		super(cause);
	}
}
