package model;

import java.io.Serializable;

/**
 * Data definition.
 * 
 * This file was generated by Ignite Web Console (07/01/2018, 15:17)
 **/
public class Data implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for avgW. */
    private Double avgW;

    /** Value for avgV. */
    private Double avgV;

    /** Value for sensor_id. */
    private String sensor_id;

    /** Value for granularity. */
    private String granularity;

    /** Value for TS. */
    private Double TS;

    /** Empty constructor. **/
    public Data() {
        // No-op.
    }

    /** Full constructor. **/
    public Data(Double avgW,
        Double avgV,
        String sensor_id,
        String granularity,
        Double TS) {
        this.avgW = avgW;
        this.avgV = avgV;
        this.sensor_id = sensor_id;
        this.granularity = granularity;
        this.TS = TS;
    }

    /**
     * Gets avgW
     * 
     * @return Value for avgW.
     **/
    public Double getAvgW() {
        return avgW;
    }

    /**
     * Sets avgW
     * 
     * @param avgW New value for avgW.
     **/
    public void setAvgW(Double avgW) {
        this.avgW = avgW;
    }

    /**
     * Gets avgV
     * 
     * @return Value for avgV.
     **/
    public Double getAvgV() {
        return avgV;
    }

    /**
     * Sets avgV
     * 
     * @param avgV New value for avgV.
     **/
    public void setAvgV(Double avgV) {
        this.avgV = avgV;
    }

    /**
     * Gets sensor_id
     * 
     * @return Value for sensor_id.
     **/
    public String getSensor_id() {
        return sensor_id;
    }

    /**
     * Sets sensor_id
     * 
     * @param sensor_id New value for sensor_id.
     **/
    public void setSensor_id(String sensor_id) {
        this.sensor_id = sensor_id;
    }

    /**
     * Gets granularity
     * 
     * @return Value for granularity.
     **/
    public String getGranularity() {
        return granularity;
    }

    /**
     * Sets granularity
     * 
     * @param granularity New value for granularity.
     **/
    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    /**
     * Gets TS
     * 
     * @return Value for TS.
     **/
    public Double getTS() {
        return TS;
    }

    /**
     * Sets TS
     * 
     * @param TS New value for TS.
     **/
    public void setTS(Double TS) {
        this.TS = TS;
    }

    /** {@inheritDoc} **/
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!(o instanceof Data))
            return false;
        
        Data that = (Data)o;

        if (avgW != null ? !avgW.equals(that.avgW) : that.avgW != null)
            return false;
        

        if (avgV != null ? !avgV.equals(that.avgV) : that.avgV != null)
            return false;
        

        if (sensor_id != null ? !sensor_id.equals(that.sensor_id) : that.sensor_id != null)
            return false;
        

        if (granularity != null ? !granularity.equals(that.granularity) : that.granularity != null)
            return false;
        

        if (TS != null ? !TS.equals(that.TS) : that.TS != null)
            return false;
        
        return true;
    }

    /** {@inheritDoc} **/
    @Override public int hashCode() {
        int res = avgW != null ? avgW.hashCode() : 0;

        res = 31 * res + (avgV != null ? avgV.hashCode() : 0);

        res = 31 * res + (sensor_id != null ? sensor_id.hashCode() : 0);

        res = 31 * res + (granularity != null ? granularity.hashCode() : 0);

        res = 31 * res + (TS != null ? TS.hashCode() : 0);

        return res;
    }

    /** {@inheritDoc} **/
    @Override public String toString() {
        return "Data [" + 
            "avgW=" + avgW + ", " + 
            "avgV=" + avgV + ", " + 
            "sensor_id=" + sensor_id + ", " + 
            "granularity=" + granularity + ", " + 
            "TS=" + TS +
        "]";
    }
}