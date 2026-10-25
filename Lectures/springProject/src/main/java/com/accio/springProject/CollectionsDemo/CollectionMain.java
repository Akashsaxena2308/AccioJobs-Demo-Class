package com.accio.springProject.CollectionsDemo;

import java.util.*;

public class CollectionMain {

    public static void main(String[] args){

        //Colllections --> Interfaces

        // List --> Arraylist, LinkedList
        //Set --> HashSet, LinkedHashset, ..
        //Queue --> Priority Queue
        //Deque

        //Map --> HashMap, LinkedHashMap,


        List<String> names =  new ArrayList<>(List.of("Jane", "John", "Sam"));

//        for(String name : names){
//            if(name.equals("Sam")){
//                names.remove(name);
////                System.out.println(name);
//            }
////            System.out.println(name);
//        }


//        |I| Sam ||


//                ListIterator<String> iterator = names.iterator();


        int age = 26; //primitive type
        Integer boxed = age; //boxing
        int unboxed = boxed; //unboxing

        System.out.println(unboxed);

//        boxed = null;
//        unboxed = null;


        Box box1 = new Box("String");
        Box box2 = new Box(5);

        Box<String> box3 = new Box<>("String");

        System.out.println(box1.get() + " " + box2.get());


       Set<String> nameList = new HashSet<>();

       nameList.add("John");
       nameList.add("John");

        System.out.println(nameList.size());

        Set<PatientKey> patientKeys = new HashSet<>();

        patientKeys.add(new PatientKey(5));
        patientKeys.add(new PatientKey(5));

        System.out.println(patientKeys.size());

    }
}
