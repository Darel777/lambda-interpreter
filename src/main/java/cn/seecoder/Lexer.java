package cn.seecoder;

public class Lexer{

    public String source;
    public int index;
    public TokenType token;
    public String tokenvalue;

    public Lexer(String s){
        index = 0;
        source = s;
        nextToken();
    }
    //get next token
    private TokenType nextToken(){
        char c;
        do {
            c=nextChar();
        } while(c==' ');
        switch(c) {
            case'\\':
                System.out.println(TokenType.LAMBDA);
                token=TokenType.LAMBDA;
                return TokenType.LAMBDA;
            case'(':
                System.out.println(TokenType.LPAREN);
                token=TokenType.LPAREN;
                return TokenType.LPAREN;
            case')':
                System.out.println(TokenType.RPAREN);
                token=TokenType.RPAREN;
                return TokenType.RPAREN;
            case'.':
                System.out.println(TokenType.DOT);
                token=TokenType.DOT;
                return TokenType.DOT;
            case'\0':
                System.out.println(TokenType.EOF);
                token=TokenType.EOF;
                return TokenType.EOF;
            default:
                if(c<='z'&&c>='a') {
                    String str="";
                    do {
                        str+=c;
                        c=nextChar();
                    }while((c<='z'&&c>='a')||(c<='Z'&&c>='A'));
                    index--;
                    tokenvalue=str;
                    System.out.println(TokenType.LCID);
                    token=TokenType.LCID;
                    return TokenType.LCID;
                }
        }
        return null;
    }
    // get next char
    private char nextChar(){
        //write your code here
        if(index>=source.length()) {
            index++;
            return '\0';
        }
        return source.charAt(index++);
    }

    //check token == t
    public boolean next(TokenType t){
        return token==t;
    }

    //assert matching the token type, and move next token
    public void match(TokenType t){
        if(next(t)) {
            nextToken();
        }
    }

    //skip token  and move next token
    public boolean skip(TokenType t){
        //write your code here
        if(next(t)) {
            nextToken();
            return true;
        }
        return false;
    }


}

