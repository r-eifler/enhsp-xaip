import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        PddlLexer lex = new PddlLexer(new ANTLRFileStream("/home/enrico/Scrivania/rescueRobot/domain.pddl", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        PddlParser g = new PddlParser(tokens, 49100, null);
        try {
            g.pddlDoc();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}