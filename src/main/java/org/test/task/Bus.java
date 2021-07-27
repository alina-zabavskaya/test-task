package org.test.task;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Bus implements Comparable<Bus>{
    private String companyName;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private long duration;


    public Bus(String companyName, LocalTime departureTime, LocalTime arrivalTime) {
        this.companyName = companyName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.duration = MINUTES.between(departureTime, arrivalTime);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public int compareTo(Bus o) {
        return (int) MINUTES.between(o.departureTime,this.departureTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        return new EqualsBuilder().append(duration, bus.duration).append(companyName, bus.companyName).append(departureTime, bus.departureTime).append(arrivalTime, bus.arrivalTime).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(companyName).append(departureTime).append(arrivalTime).append(duration).toHashCode();
    }

    @Override
    public String toString() {
        return "org.test.task.Bus{" +
                "companyName='" + companyName + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", duration=" + duration +
                '}';
    }
}
