package by.jonline.module6.task1.exception;

public class InvalidFileBookIdFormatException extends Exception{

	public InvalidFileBookIdFormatException() {
	}

	public InvalidFileBookIdFormatException(String message) {
		super(message);
	}

	public InvalidFileBookIdFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFileBookIdFormatException(Throwable cause) {
		super(cause);
	}
}
