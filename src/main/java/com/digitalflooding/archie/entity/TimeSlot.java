package com.digitalflooding.archie.entity;

public enum TimeSlot {
        SLOT1L("12:00-13:00"),
        SLOT2L("13:00-14:00"),
        SLOT3L("14:00-15:00"),
        SLOT1D("20:00-21:00"),
        SLOT2D("21:00-22:00"),
        SLOT3D("22:00-23:00");

        private final String slot;

        TimeSlot(String slot) {
            this.slot = slot;
        }

        public String getTimeSlot() {
            return this.slot;
        }
    }


}
