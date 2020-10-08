class Clock {

    int hours = 12;
    int minutes = 0;
    // inspired by: https://hyperskill.org/learn/step/2989#solutions-578337
    void next() {
        if (++minutes == 60) {
            minutes  = 0;
            if (++hours == 13) {
                hours = 1;
            }
        }
    }
}