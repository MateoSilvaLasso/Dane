package model;

import model.Person;

public class Tree {
    private Person root;



    public Tree() {

    }

    public void insert(int cedula, String fullName, String born, String city){
        Person node = new Person(cedula,fullName,born,city);
        if(root == null){
            root = node;
        }else{
            insert(node, root);
        }
    }
    private void insert(Person node, Person current){
        if (node.getCedula() < current.getCedula()) {
            //Izquierda
            if(current.getLeft() != null){
                insert(node, current.getLeft());
            }else{
                current.setLeft(node);
            }
        }
        else if(node.getCedula() > current.getCedula()){
            //Derecha
            if(current.getRight() != null){
                insert(node, current.getRight());
            }else{
                current.setRight(node);
            }
        }else{
            //Igualdad

        }
    }

    public Person search(int cedula, int cont){
        return search(cedula, root, cont);
    }

    private Person search(int goal, Person current, int cont){
        if(current == null){
            ;
            return null;
        }
        if(goal == current.getCedula()){
            System.out.println(current.toString());
            System.out.println(current.toString()
                    +"*****************\n"+
                    cont+" iteraciones");
            return current;
        }
        else if(goal < current.getCedula()){

            return search(goal, current.getLeft(),cont+1);
        } else{

            return search(goal, current.getRight(),cont+1);
        }
    }

    public Person delete(int cedula){
        return delete(cedula, root);
    }

    private Person delete(int goal, Person current){
        if(current == null){
            return null;
        }
        if(current.getCedula() == goal){
            //1. Nodo Hoja
            if(current.getLeft() == null && current.getRight() == null){
                if(current == root){
                    root = null;
                }else{

                }
                return null;
            }
            //2. Nodo solo hijo izquierdo
            else if (current.getRight() == null){
                if(current == root){
                    root = current.getLeft();
                }
                return current.getLeft();
            }
            //3. Nodo solo hijo derecho
            else if(current.getLeft() == null){
                if(current == root){
                    root = current.getRight();
                }
                return current.getRight();
            }
            //4. Nodo con dos hijos
            else{
                Person min = getMin(current.getRight());
                //Transferencia de valores, NUNCA de conexiones
                current.setCedula(min.getCedula());
                current.setFullName(min.getFullName());
                current.setBorn(min.getBorn());
                current.setCity(min.getCity());


                //Hacer eliminación a partir de la derecha
                Person subarbolDER = delete(min.getCedula(), current.getRight());
                current.setRight( subarbolDER );
                return current;
            }


        }else if(goal < current.getCedula()){
            Person subArbolIzquierdo = delete(goal, current.getLeft());
            current.setLeft(subArbolIzquierdo);
            return current;
        }else{
            Person subArbolDerecho = delete(goal, current.getRight());
            current.setRight(subArbolDerecho);
            return current;
        }
    }

    public Person getMin(Person current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }
}
