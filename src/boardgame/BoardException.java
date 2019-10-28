package boardgame;

public class BoardException extends RuntimeException {

    // Repassa a mensagem para o construtor da superclasse(RuntimeExcepion)
    public BoardException(String msg){
        super(msg);
    }
}
