package com.accio.springProject.ThreadsDemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class AppSettingsTests {

    // Create 5 threads
    // Create 5 AppSettings object using those threads
    // Assert All threads point to same reference object

    @Test
    void checkAppSettings() throws InterruptedException {

        Thread[] threads = new Thread[5];
        AppSettings[] appSettingsObj = new AppSettings[5];
        for(int index = 0; index < threads.length ; index++){
            final int slot = index;
            threads[index] = new Thread(() ->
                    appSettingsObj[slot] = AppSettings.getInstance());
        }

        for(Thread thread : threads){
            thread.start();
        }

        for(Thread thread : threads){
            thread.join();
        }

        for(AppSettings appSettings : appSettingsObj){
            assertSame(AppSettings.getInstance(), appSettings);
        }
    }

}
