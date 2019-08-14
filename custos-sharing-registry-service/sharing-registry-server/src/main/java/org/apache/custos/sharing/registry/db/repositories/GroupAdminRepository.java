package org.apache.custos.sharing.registry.db.repositories;

import org.apache.custos.sharing.registry.db.entities.GroupAdminEntity;
import org.apache.custos.sharing.registry.db.entities.GroupAdminPK;
import org.apache.custos.sharing.registry.models.GroupAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupAdminRepository extends AbstractRepository<GroupAdmin, GroupAdminEntity, GroupAdminPK> {

    private final static Logger logger = LoggerFactory.getLogger(GroupAdminRepository.class);

    public GroupAdminRepository() {
        super(GroupAdmin.class, GroupAdminEntity.class);
    }

}
