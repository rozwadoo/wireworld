package mapa;

public class diodeNormal extends structure{
    public diodeNormal( int s){
        setRow(7);
        setColumn(14);
        for(int i = s-42; i < s+56; ++i){
            getBoard().put(i, new cell( 0, i));
        }
        for(int i = s; i < s+7; ++i){
            getBoard().get(i).setState0(3);
            getBoard().get(i).giveN(this);
        }
        for(int i = s+8; i < s+14; ++i){
            getBoard().get(i).setState0(3);
            getBoard().get(i).giveN(this);
        }
        getBoard().get(s-8).setState0(3);
        getBoard().get(s-8).giveN(this);
        getBoard().get(s-7).setState0(3);
        getBoard().get(s-7).giveN(this);
        getBoard().get(s+20).setState0(3);
        getBoard().get(s+20).giveN(this);
        getBoard().get(s+21).setState0(3);
        getBoard().get(s+21).giveN(this);



    }
}
