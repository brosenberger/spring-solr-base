package at.bro.code.solr.springbase.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import at.bro.code.solr.springbase.entity.PointTypeEntity;

public interface PointTypeExampleRepository extends SolrCrudRepository<PointTypeEntity, String>
{

}
