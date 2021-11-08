package by.jonline.module6.task2.exception;

public class InvalidDataInputException extends Exception{
	public InvalidDataInputException() {
	}

	public InvalidDataInputException(String message) {
		super(message);
	}

	public InvalidDataInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDataInputException(Throwable cause) {
		super(cause);
	}
}
