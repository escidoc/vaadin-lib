/**
 * 
 */
package de.escidoc.vaadin.retriever;

import gov.loc.www.zing.srw.SearchRetrieveRequestType;

import java.util.Collection;
import java.util.LinkedList;

import de.escidoc.core.client.AbstractHandlerClient;
import de.escidoc.core.client.AggregationDefinitionHandlerClient;
import de.escidoc.core.client.ContainerHandlerClient;
import de.escidoc.core.client.ContentModelHandlerClient;
import de.escidoc.core.client.ContentRelationHandlerClient;
import de.escidoc.core.client.ContextHandlerClient;
import de.escidoc.core.client.IngestHandlerClient;
import de.escidoc.core.client.ItemHandlerClient;
import de.escidoc.core.client.OrganizationalUnitHandlerClient;
import de.escidoc.core.client.PolicyDecisionPointHandlerClient;
import de.escidoc.core.client.PreprocessingHandlerClient;
import de.escidoc.core.client.ReportDefinitionHandlerClient;
import de.escidoc.core.client.ReportHandlerClient;
import de.escidoc.core.client.RoleHandlerClient;
import de.escidoc.core.client.ScopeHandlerClient;
import de.escidoc.core.client.SearchHandlerClient;
import de.escidoc.core.client.StagingHandlerClient;
import de.escidoc.core.client.StatisticDataHandlerClient;
import de.escidoc.core.client.UserAccountHandlerClient;
import de.escidoc.core.client.UserManagementWrapperClient;
import de.escidoc.core.client.exceptions.EscidocClientException;
import de.escidoc.core.client.exceptions.EscidocException;
import de.escidoc.core.client.exceptions.InternalClientException;
import de.escidoc.core.client.exceptions.TransportException;
import de.escidoc.core.resources.Resource;
import de.escidoc.core.resources.aa.role.Role;
import de.escidoc.core.resources.aa.useraccount.UserAccount;
import de.escidoc.core.resources.om.GenericVersionableResource;
import de.escidoc.core.resources.om.container.Container;
import de.escidoc.core.resources.om.contentRelation.ContentRelation;
import de.escidoc.core.resources.om.context.Context;
import de.escidoc.core.resources.om.item.Item;
import de.escidoc.core.resources.oum.OrganizationalUnit;
import de.escidoc.core.resources.sb.Record;
import de.escidoc.core.resources.sb.search.SearchRetrieveResponse;

/**
 * @author ASP
 * 
 */
public class EScidocObjectRetriever {

    /**
     * Gets a specified number of eSciDoc elements. Notifies if more objects
     * exist.
     * 
     * @param hc
     *            the client lib handler used to retrieve the objects.
     * @param request
     *            the cql request.
     * @param additionalParameter
     * 
     * 
     * 
     * 
     * 
     * 
     *            Only optional parameter is needed for containers, when members
     *            are requested.
     * @return a list of eSciDoc elements, if the request was valid and elements
     *         are present. An empty list, if the request was valid and but no
     *         elements are present. null, if the method has to be extended for
     *         the new type.
     * @throws EscidocClientException
     */
    public Collection<?> retriever(
        AbstractHandlerClient<?, ?> hc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType,
        Object... additionalParameter) throws EscidocClientException {

        if (hc instanceof AggregationDefinitionHandlerClient) {
            AggregationDefinitionHandlerClient adhc =
                (AggregationDefinitionHandlerClient) hc;
            return handleRequest(adhc, notifier, request, retrieveType);
        }
        else if (hc instanceof ContainerHandlerClient) {
            ContainerHandlerClient chc = (ContainerHandlerClient) hc;
            switch (retrieveType) {
                case RETRIEVE_CONTAINERS:
                    return handleRequest(chc, notifier, request, retrieveType);

                case RETRIEVE_MEMBERS:
                    return handleRequest(chc, notifier, request, retrieveType,
                        additionalParameter);
                default:
                    return null;
            }
        }
        else if (hc instanceof ContentModelHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof ContentRelationHandlerClient) {
            ContentRelationHandlerClient crhc =
                (ContentRelationHandlerClient) hc;
            return handleRequest(crhc, notifier, request, retrieveType);
        }
        else if (hc instanceof ContextHandlerClient) {
            ContextHandlerClient chc = (ContextHandlerClient) hc;
            switch (retrieveType) {
                case RETRIEVE_CONTEXTS:
                    return handleRequest(chc, notifier, request, retrieveType);
                case RETRIEVE_MEMBERS:
                    return handleRequest(chc, notifier, request, retrieveType,
                        additionalParameter);
                default:
                    return null;
            }
        }
        else if (hc instanceof IngestHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof ItemHandlerClient) {
            ItemHandlerClient ihc = (ItemHandlerClient) hc;
            return handleRequest(ihc, notifier, request, retrieveType);
        }
        else if (hc instanceof OrganizationalUnitHandlerClient) {
            OrganizationalUnitHandlerClient ouhc =
                (OrganizationalUnitHandlerClient) hc;
            return handleRequest(ouhc, notifier, request, retrieveType);
        }
        else if (hc instanceof PolicyDecisionPointHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof PreprocessingHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof PreprocessingHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof ReportDefinitionHandlerClient) {
            ReportDefinitionHandlerClient rdhc =
                (ReportDefinitionHandlerClient) hc;
            return handleRequest(rdhc, notifier, request, retrieveType);
        }
        else if (hc instanceof ReportHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof RoleHandlerClient) {
            RoleHandlerClient rhc = (RoleHandlerClient) hc;
            return handleRequest(rhc, notifier, request, retrieveType);
        }
        else if (hc instanceof ScopeHandlerClient) {
            ScopeHandlerClient shc = (ScopeHandlerClient) hc;
            return handleRequest(shc, notifier, request, retrieveType);
        }
        else if (hc instanceof SearchHandlerClient) {
            SearchHandlerClient shc = (SearchHandlerClient) hc;
            return handleRequest(shc, notifier, request, retrieveType,
                additionalParameter);
        }
        else if (hc instanceof StagingHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof StatisticDataHandlerClient) {
            // No supported retrieve operation!
        }
        else if (hc instanceof UserAccountHandlerClient) {
            UserAccountHandlerClient uahc = (UserAccountHandlerClient) hc;
            switch (retrieveType) {
                case RETRIEVE_GRANTS:
                    return handleRequestGrants(uahc, notifier, request,
                        retrieveType);
                case RETRIEVE_USER_ACCOUNTS:
                    return handleRequest(uahc, notifier, request, retrieveType);
            }
        }
        else if (hc instanceof UserManagementWrapperClient) {
            // No supported retrieve operation!
        }
        return null;
    }

