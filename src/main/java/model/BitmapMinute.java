package model;

import java.io.Serializable;

/**
 * BitmapMinute definition.
 * 
 * This file was generated by Ignite Web Console (07/01/2018, 15:17)
 **/
public class BitmapMinute implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for avgW. */
    private String avgW;

    /** Value for avgV. */
    private String avgV;

    /** Value for sensor_id. */
    private String sensor_id;

    /** Empty constructor. **/
    public BitmapMinute() {
        // No-op.
    }

    /** Full constructor. **/
    public BitmapMinute(String avgW,
        String avgV,
        String sensor_id) {
        this.avgW = avgW;
        this.avgV = avgV;
        this.sensor_id = sensor_id;
    }

    /**
     * Gets avgW
     * 
     * @return Value for avgW.
     **/
    public String getAvgW() {
        return avgW;
    }

    /**
     * Sets avgW
     * 
     * @param avgW New value for avgW.
     **/
    public void setAvgW(String avgW) {
        this.avgW = avgW;
    }

    /**
     * Gets avgV
     * 
     * @return Value for avgV.
     **/
    public String getAvgV() {
        return avgV;
    }

    /**
     * Sets avgV
     * 
     * @param avgV New value for avgV.
     **/
    public void setAvgV(String avgV) {
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

    /** {@inheritDoc} **/
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!(o instanceof BitmapMinute))
            return false;
        
        BitmapMinute that = (BitmapMinute)o;

        if (avgW != null ? !avgW.equals(that.avgW) : that.avgW != null)
            return false;
        

        if (avgV != null ? !avgV.equals(that.avgV) : that.avgV != null)
            return false;
        

        if (sensor_id != null ? !sensor_id.equals(that.sensor_id) : that.sensor_id != null)
            return false;
        
        return true;
    }

    /** {@inheritDoc} **/
    @Override public int hashCode() {
        int res = avgW != null ? avgW.hashCode() : 0;

        res = 31 * res + (avgV != null ? avgV.hashCode() : 0);

        res = 31 * res + (sensor_id != null ? sensor_id.hashCode() : 0);

        return res;
    }

    /** {@inheritDoc} **/
    @Override public String toString() {
        return "BitmapMinute [" + 
            "avgW=" + avgW + ", " + 
            "avgV=" + avgV + ", " + 
            "sensor_id=" + sensor_id +
        "]";
    }
}