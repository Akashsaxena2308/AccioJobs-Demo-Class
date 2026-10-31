package com.accio.springProject.Doctors.Model;

public class RebalanceResult {
    private final boolean moved;
    private final String message;
    private final Long patientId;
    private final Long fromDoctorId;
    private final Long toDoctorId;
    public RebalanceResult(boolean moved, String message,
            Long patientId, Long fromDoctorId, Long toDoctorId) {
        this.moved = moved;
        this.message = message;
        this.patientId = patientId;
        this.fromDoctorId = fromDoctorId;
        this.toDoctorId = toDoctorId;
    }
    public boolean isMoved() { return moved; }
    public String getMessage() { return message; }
    public Long getPatientId() { return patientId; }
    public Long getFromDoctorId() { return fromDoctorId; }
    public Long getToDoctorId() { return toDoctorId; }
}