    private Collection<?> handleRequest(
        AggregationDefinitionHandlerClient adhc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = adhc.retrieveAggregationDefinitions(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(adhc, s.getRecords());
    }

    private Collection<?> retrieve(
        AggregationDefinitionHandlerClient adhc, Collection<Record<?>> records) {

        Collection<Resource> results = new LinkedList<Resource>();

        for (Record<?> record : records) {
            Resource resource = adhc.getSRWResourceRecordData(record, Resource.class);
            if (resource != null) {
                results.add(resource);
            }
        }
        return results;
    }

    private Collection<?> handleRequest(
        SearchHandlerClient shc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType,
        Object para) throws InternalClientException, TransportException,
        EscidocClientException {

        SearchRetrieveResponse s = shc.search(request, (String) para);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(shc, s.getRecords());
    }

    private Collection<?> retrieve(
        SearchHandlerClient shc, Collection<Record<?>> records) {

        Collection<Resource> results = new LinkedList<Resource>();

        for (Record<?> record : records) {
            Resource resource = shc.getSRWResourceRecordData(record, Resource.class);
            if (resource != null) {
                results.add(resource);
            }
        }
        return results;
    }
    //Resource

    private Collection<?> handleRequest(
        ScopeHandlerClient shc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = shc.retrieveScopes(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(shc, s.getRecords());
    }

    private Collection<?> retrieve(
        ScopeHandlerClient shc, Collection<Record<?>> records) {
        
        Collection<Resource> results = new LinkedList<Resource>();

        for (Record<?> record : records) {
            Resource resource = shc.getSRWResourceRecordData(record, Resource.class);
            if (resource != null) {
                results.add(resource);
            }
        }
        return results;
    }

    private Collection<?> handleRequest(
        RoleHandlerClient rhc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = rhc.retrieveRoles(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(rhc, s.getRecords());
    }

    private Collection<?> retrieve(
        RoleHandlerClient rhc, Collection<Record<?>> records) {

        Collection<Role> results = new LinkedList<Role>();

        for (Record<?> record : records) {
            Role role = rhc.getSRWResourceRecordData(record, Role.class);
            if (role != null) {
                results.add(role);
            }
        }
        return results;
    }

    private Collection<?> handleRequest(
        ReportDefinitionHandlerClient rdhc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = rdhc.retrieveReportDefinitions(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(rdhc, s.getRecords());
    }

    private Collection<?> retrieve(
        ReportDefinitionHandlerClient rdhc, Collection<Record<?>> records) {
        
        Collection<Resource> results = new LinkedList<Resource>();

        for (Record<?> record : records) {
            Resource resource = rdhc.getSRWResourceRecordData(record, Resource.class);
            if (resource != null) {
                results.add(resource);
            }
        }
        return results;
    }

    private Collection<?> handleRequest(
        OrganizationalUnitHandlerClient ouhc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = ouhc.retrieveOrganizationalUnits(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(ouhc, s.getRecords());
    }

    private Collection<?> retrieve(
        OrganizationalUnitHandlerClient ouhc, Collection<Record<?>> records) {

        Collection<OrganizationalUnit> results =
            new LinkedList<OrganizationalUnit>();

        for (Record<?> record : records) {
            OrganizationalUnit result =
                ouhc.getSRWResourceRecordData(record, OrganizationalUnit.class);
            if (result != null) {
                results.add(result);
            }
        }
        return results;
    }

    private Collection<?> handleRequest(
        ContextHandlerClient chc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType,
        Object additionalParameter) throws EscidocException,
        InternalClientException, TransportException {

        SearchRetrieveResponse s =
            chc.retrieveMembers((String) additionalParameter, request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(chc, s.getRecords());
    }

    private Collection<?> retrieve(
        ContextHandlerClient chc, Collection<Record<?>> records) {

        Collection<Context> results = new LinkedList<Context>();

        for (Record record : records) {
            Context result = chc.getSRWResourceRecordData(record, Context.class);
            if (result != null) {
                results.add(result);
            }
        }
        return results;
    }

    private Collection<?> handleRequest(
        ContextHandlerClient chc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = chc.retrieveContexts(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(chc, s.getRecords());
    }

    private Collection<?> handleRequest(
        ContentRelationHandlerClient crhc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = crhc.retrieveContentRelations(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(crhc, s.getRecords());
    }

    private Collection<?> retrieve(
        ContentRelationHandlerClient crhc, Collection<Record<?>> records) {

        Collection<ContentRelation> results = new LinkedList<ContentRelation>();

        for (Record record : records) {
            ContentRelation contentRelation =
                crhc.getSRWResourceRecordData(record, ContentRelation.class);
            if (contentRelation != null) {
                results.add(contentRelation);
            }
        }
        return results;
    }

    private Collection<?> handleRequest(
        UserAccountHandlerClient uahc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = uahc.retrieveUserAccounts(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(uahc, s.getRecords());
    }

    private Collection<?> retrieve(
        UserAccountHandlerClient uahc, Collection<Record<?>> records) {

        Collection<UserAccount> results = new LinkedList<UserAccount>();

        for (Record record : records) {
            UserAccount result =
                uahc.getSRWResourceRecordData(record, UserAccount.class);
            if (result != null)
                results.add(result);
        }

        return results;
    }

    private Collection<?> handleRequestGrants(
        UserAccountHandlerClient uahc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = uahc.retrieveGrants(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieveGrants(uahc, s.getRecords());
    }

    private Collection<?> retrieveGrants(
        UserAccountHandlerClient uahc, Collection<Record<?>> records) {

        Collection<Resource> results = new LinkedList<Resource>();

        for (Record<?> record : records) {
            Resource resource = uahc.getSRWResourceRecordData(record, Resource.class);
            if (resource != null) {
                results.add(resource);
            }
        }
        return results;
    }

    private Collection<Container> handleRequest(
        ContainerHandlerClient chc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = chc.retrieveContainers(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(chc, s.getRecords());
    }

    private Collection<Container> retrieve(
        ContainerHandlerClient chc, Collection<Record<?>> records) {

        Collection<Container> containers = new LinkedList<Container>();

        for (Record<?> record : records) {
            Container container =
                chc.getSRWResourceRecordData(record, Container.class);
            if (container != null) {
                containers.add(container);
            }
        }
        return containers;
    }

    private Collection<GenericVersionableResource> handleRequest(
        ContainerHandlerClient chc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType,
        Object parent) throws EscidocException, InternalClientException,
        TransportException {

        SearchRetrieveResponse s =
            chc.retrieveMembers((Container) parent, request);
        notifyIfOutOfBounds(notifier, s);

        return retrieveMembers(chc, s.getRecords());
    }

    private Collection<GenericVersionableResource> retrieveMembers(
        ContainerHandlerClient chc, Collection<Record<?>> records) {

        Collection<GenericVersionableResource> generics = new LinkedList<GenericVersionableResource>();

        for (Record<?> record : records) {
            GenericVersionableResource generic =
                chc.getSRWResourceRecordData(record, GenericVersionableResource.class);
            if (generic != null) {
                generics.add(generic);
            }
        }
        return generics;
    }
    
    private void notifyIfOutOfBounds(Notifier notifier, SearchRetrieveResponse s) {

        int all = s.getNumberOfMatchingRecords();
        int current = s.getNumberOfResultingRecords();
        if (current < all) {
            notifier
                .notify("We could not retrieve all elements. More are present.");
        }
    }

    private Collection<Item> handleRequest(
        ItemHandlerClient ihc, Notifier notifier,
        SearchRetrieveRequestType request, RetrieveEnum retrieveType)
        throws EscidocException, InternalClientException, TransportException {

        SearchRetrieveResponse s = ihc.retrieveItems(request);
        notifyIfOutOfBounds(notifier, s);

        return retrieve(ihc, s.getRecords());
    }

    private Collection<Item> retrieve(
        ItemHandlerClient ihc, Collection<Record<?>> records) {

        final Collection<Item> items = new LinkedList<Item>();

        for (Record<?> record : records) {
            Item item = ihc.getSRWResourceRecordData(record, Item.class);
            if (item != null) {
                items.add(item);
            }
        }
        return items;
    }

}
