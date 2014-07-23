package at.bro.code.solr.springbase.entity;

import org.apache.solr.client.solrj.beans.Field;

public class PointTypeEntity
{

    @Field("id")
    private String id;

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

}
