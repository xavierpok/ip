package commandhandling;

import exceptions.syntax.KniazInvalidArgsException;
import exceptions.syntax.KniazInvalidCommandException;
import main.KniazSession;

/**
 * Handles invalid commands, by throwing an exception when it is attempted to be executed
 */
public class InvalidHandler implements  CommandHandler{
    /**
     * Handles invalid commands by throwing an exception
     * @param session the linked KniazSession that this command is to execute in
     * @param args the arguments to this command
     * @return nothing, should always throw an exception
     * @throws KniazInvalidCommandException when this is executed (i.e. always)
     */
    @Override
    public String handle(KniazSession session, String[] args) throws KniazInvalidCommandException {
        throw new KniazInvalidCommandException();
        //What's inside the box? Surprise! It's an exception!
    }
}
