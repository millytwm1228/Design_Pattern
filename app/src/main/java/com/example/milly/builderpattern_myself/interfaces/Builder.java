package com.example.milly.builderpattern_myself.interfaces;



/**
 * Created by milly on 2017/8/17.
 */

public abstract class Builder {
    public abstract Builder makeTitle(String title);
    public abstract Builder makeString(String str);
    public abstract Builder makeItems(String[] items);
    public abstract Object getResult();
}