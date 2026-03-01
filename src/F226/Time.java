package F226;

import java.util.GregorianCalendar;
/**
 * Models military time
 * @author Timothy Le
 */
public class Time 
{
    private int hours;
    private int minutes;
    private int seconds;

    
    /**
     * Constructs custom Time instance
     * 
     * @param hours
     * @param minutes
     * @param second
     */
    public Time(int hours, int minutes, int seconds) 
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    } 
    /**
     * Constructs current time Time instance
     */
    public Time()
    {
        GregorianCalendar gc = new GregorianCalendar();
        this.hours = gc.get(gc.HOUR_OF_DAY);
        this.minutes = gc.get(gc.MINUTE);
        this.seconds = gc.get(gc.SECOND);
    }
    /**
     * @return hour
     */
    public int getHours() 
    {
        return hours;
    }
    /**
     * @return minute
     */
    public int getMinutes() 
    {
        return minutes;
    }
    /**
     * @return second
     */
    public int getSeconds() 
    {
        return seconds;
    }
    /**
     * Increments the hour
     */
    public void incrementHours()
    {
        hours++;
        if(hours == 24)
        {
            hours = 0;
        }
    }
    /**
     * Increments the minute
     */
    public void incrementMinutes()
    {
        minutes++;
        fixHours();
    }
    /**
     * Helper method resets the minute to 0
     */
    private void fixHours() {
        if(minutes == 60)
        {
            incrementHours();
            minutes = 0;
        }
    }
    /**
     * Increments the second
     */
    public void incrementSeconds()
    {
        seconds++;
        fixMinutes();
    }
    /**
     * Helper method resets the second to 0
     */
    private void fixMinutes() {
        if(seconds == 60)
        {
            incrementMinutes();
            seconds = 0;
        }
    }
    /**
     * Returns string of hour:minute:second
     */
    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }
    /**
     * Returns boolean determining whether 2 Time instances have the same time
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Time other = (Time) obj;
        if (hours != other.hours)
            return false;
        if (minutes != other.minutes)
            return false;
        if (seconds != other.seconds)
            return false;
        return true;
    }
}
