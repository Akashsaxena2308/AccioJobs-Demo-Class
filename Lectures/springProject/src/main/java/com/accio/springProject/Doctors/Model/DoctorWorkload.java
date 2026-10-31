package com.accio.springProject.Doctors.Model;

public class DoctorWorkload {
    private final long doctorId;
    private final String doctorName;
    private final int patientCount;
    public DoctorWorkload(long doctorId, String doctorName, int patientCount) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.patientCount = patientCount;
    }
    public long getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public int getPatientCount() { return patientCount; }
}
