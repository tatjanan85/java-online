package by.jonline.module6.task2.exception;

public class InvalidFileNoteIdFormatException  extends Exception{
	public InvalidFileNoteIdFormatException() {
	}

	public InvalidFileNoteIdFormatException(String message) {
		super(message);
	}

	public InvalidFileNoteIdFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidFileNoteIdFormatException(Throwable cause) {
		super(cause);
	}
}
