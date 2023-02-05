package spring.config.audit;

import org.hibernate.envers.RevisionListener;

public class PersonRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        PersonRevisionEntity personRevisionEntity = (PersonRevisionEntity) revisionEntity;
        personRevisionEntity.setUsername("Edwin Mendez");
    }
}
