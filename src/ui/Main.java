package ui;
import java.util.*;
import model.Tree;

public class Main {

    private int cont;

    private Scanner read;
    private Tree table;

    public Main(){
        read= new Scanner(System.in);
        table= new Tree();
        cont=1;
    }

    public static void main(String[] args) {
            Main a= new Main();
            int option=0;
        do {
            option=a.menu();
            a.showMenu(option);
        }while(option!=0);

    }

    public int menu(){
        System.out.println("******************\n"+
                           "Registro Dane\n"+
                           "******************");
        System.out.println("1: inscribir ciudadano\n"+
                "2: consultar por cedula\n"+
                "3: eliminar ciudadano por cedula\n"+
                "0: salir");
        int option= read.nextInt();

        return option;
    }

    public void showMenu(int option){
        switch (option){
            case 1:
                RegisterPerson();
                break;
            case 2:
                consult();
                break;
            case 3:
                deletePerson();
                break;
            case 0:
                break;
            default:
                break;
        }
    }

    public void RegisterPerson(){
        System.out.println("ingresa cedula de la persona");
        int cedula= read.nextInt();
        System.out.println("ingrese nombre completo");
        read.nextLine();
        String name= read.nextLine();
        System.out.println("ingrese fecha de nacimiento en el siguiente formato dd/mm/aa");
        String born= read.nextLine();
        System.out.println("ingrese ciudad de nacimiento");
        String city= read.nextLine();
        table.insert(cedula,name,born,city);

    }

    public void consult(){
        System.out.println("ingrese su cedula");
        int cedula= read.nextInt();
        if(table.search(cedula,cont)==null){
            System.out.println("no existe");
        }else{


        }

        cont=1;
    }

    public void deletePerson(){
        System.out.println("ingrese cedula");
        int cedula= read.nextInt();
        if(table.delete(cedula)==null){

        }else{
            System.out.println("eliminado");
        }


    }

}
