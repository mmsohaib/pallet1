

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hilton
 */
public class Frequency 
{
    
    private String ageGroup;
    private int count;
    private double totalCount;
    private double relativeFrequency;
    
    public Frequency()
    {
        ageGroup = "";
        count = 0;
        totalCount = 0;
        relativeFrequency = 0;
    }
    
    public Frequency(String ageGroup, int count, double totalCount, double relativeFrequency)
    {
        this.ageGroup = ageGroup;
        this.count = count;
        this.totalCount = totalCount;
        this.relativeFrequency = relativeFrequency;
    }

    /**
     * @return the ageGroup
     */
    public String getAgeGroup() {
        return ageGroup;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @return the totalCount
     */
    public double getTotalCount() {
        return totalCount;
    }

    /**
     * @return the relativeFrequency
     */
    public double getRelativeFrequency() {
        return relativeFrequency;
    }
    
}