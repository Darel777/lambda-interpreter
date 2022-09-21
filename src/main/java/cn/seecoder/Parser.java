package cn.seecoder;

import java.util.ArrayList;

public class Parser {
    Lexer lexer;

    public Parser(Lexer l){
        lexer = l;
    }

    public AST parse(){
        AST ast = term(new ArrayList<>());
        //lexer.match(TokenType.EOF);
        return ast;

    }

    private AST term(ArrayList<String> ctx){
        // write your code here
        if(lexer.skip(TokenType.LAMBDA)){
            String id=lexer.tokenvalue;
            lexer.match(TokenType.LCID);
            lexer.match(TokenType.DOT);
            ArrayList<String> tempctx=new ArrayList<String>();
            tempctx.add(id);
            tempctx.addAll(ctx);
            AST term=term(tempctx);
            return new Abstraction(id,term);
        }
        else {
            return application(ctx);
        }
    }

    private AST application(ArrayList<String> ctx){
        // write your code here
        AST lhs=atom(ctx);
        while(true) {
            AST rhs=atom(ctx);
            if(rhs==null) {
                return lhs;
            }
            else {
                lhs=new Application(lhs,rhs);
            }
        }
    }
    private AST atom(ArrayList<String> ctx){
        // write your code here
        if(lexer.skip(TokenType.LPAREN)) {
            AST term=term(ctx);
            if(lexer.skip(TokenType.RPAREN))
                return term;
        }
        else if(lexer.next(TokenType.LCID)) {
            String id=lexer.tokenvalue;
            lexer.match(TokenType.LCID);
            return new Identifier(id,ctx.indexOf(id));
        }
        return null;
    }
}
