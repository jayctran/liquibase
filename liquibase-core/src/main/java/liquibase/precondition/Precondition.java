package liquibase.precondition;

import liquibase.changelog.DatabaseChangeLog;
import liquibase.changelog.ChangeSet;
import liquibase.database.Database;
import liquibase.exception.*;
import liquibase.parser.core.ParsedNode;
import liquibase.resource.ResourceAccessor;
import liquibase.serializer.LiquibaseSerializable;

import java.text.ParseException;

/**
 * Marker interface for preconditions.  May become an annotation in the future.
 */
public interface Precondition extends LiquibaseSerializable {
    public String getName();

    public Warnings warn(Database database);

    public ValidationErrors validate(Database database);

    public void check(Database database, DatabaseChangeLog changeLog, ChangeSet changeSet) throws PreconditionFailedException, PreconditionErrorException;

    public void load(ParsedNode parsedNode, ResourceAccessor resourceAccessor) throws ParseException, SetupException;
}
