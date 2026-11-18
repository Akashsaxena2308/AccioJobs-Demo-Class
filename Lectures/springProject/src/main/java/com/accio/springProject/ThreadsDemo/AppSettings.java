package com.accio.springProject.ThreadsDemo;

public class AppSettings {
    private static AppSettings instance;
    private AppSettings(){

    }

    public static synchronized AppSettings getInstance(){

        if(instance == null){
            instance = new AppSettings();
        }

        return instance;
//        new AppSettings()
    }

//    private static class Holder {
//        private static final AppSettings INSTANCE = new AppSettings();
//    }
//
//    public static AppSettings getInstance() {
//        return Holder.INSTANCE;
//    }

}
//App settings --> Object --> Singleton --> One instance per java application

//Object creation --> Restriction ---> Constructor

//Issue --> First time object