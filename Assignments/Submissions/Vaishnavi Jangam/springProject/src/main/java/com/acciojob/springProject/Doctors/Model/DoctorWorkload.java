package com.acciojob.springProject.Doctors.Model;

public class DoctorWorkload {
    private long doctorId;
    private String doctorName;
    private int patientCount;

    public DoctorWorkload(long doctorId, String doctorName, int  patientCount) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.patientCount = patientCount;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public int getPatientCount() {
        return patientCount;
    }

}
