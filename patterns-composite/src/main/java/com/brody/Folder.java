package com.brody;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Component{

    List<Component> components =  new ArrayList<>();
    public Folder(String name) {
        super(name);
    }

    @Override
    public void print() {
        String tab = "";
        for(int i =0; i<level; i++){
            tab = tab + "\t";
        }
        //print the current folder
        System.out.println(tab+"Folder :"+name);

        //print his sub folder
        for(Component c: components){
            c.print();
        }
    }

    /**
     * add a folder in a folder
     * @param component
     * @return new component as a sub folder
     */
    public Component addChild(Component component){
        //we define his level
        component.level = this.level + 1;
        this.components.add(component);
        return component;
    }
}
