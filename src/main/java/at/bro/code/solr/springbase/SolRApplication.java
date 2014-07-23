package at.bro.code.solr.springbase;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import at.bro.code.solr.springbase.entity.PointTypeEntity;
import at.bro.code.solr.springbase.repository.PointTypeExampleRepository;

@ComponentScan
@EnableSolrRepositories("at.bro.code.solr.springbase.repository")
@Configuration
public class SolRApplication
{
    public static void main(final String[] args)
    {
		final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SolRApplication.class);
        context.refresh();
        final SolrTemplate solr = context.getBean(SolrTemplate.class);

        final SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "my_id");
        solr.saveDocument(document);
        solr.commit();
        System.out.println("stored document");
        
        PointTypeExampleRepository repository = context.getBean(PointTypeExampleRepository.class);
        Iterable<PointTypeEntity> allDocuments = repository.findAll();
        for (PointTypeEntity e:allDocuments) {
        	System.out.println("retrieved document: " +e.getId());
        }
        
        System.exit(0);
    }
}
