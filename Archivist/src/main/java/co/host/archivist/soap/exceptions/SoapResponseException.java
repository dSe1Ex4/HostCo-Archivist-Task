package co.host.archivist.soap.exceptions;

/**
 * Исключение при неудачной попытке получить объект User
 */
public class SoapResponseException extends RuntimeException {
    public SoapResponseException(String message) {
        super(message);
    }
}
