package com.udacity.gradle.builditbigger;


/**
 * {@link "https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework"}
 */

class SyncronizeTalker {

    void doNotify() {
        synchronized(this) {
            this.notify();
        }
    }


    void doWait() {
        synchronized(this){
            try {
                this.wait();
            } catch(InterruptedException e) {
            }
        }
    }
}
