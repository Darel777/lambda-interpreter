package cn.seecoder;

public class Identifier extends AST {

    String name; //名字
    int value;//De Bruijn index值

    public Identifier(String n,int v){

        name = n;
        value = v;
    }
    public String toString(){
        return String.valueOf(value);
    }
}