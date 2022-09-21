
package cn.seecoder;
public class Application extends AST{
    AST lhs;//左树
    AST rhs;//右树

    Application(AST l, AST s){
        lhs = l;
        rhs = s;
    }
    public String toString(){
        if(lhs==null) return rhs.toString();
        else if(rhs==null) return lhs.toString();
        else if(lhs!=null&&rhs!=null) return "("+lhs.toString()+" "+rhs.toString()+")";
        return null;
    }
}

