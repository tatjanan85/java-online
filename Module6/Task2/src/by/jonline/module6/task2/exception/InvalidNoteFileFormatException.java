package by.jonline.module6.task2.exception;

public class InvalidNoteFileFormatException extends Exception{

	public InvalidNoteFileFormatException() {
	}

	public InvalidNoteFileFormatException(String message) {
		super(message);
	}

	public InvalidNoteFileFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidNoteFileFormatException(Throwable cause) {
		super(cause);
	}
}
