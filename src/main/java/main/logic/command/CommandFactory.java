package main.logic.command;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import main.logic.handler.CommandHandler;
import main.logic.handler.DeadlineHandler;
import main.logic.handler.DeleteHandler;
import main.logic.handler.EventHandler;
import main.logic.handler.FindHandler;
import main.logic.handler.InvalidHandler;
import main.logic.handler.ListHandler;
import main.logic.handler.MarkHandler;
import main.logic.handler.QuitHandler;
import main.logic.handler.ToDoHandler;
import main.logic.handler.UnmarkHandler;
import ui.inputparser.InstructionType;


/**
 * Class encapsulating a command given to Kniaz, should only be instantiated via KniazParser when it parses a command
 */
public abstract class CommandFactory {
    private static final EnumMap<InstructionType, CommandHandler> INSTRUCT_TO_HANDLER =
            new EnumMap<>(Map.of(
                    InstructionType.TODO, new ToDoHandler(),
                    InstructionType.DEADLINE, new DeadlineHandler(),
                    InstructionType.EVENT, new EventHandler(),
                    InstructionType.MARK, new MarkHandler(),
                    InstructionType.UNMARK, new UnmarkHandler(),
                    InstructionType.LIST, new ListHandler(),
                    InstructionType.QUIT, new QuitHandler(),
                    InstructionType.DELETE, new DeleteHandler(),
                    InstructionType.FIND, new FindHandler(),
                    InstructionType.INVALID, new InvalidHandler()
            ));

    /**
     * Makes a new KniazCommand from the provided instruction and arguments
     * @param instruction the instruction type the command is to have
     * @param unnamedArgs the unnamed arguments supplied to the commmand
     * @param namedArgs the named arguments supplied to the command
     * @return the KniazCommand encapsulating the instruction + arguments
     */
    public static KniazCommand makeCommand(InstructionType instruction,
                                           List<String> unnamedArgs,
                                           Map<? extends String, ? extends String> namedArgs) {
        CommandHandler handler = INSTRUCT_TO_HANDLER.getOrDefault(instruction, new InvalidHandler());

        return new KniazCommand(instruction, handler, unnamedArgs, namedArgs);

        // Guaranteed at this point command is valid





    }


}